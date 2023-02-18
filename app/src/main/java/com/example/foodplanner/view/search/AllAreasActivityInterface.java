package com.example.foodplanner.view.search;

import com.example.foodplanner.models.search.Area;

public interface AllAreasActivityInterface {
    public Area[] getAreas();
    public void navigateToParticularAreaMeal(String areaName);
}
