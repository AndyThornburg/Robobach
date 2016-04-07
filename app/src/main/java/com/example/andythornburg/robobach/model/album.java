package com.example.andythornburg.robobach.model;

import java.util.List;

/**
 * Created by andythornburg on 4/6/16.
 */
public class album {
    String albumType;
    String[] availableMarkets;
    List<ExternalUrl> externalUrls;
    List<images> images;
    String href;
    String id;
    String name;
    String popularity;
    String preview_url;
    String track_number;
    String type;
    String uri;

    public void setName(String name) {
        this.name = name;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public String getTrack_number() {
        return track_number;
    }

    public void setTrack_number(String track_number) {
        this.track_number = track_number;
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

    public List<com.example.andythornburg.robobach.model.images> getImages() {
        return images;
    }

    public void setImages(List<com.example.andythornburg.robobach.model.images> images) {
        this.images = images;
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

    public List<ExternalUrl> getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(List<ExternalUrl> externalUrls) {
        this.externalUrls = externalUrls;
    }

    public String[] getAvailableMarkets() {
        return availableMarkets;
    }

    public void setAvailableMarkets(String[] availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

}