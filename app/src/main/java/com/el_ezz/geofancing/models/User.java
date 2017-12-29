package com.el_ezz.geofancing.models;

public class User {

    private String id;
    private String username;
    private double lat;
    private double lang;
    private String dateCreate;
    private String dateUpdate;

    public User() {
    }

    public User(String id, String username, double lat, double lang, String dateCreate, String dateUpdate) {
        this.id = id;
        this.username = username;
        this.lat = lat;
        this.lang = lang;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLang() {
        return lang;
    }

    public void setLang(double lang) {
        this.lang = lang;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}