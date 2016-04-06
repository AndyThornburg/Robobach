package com.example.andythornburg.robobach;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.andythornburg.robobach.http.GSONRequest;
import com.example.andythornburg.robobach.model.Track;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;
import com.spotify.sdk.android.player.Config;
import com.spotify.sdk.android.player.ConnectionStateCallback;
import com.spotify.sdk.android.player.Player;
import com.spotify.sdk.android.player.PlayerNotificationCallback;
import com.spotify.sdk.android.player.PlayerState;
import com.spotify.sdk.android.player.Spotify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchActivity extends Activity implements
        PlayerNotificationCallback, ConnectionStateCallback {

    // TODO: Replace with your client ID
    private static final String CLIENT_ID = "e393d0645bfb4da89e6630b9c4de723e";
    // TODO: Replace with your redirect URI
    private static final String REDIRECT_URI = "robobach://callback";
    // Request code that will be passed together with authentication result to the onAuthenticationResult callback
    // Can be any integer
    private static final int REQUEST_CODE = 1337;
    private Player mPlayer;
    // List view
    private ListView lv;
    // Listview Adapter
    ArrayAdapter<String> adapter;
    // Search EditText
    EditText inputSearch;
    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Listview Data
        SharedPreferences prefs = getSharedPreferences("AUTH SHARED PREFS", MODE_PRIVATE);
        RequestQueue queue = Volley.newRequestQueue(this);
        Map<String,String> custHeaders = new HashMap<String,String>();
        custHeaders.put("Accept", "application/json");
//        custHeaders.put("Authorization", "Bearer "+ response.getAccessToken());
        String url = "https://api.spotify.com/v1/tracks/{id}"+"me";
        GSONRequest<Track> stringRequest = new GSONRequest<Track>(url,Track.class,custHeaders,
                new Response.Listener<Track>() {
                    @Override
                    public void onResponse(Track response) {
                        Log.d("JSON RESPONSE","Response is: "+ response.getDisplayName());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("JSON ERROR","COULD NOT STORE USER INFO IN DB");
            }
        });
        queue.add(stringRequest);
        String Results[] = {

        };

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<Track>
        lv.setAdapter(adapter);

        AuthenticationRequest.Builder builder =
                new AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI);
        builder.setScopes(new String[]{"user-read-private", "streaming"});
        AuthenticationRequest request = builder.build();

        AuthenticationClient.openLoginActivity(this, REQUEST_CODE, request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // Check if result comes from the correct activity
        if (requestCode == REQUEST_CODE) {
            AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, intent);
            if (response.getType() == AuthenticationResponse.Type.TOKEN) {
                Config playerConfig = new Config(this, response.getAccessToken(), CLIENT_ID);
                mPlayer = Spotify.getPlayer(playerConfig, this, new Player.InitializationObserver() {
                    @Override
                    public void onInitialized(Player player) {
                        mPlayer.addConnectionStateCallback(SearchActivity.this);
                        mPlayer.addPlayerNotificationCallback(SearchActivity.this);
                        mPlayer.play("spotify:track:2TpxZ7JUBn3uw46aR7qd6V");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.e("SearchActivity", "Could not initialize player: " + throwable.getMessage());
                    }
                });
            }
        }
    }
    @Override
    public void onLoggedIn() {
        Log.d("SearchActivity", "Track logged in");
    }

    @Override
    public void onLoggedOut() {
        Log.d("SearchActivity", "Track logged out");
    }

    @Override
    public void onLoginFailed(Throwable error) {
        Log.d("SearchActivity", "Login failed");
    }

    @Override
    public void onTemporaryError() {
        Log.d("Activity", "Temporary error occurred");
    }

    @Override
    public void onConnectionMessage(String message) {
        Log.d("SearchActivity", "Received connection message: " + message);
    }

    @Override
    public void onPlaybackEvent(EventType eventType, PlayerState playerState) {
        Log.d("SearchActivity", "Playback event received: " + eventType.name());
        switch (eventType) {
            // Handle event type as necessary
            default:
                break;
        }
    }

    @Override
    public void onPlaybackError(ErrorType errorType, String errorDetails) {
        Log.d("SearchActivity", "Playback error received: " + errorType.name());
        switch (errorType) {
            // Handle error type as necessary
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        // VERY IMPORTANT! This must always be called or else you will leak resources
        Spotify.destroyPlayer(this);
        super.onDestroy();
    }
}