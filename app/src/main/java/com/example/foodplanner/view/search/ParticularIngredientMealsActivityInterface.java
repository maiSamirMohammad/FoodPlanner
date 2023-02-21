package com.example.foodplanner.view.search;

import com.example.foodplanner.models.SimpleMeal;

import java.util.ArrayList;

public interface ParticularIngredientMealsActivityInterface {
    public void getParticularIngredientMeals(String ingredientName);
    public void onSuccessResult(ArrayList<SimpleMeal> meals);
    public void onFailureResult(String error);
    public void navigateToViewDetails(String position);
}
