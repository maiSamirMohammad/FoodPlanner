package com.example.foodplanner.view.search;

import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.models.search.Category;
import com.example.foodplanner.models.search.Ingredient;

import java.util.ArrayList;

public interface AllIngredientsActivityInterface {

    public void getIngredients();
    public void onSuccessResult(ArrayList<Ingredient> ingredients);
    public void onFailureResult(String error);
    public void navigateToParticularIngredientMeals(String ingredientName);
}
