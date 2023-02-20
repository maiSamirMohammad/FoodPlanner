package com.example.foodplanner.view;

import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.models.detailedmeal.DetailedMeal;

public interface AddAndRemoveFavoriteViewInterface {
    public void addMeal(DetailedMeal detailedMeal );
    public void removeMeal(DetailedMeal detailedMeal );

}
