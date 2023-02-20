package com.example.foodplanner.view.mealdetails;

import com.example.foodplanner.models.detailedmeal.DetailedMeal;

public interface MealDetailsInterface {
        public void onSuccessResult(DetailedMeal meals);
        public void onFailureResult(String error);
        public void navigateToCalendar(String meal);
}
