package com.example.foodplanner.models;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.foodplanner.models.detailedmeal.DetailedMeal;

import java.util.List;

public class FavoriteRepository {
    private MealDAO dao;
    private static FavoriteRepository favoriteRepository = null;
    private LiveData<List<DetailedMeal>> storedMeals;


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

    public  void insertMeal(DetailedMeal detailedMeal){
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertAll(detailedMeal);
            }
        }).start();

    }


    public void deleteMeal(DetailedMeal detailedMeal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.delete(detailedMeal);
            }
        }).start();
    }


    public LiveData<List<DetailedMeal>> getAllStoredMeals() {
        return storedMeals;
    }
}
