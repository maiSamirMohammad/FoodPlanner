package com.example.foodplanner.network;

import com.example.foodplanner.models.MealList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("random.php")
    Call<MealList> getRandomMeals();

    @GET("filter.php")
    Call<MealList> getFilteredMealsCountries(@Query("a") String country);

    @GET("filter.php")
    Call<MealList> getFilteredMealsCategories(@Query("c") String Category);
}
