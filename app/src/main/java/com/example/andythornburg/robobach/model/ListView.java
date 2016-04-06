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

    public void setdiscnum(int discnum) {
        this.discnum = discnum;
    }

    public String getavailablemarkets() {
        return available_markets;
    }

    public void setavailablemarkets(String available_markets) {
        this.available_markets = available_markets;
    }

    public int getDurationms() { return duration_ms; }

    public void setDurationms(int durationms) {
        this.duration_ms = durationms;
    }

    public boolean getExplicit() { return explicit; }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public int getDiscNum() { return disc_number; }

    public void setDiscNum(int discnum) {
        this.discnum = discnum;
    }

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

    public boolean getPlayable() {return is_playable;}

    public void setPlayable(boolean is_playable) {
        this.is_playable = is_playable;
    }

    public String getPreviewurl() {return preview_url;}

    public void setPreviewurl(String preview_url) { this.preview_url = preview_url; }

    public int getTrackNumber() {return track_number;}

    public void setTrackNumber(int track_number) {
        this.track_number = track_number;
    }

    public String getType() {return type;}

    public void setType(String type) { this.type = type; }

    public String geturi() {return uri;}

    public void seturi(String uri) { this.uri = uri; }

}
