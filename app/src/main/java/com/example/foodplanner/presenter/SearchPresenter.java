package com.example.foodplanner.presenter;

import com.example.foodplanner.models.search.AllAreas;
import com.example.foodplanner.models.search.AllCategories;
import com.example.foodplanner.models.search.Area;
import com.example.foodplanner.models.search.Category;

public class SearchPresenter {
public Area[] getAreas(){
    return AllAreas.getInstance().getAllAreas();
}
public Category[] getCategories(){
    return AllCategories.getInstance().getAllCategories();
}

}
