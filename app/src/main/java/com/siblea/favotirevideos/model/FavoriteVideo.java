package com.siblea.favotirevideos.model;

public class FavoriteVideo {

    private int id;
    private String name;
    private String location;
    private String url;

    public FavoriteVideo() {

    }

    public FavoriteVideo(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public FavoriteVideo(int id, String name, String location, String url) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
