package com.ujjwal.instagram.models;

public class StoryModel{

    private String name;
    private int dailyPhoto, views;
    private String sId;

    public StoryModel(String sId, String name, int dailyPhoto, int views) {
        this.sId = sId;
        this.name = name;
        this.dailyPhoto = dailyPhoto;
        this.views = views;
    }

    public StoryModel(String name, int dailyPhoto)
    {
        this.dailyPhoto = dailyPhoto;
        this.name = name;
    }
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDailyPhoto() {
        return dailyPhoto;
    }

    public void setDailyPhoto(int dailyPhoto) {
        this.dailyPhoto = dailyPhoto;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
