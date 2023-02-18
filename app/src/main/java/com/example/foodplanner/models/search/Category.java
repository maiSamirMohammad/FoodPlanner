package com.example.foodplanner.models.search;

public class Category {
    private String categoryName;
    private int imageResourceId;

    public Category(String categoryName, int imageResourceId) {
        this.categoryName = categoryName;
        this.imageResourceId = imageResourceId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
