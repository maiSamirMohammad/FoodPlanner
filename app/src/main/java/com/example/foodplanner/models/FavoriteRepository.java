package com.example.foodplanner.models;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FavoriteRepository {
    private MealDAO dao;
    private static FavoriteRepository favoriteRepository = null;
    private LiveData<List<SimpleMeal>> storedMeals;


    private FavoriteRepository(Context context){
        AppDataBase db = AppDataBase.getInstance(context.getApplicationContext());
        dao = db.mealDAO();
        storedMeals = dao.getAllMeals();
    }

    public static FavoriteRepository getInstance(Context context){
        if(favoriteRepository == null){
            favoriteRepository = new FavoriteRepository(context);
        }
        return favoriteRepository;
    }

    public  void insertMovie(SimpleMeal meal){
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertAll(meal);
            }
        }).start();

    }


    public void deleteMeal(SimpleMeal meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.delete(meal);
            }
        }).start();
    }


    public LiveData<List<SimpleMeal>> getAllStoredMeals() {
        return storedMeals;
    }
}
