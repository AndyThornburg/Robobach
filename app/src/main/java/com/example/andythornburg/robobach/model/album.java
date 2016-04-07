package com.example.andythornburg.robobach.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alexthornburg on 4/6/16.
 */
public class Album {
    @SerializedName("album_type")
    private String albumType;
    @SerializedName("available_markets")
    private String[] markets;
    @SerializedName("external_urls")
    private ExternalUrl externalUrls;
    private String href;
    private String id;
    private List<Image> images;
    private String name;
    private String type;
    private String uri;

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    public String[] getMarkets() {
        return markets;
    }

    public void setMarkets(String[] markets) {
        this.markets = markets;
    }

    public ExternalUrl getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrl externalUrls) {
        this.externalUrls = externalUrls;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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
}
