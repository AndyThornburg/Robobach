package com.example.andythornburg.robobach.model;

import java.util.List;

/**
 * Created by alexthornburg on 4/6/16.
 */
public class Playlist {
    private String id;
    private List<String> songIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getSongIds() {
        return songIds;
    }

    public void setSongIds(List<String> songIds) {
        this.songIds = songIds;
    }
}
