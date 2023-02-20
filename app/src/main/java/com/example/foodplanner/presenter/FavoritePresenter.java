package com.example.foodplanner.presenter;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.foodplanner.models.FavoriteRepository;
import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.models.detailedmeal.DetailedMeal;
import com.example.foodplanner.view.FavoriteFragmentInterface;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavoritePresenter {
    static FavoriteFragmentInterface favoriteFragment;

    public static void addMeal(DetailedMeal detailedMeal, Context context){
        FavoriteRepository.getInstance(context).insertMeal(detailedMeal);
    }
    public static void getMeals(LifecycleOwner owner, Context context, FavoriteFragmentInterface favoriteFragmentInterface){
        favoriteFragment=favoriteFragmentInterface;
        Observable<List<DetailedMeal>> myFavoriteMeals=FavoriteRepository.getInstance(context).getAllStoredMeals();
        myFavoriteMeals.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(meals -> {
                    favoriteFragment.showData(meals);
                        },
                        throwable -> {
                            favoriteFragment.showDataFailed(throwable.getCause().getMessage());
                        }

                );

    }
    public static void removeFromFav(DetailedMeal detailedMeal,Context context){
        FavoriteRepository.getInstance(context).deleteMeal(detailedMeal);
    }
}
