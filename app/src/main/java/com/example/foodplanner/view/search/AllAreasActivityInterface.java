package com.example.foodplanner.view.search;

import com.example.foodplanner.models.search.Area;

import java.util.List;

public interface AllAreasActivityInterface {
    public List<Area> getAreas();
    public void navigateToParticularAreaMeal(String areaName);
}