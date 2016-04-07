package com.example.andythornburg.robobach.model;

import java.util.List;

/**
 * Created by andythornburg on 4/6/16.
 */
public class images {
    int height;
    int url;
    int width;
    String name;
    String type;
    String uri;
    List <Artists> Artists;

    public List<com.example.andythornburg.robobach.model.Artists> getArtists() {
        return Artists;
    }

    public void setArtists(List<com.example.andythornburg.robobach.model.Artists> artists) {
        Artists = artists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
