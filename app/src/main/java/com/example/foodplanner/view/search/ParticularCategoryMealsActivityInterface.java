package com.example.foodplanner.view.search;

import com.example.foodplanner.models.SimpleMeal;

import java.util.ArrayList;

public interface ParticularCategoryMealsActivityInterface {
    public void getParticularCategoryMeals(String categoryName);
    public void onSuccessResult(ArrayList<SimpleMeal> meals);
    public void onFailureResult(String error);
    public void navigateToViewDetails(String position);
}
