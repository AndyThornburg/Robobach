package com.example.andythornburg.robobach.model;

import java.util.List;

/**
 * Created by andythornburg on 4/6/16.
 */
public class Item {
    List<album> albums;
    int disc_number;
    int duration_ms;
    boolean explicit;
    List <external_ids> External_ids;
    String [] available_markets;

    public String[] getAvailable_markets() {
        return available_markets;
    }

    public void setAvailable_markets(String[] available_markets) {
        this.available_markets = available_markets;
    }

    public int getDisc_number() {
        return disc_number;
    }

    public void setDisc_number(int disc_number) {
        this.disc_number = disc_number;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public List<external_ids> getExternal_ids() {
        return External_ids;
    }

    public void setExternal_ids(List<external_ids> external_ids) {
        External_ids = external_ids;
    }

    public List<album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<album> albums) {
        this.albums = albums;
    }
}
