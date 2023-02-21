package com.example.foodplanner.view.search;

import com.example.foodplanner.models.search.Area;
import com.example.foodplanner.models.search.Category;
import com.example.foodplanner.models.search.Ingredient;

import java.util.ArrayList;

public interface AllCategoriesActivityInterface {
    public void getCategories();
    public void onSuccessResult(ArrayList<Category> categories);
    public void onFailureResult(String error);
    public void navigateToParticularCategoryMeals(String categoryName);
}
