package com.example.andythornburg.robobach.model;

import java.util.List;

/**
 * Created by andythornburg on 4/6/16.
 */
public class Artists {
    List<ExternalUrl> ExternalUrl;
    String href;
    String id;
    String name;
    String type;
    String uri;

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

    public List<com.example.andythornburg.robobach.model.ExternalUrl> getExternalUrl() {
        return ExternalUrl;
    }

    public void setExternalUrl(List<com.example.andythornburg.robobach.model.ExternalUrl> externalUrl) {
        ExternalUrl = externalUrl;
    }



}
