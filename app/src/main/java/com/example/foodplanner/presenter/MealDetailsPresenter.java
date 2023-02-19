package com.example.foodplanner.presenter;

import com.example.foodplanner.models.detailedmeal.DetailedMeal;
import com.example.foodplanner.models.detailedmeal.MealDetailsRepository;
import com.example.foodplanner.view.mealdetails.MealDetailsInterface;

public class MealDetailsPresenter {
    private  static MealDetailsInterface mealDetailsInterface;

    public static void getMealDetailsPresenter(String meal, MealDetailsInterface detailsInterface){
        mealDetailsInterface = detailsInterface;
        MealDetailsRepository.getDetailedMealRepository(meal);
    }
    public static void onSuccessResult(DetailedMeal meals){
        mealDetailsInterface.onSuccessResult(meals);
    }
    public static void onFailureResult(String error){
        mealDetailsInterface.onFailureResult(error);
    }
}
