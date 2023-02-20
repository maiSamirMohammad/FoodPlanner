package com.example.foodplanner.models;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodplanner.models.detailedmeal.DetailedMeal;

@Database(entities = {DetailedMeal.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance = null;

    public abstract MealDAO mealDAO();

    //one thread at a time to access this method
    public static synchronized AppDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "meals")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}