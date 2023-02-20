package com.example.foodplanner.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodplanner.models.detailedmeal.DetailedMeal;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

@Dao
public interface MealDAO {
    @Query("SELECT * From DetailedMeal")
    Observable<List<DetailedMeal>> getAllMeals();

//    @Query("SELECT * FROM singleMeal WHERE name LIKE :first " + "LIMIT 1")
//    Movie findMovieByName(String first);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(DetailedMeal meal);

    @Delete
    void delete(DetailedMeal meal);
}