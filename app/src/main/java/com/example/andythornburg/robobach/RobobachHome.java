package com.example.andythornburg.robobach;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.andythornburg.robobach.http.GSONGetRequest;
import com.example.andythornburg.robobach.http.JSONPostRequest;
import com.example.andythornburg.robobach.model.User;
import com.google.gson.Gson;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexthornburg on 4/5/16.
 */
public class RobobachHome extends Activity {
    private static final String CLIENT_ID = "e393d0645bfb4da89e6630b9c4de723e";
    private static final String REDIRECT_URI = "robobach://callback";
    private static final int REQUEST_CODE = 1337;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private final String AUTH_SHARED_PREFS = "AUTH SHARED PREFS";
    private String spotifyBaseUrl = "https://api.spotify.com/v1/";
    private String mongoBaseUrl = ""
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mMenuTitles;
    private int GET = 0;
    private int POST = 1;
    private int PUT = 2;
    private int DELETE = 3;
    private int HEAD = 4;
    private int OPTIONS = 5;
    private int TRACE = 6;
    private int PATCH = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        AuthenticationRequest.Builder builder =
                new AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI);
        builder.setScopes(new String[]{"user-read-private", "streaming"});
        AuthenticationRequest request = builder.build();

        AuthenticationClient.openLoginActivity(this, REQUEST_CODE, request);
        mTitle = mDrawerTitle = getTitle();
        mMenuTitles = getResources().getStringArray(R.array.menu_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mMenuTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        Log.d("ITEM_ID",String.valueOf(item.getItemId()));
        switch(item.getItemId()) {
            case R.id.action_websearch:
                Toast.makeText(this, "OPEN Andy's Search", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {

        // update selected item and title, then close the drawer

        mDrawerList.setItemChecked(position, true);
        setTitle( mMenuTitles[position]);
        switch(mMenuTitles[position]){
            case "Request Song":{
                Intent intent = new Intent(this,SearchActivity.class);
                startActivity(intent);
            }
        }
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_CODE) {
            AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, intent);
            if (response.getType() == AuthenticationResponse.Type.TOKEN) {
                Log.d("OAUTH TOKEN", response.getAccessToken());
                SharedPreferences.Editor editor = getSharedPreferences(AUTH_SHARED_PREFS, MODE_PRIVATE).edit();
                editor.putString("OAUTH_TOKEN", response.getAccessToken());
                editor.commit();
                RequestQueue queue = Volley.newRequestQueue(this);
                Map<String,String> custHeaders = new HashMap<String,String>();
                custHeaders.put("Accept", "application/json");
                custHeaders.put("Authorization", "Bearer "+response.getAccessToken());
                String url = spotifyBaseUrl+"me";
                final User[] currentUser = {new User()};
                GSONGetRequest<User> stringRequest = new GSONGetRequest<User>(GET,url,User.class,custHeaders,
                        new Response.Listener<User>() {
                            @Override
                            public void onResponse(User response) {
                                TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
                                response.setPhoneNumber(tm.getLine1Number());
                                currentUser[0] = response;
                                Log.d("JSON RESPONSE","Response is: "+ response.getDisplayName());
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("JSON ERROR","COULD NOT STORE USER INFO IN DB");
                    }
                });
                User postUser = currentUser[0];
                queue.add(stringRequest);
                Gson gson = new Gson();
                String mongoUrl =
                try {
                    JSONObject json = new JSONObject(gson.toJson(postUser));
                    JSONPostRequest post = new JSONPostRequest(POST,url,json,custHeaders,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Log.d("JSON RESPONSE","Response is: "+ response.toString());
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("JSON ERROR","COULD NOT STORE USER INFO IN DB");
                        }
                    });
                    queue.add(post);
                } catch (JSONException e) {
                    Log.e("JSON OBJECT ERRROR", e.getMessage());
                }
            }

        }
    }

}
