package com.example.foodplanner.view.search;

import android.content.Context;

import com.example.foodplanner.models.SimpleMeal;

import java.util.ArrayList;
import java.util.List;

public interface ParticularAreaMealActivityInterface {
    public void getParticularAreaMeals(String areaName);
    public void onSuccessResult(ArrayList<SimpleMeal> meals);
    public void onFailureResult(String error);
    public void navigateToViewDetails(String position);
}
