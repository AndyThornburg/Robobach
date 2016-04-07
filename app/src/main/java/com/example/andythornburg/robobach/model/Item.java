package com.example.andythornburg.robobach.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andythornburg on 4/6/16.
 */
public class Item {
    private List<Album> albums;
    private List<Artists> artists;
    @SerializedName("available_markets")
    private String[] availableMarkets;
    @SerializedName("disc_number")
    private int discNumber;
    @SerializedName("duration_ms")
    private int durationMillis;
    private boolean explicit;
    @SerializedName("external_ids")
    private ExternalId externalId;
    @SerializedName("esternal_urls")
    private ExternalUrl externalUrl;
    private String href;
    private String id;
    private String name;
    private int popularity;
    @SerializedName("preview_url")
    private String previewUrl;
    @SerializedName("track_number")
    private int trackNumber;
    private String track;
    private String uri;

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Artists> getArtists() {
        return artists;
    }

    public void setArtists(List<Artists> artists) {
        this.artists = artists;
    }

    public String[] getAvailableMarkets() {
        return availableMarkets;
    }

    public void setAvailableMarkets(String[] availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(int discNumber) {
        this.discNumber = discNumber;
    }

    public int getDurationMillis() {
        return durationMillis;
    }

    public void setDurationMillis(int durationMillis) {
        this.durationMillis = durationMillis;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public ExternalId getExternalId() {
        return externalId;
    }

    public void setExternalId(ExternalId externalId) {
        this.externalId = externalId;
    }

    public ExternalUrl getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(ExternalUrl externalUrl) {
        this.externalUrl = externalUrl;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}