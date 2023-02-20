package com.example.foodplanner.presenter;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.foodplanner.models.FavoriteRepository;
import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.models.detailedmeal.DetailedMeal;
import com.example.foodplanner.view.FavoriteFragmentInterface;

import java.util.List;

public class FavoritePresenter {
    static FavoriteFragmentInterface favoriteFragment;

    public static void addMeal(DetailedMeal detailedMeal, Context context){
        FavoriteRepository.getInstance(context).insertMeal(detailedMeal);
    }
    public static void getMeals(LifecycleOwner owner, Context context, FavoriteFragmentInterface favoriteFragmentInterface){
        favoriteFragment=favoriteFragmentInterface;
        FavoriteRepository.getInstance(context).getAllStoredMeals()
                .observe(owner, new Observer<List<DetailedMeal>>() {
            @Override
            public void onChanged(List<DetailedMeal> meals) {
                favoriteFragment.showData(meals);
            }
        });
    }
    public static void removeFromFav(DetailedMeal detailedMeal,Context context){
        FavoriteRepository.getInstance(context).deleteMeal(detailedMeal);
    }
}
