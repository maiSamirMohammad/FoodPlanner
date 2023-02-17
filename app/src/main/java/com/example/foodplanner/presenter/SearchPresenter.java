package com.example.foodplanner.presenter;

import com.example.foodplanner.models.search.AllAreas;
import com.example.foodplanner.models.search.Area;

public class SearchPresenter {
public Area[] getAreas(){
    return AllAreas.getInstance().getAllAreas();
}

}
