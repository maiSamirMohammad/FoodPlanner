package com.example.foodplanner.models;

import java.util.ArrayList;

public class DetailedMealList {
        private ArrayList<DetailedMeal> meals;

        public DetailedMealList(ArrayList<DetailedMeal> meals) {
            this.meals = meals;
        }

        public ArrayList<DetailedMeal> getMeals() {
            return meals;
        }

        public void setMeals(ArrayList<DetailedMeal> meals) {
            this.meals = meals;
        }
}
