package com.example.andythornburg.robobach.model;

import java.util.List;

/**
 * Created by alexthornburg on 4/6/16.
 */
public class Track {
    private String href;
    private List<Item> items;
    private int limit;
    private String next;
    private int offset;
    private String previus;
    private int total;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getPrevius() {
        return previus;
    }

    public void setPrevius(String previus) {
        this.previus = previus;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
