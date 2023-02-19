package com.example.foodplanner.view;

import com.example.foodplanner.models.SimpleMeal;

import java.util.List;

public interface FavoriteFragmentInterface {
    public void showData(List<SimpleMeal> meals);
    public void removeMeal(SimpleMeal meal);
}
