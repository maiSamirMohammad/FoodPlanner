package com.example.foodplanner.models.search;

public class Area {
    private String areaName;
    private int imageResourceId;

    public Area(String areaName, int imageResourceId) {
        this.areaName = areaName;
        this.imageResourceId = imageResourceId;
    }

    public String getAreaName() {
        return areaName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
