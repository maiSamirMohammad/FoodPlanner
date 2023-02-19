package com.example.foodplanner.presenter;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.foodplanner.models.FavoriteRepository;
import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.view.FavoriteFragmentInterface;

import java.util.List;

public class FavoritePresenter {
    static FavoriteFragmentInterface favoriteFragment;

    public static void addMeal(SimpleMeal meal, Context context){
        FavoriteRepository.getInstance(context).insertMovie(meal);
    }
    public static void getMeals(LifecycleOwner owner, Context context, FavoriteFragmentInterface favoriteFragmentInterface){
        favoriteFragment=favoriteFragmentInterface;
        FavoriteRepository.getInstance(context).getAllStoredMeals()
                .observe(owner, new Observer<List<SimpleMeal>>() {
            @Override
            public void onChanged(List<SimpleMeal> movies) {
                favoriteFragment.showData(movies);
            }
        });
    }
    public static void removeFromFav(SimpleMeal meal,Context context){
        FavoriteRepository.getInstance(context).deleteMeal(meal);
    }
}
