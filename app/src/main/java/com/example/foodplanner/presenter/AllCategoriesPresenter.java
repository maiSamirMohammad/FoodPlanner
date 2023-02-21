package com.example.foodplanner.presenter;

import com.example.foodplanner.models.search.AllCategoriesRepository;
import com.example.foodplanner.models.search.AllIngredientsRepository;
import com.example.foodplanner.models.search.Category;
import com.example.foodplanner.view.search.AllCategoriesActivityInterface;

import java.util.ArrayList;

public class AllCategoriesPresenter {
    private  static AllCategoriesActivityInterface allCategoriesActivityInterface;

    public static void getAllCategories(AllCategoriesActivityInterface allCategoriesInterface){
        allCategoriesActivityInterface= allCategoriesInterface;
        AllCategoriesRepository.getAllCategories();
    }
    public static void onSuccessResult(ArrayList<Category> categories){
        allCategoriesActivityInterface.onSuccessResult(categories);
    }
    public static void onFailureResult(String error){
        allCategoriesActivityInterface.onFailureResult(error);
    }
}
