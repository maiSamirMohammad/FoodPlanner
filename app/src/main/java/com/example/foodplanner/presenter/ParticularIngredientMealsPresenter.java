package com.example.foodplanner.presenter;

import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.models.search.ParticularIngredientMealsRepository;
import com.example.foodplanner.view.search.ParticularIngredientMealsActivityInterface;

import java.util.ArrayList;

public class ParticularIngredientMealsPresenter {
    private  static ParticularIngredientMealsActivityInterface particularIngredientMealsActivityInterface;

    public static void getParticularIngredientMeals(String IngredientName,ParticularIngredientMealsActivityInterface particularIngredientMealsInterface){
        particularIngredientMealsActivityInterface=particularIngredientMealsInterface;
        ParticularIngredientMealsRepository.getParticularIngredientMeals(IngredientName);
    }
    public static void onSuccessResult(ArrayList<SimpleMeal> meals){
        particularIngredientMealsActivityInterface.onSuccessResult(meals);
    }
    public static void onFailureResult(String error){
        particularIngredientMealsActivityInterface.onFailureResult(error);
    }
}
