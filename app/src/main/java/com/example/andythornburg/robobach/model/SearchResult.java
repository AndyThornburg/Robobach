package com.example.andythornburg.robobach.model;

import java.util.List;

/**
 * Created by andythornburg on 4/6/16.
 */
public class SearchResult {
    public String href;
    List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}