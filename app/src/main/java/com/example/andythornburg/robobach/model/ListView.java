package com.example.andythornburg.robobach.model;

/**
 * Created by andythornburg on 4/6/16.
 */


public class ListView {
    public int discnum;
    public String available_markets;
    public int disc_number;
    public int duration_ms;
    public boolean explicit;
    public String href;
    public String id;
    public boolean is_playable;
    public String name;
    public String preview_url;
    public int track_number;
    public String type;
    public String uri;

    public int getdiscnum() {return discnum;}

    public String getavailablemarkets() {
        return available_markets;
    }

    public int getDurationms() { return duration_ms; }

    public boolean getExplicit() { return explicit; }

    public int getDiscNum() { return disc_number; }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean setPlayable() {return is_playable;}

    public String getPreview_url() {return preview_url;}

    public int getTrackNumber() {return track_number;}

    public String getType() {return type;}

    public String geturi() {return uri;}

}
