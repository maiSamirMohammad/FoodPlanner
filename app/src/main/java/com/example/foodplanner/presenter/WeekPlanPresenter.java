package com.example.foodplanner.presenter;

import android.content.Context;

import com.example.foodplanner.models.detailedmeal.DetailedMeal;
import com.example.foodplanner.models.detailedmeal.DetailedMealList;

import java.util.ArrayList;

public class WeekPlanPresenter {
    private DetailedMealList repositoryLocal;
    private Context context;

    public ArrayList<DetailedMeal> returnStoredMealsItems() {
        return repositoryLocal.getMeals();
    }
}
