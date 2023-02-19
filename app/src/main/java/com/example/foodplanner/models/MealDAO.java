package com.example.foodplanner.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealDAO {
    @Query("SELECT * From singleMeal")
    LiveData<List<SimpleMeal>> getAllMeals();

//    @Query("SELECT * FROM singleMeal WHERE name LIKE :first " + "LIMIT 1")
//    Movie findMovieByName(String first);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(SimpleMeal meal);

    @Delete
    void delete(SimpleMeal meal);
}