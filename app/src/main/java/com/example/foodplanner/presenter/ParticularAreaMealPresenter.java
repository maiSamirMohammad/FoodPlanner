package com.example.foodplanner.presenter;

import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.models.search.ParticularAreaMealRepository;
import com.example.foodplanner.view.search.ParticularAreaMealActivityInterface;

import java.util.ArrayList;
import java.util.List;

public class ParticularAreaMealPresenter {
    private  static ParticularAreaMealActivityInterface particularAreaMealInterface;

    public static void getParticularAreaMeals(String areaName, ParticularAreaMealActivityInterface particularAreaMealActivityInterface){
         particularAreaMealInterface=particularAreaMealActivityInterface;
         ParticularAreaMealRepository.getParticularAreaMeals(areaName);
    }
    public static void onSuccessResult(ArrayList<SimpleMeal> meals){
        particularAreaMealInterface.onSuccessResult(meals);
    }
    public static void onFailureResult(String error){
        particularAreaMealInterface.onFailureResult(error);
    }

}
