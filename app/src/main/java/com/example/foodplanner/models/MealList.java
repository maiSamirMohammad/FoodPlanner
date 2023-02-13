package com.example.foodplanner.models;

import java.util.ArrayList;

public class MealList {
    private ArrayList<SimpleMeal> meals;

    public MealList(ArrayList<SimpleMeal> meals) {
        this.meals = meals;
    }

    public ArrayList<SimpleMeal> getMeals() {
        return meals;
    }


    public void setMeals(ArrayList<SimpleMeal> meals) {
        this.meals = meals;
    }
}