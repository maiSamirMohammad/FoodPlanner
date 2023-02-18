package com.example.foodplanner.view.search;

import com.example.foodplanner.models.search.Area;
import com.example.foodplanner.models.search.Category;

public interface AllCategoriesActivityInterface {
    public Category[] getCategories();
    public void navigateToParticularCategoryMeals(String categoryName);
}
