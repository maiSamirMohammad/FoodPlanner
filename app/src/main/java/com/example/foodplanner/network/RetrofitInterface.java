package com.example.foodplanner.network;

import com.example.foodplanner.models.MealList;
import com.example.foodplanner.models.search.Ingredient;
import com.example.foodplanner.models.search.RootIngredients;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("random.php")
    Observable<MealList> getRandomMeal();

    @GET("filter.php")
    Observable<MealList> getFilteredMealsCountries(@Query("a") String country);

    @GET("filter.php")
    Observable<MealList> getFilteredMealsCategories(@Query("c") String category);



//    @GET("categories.php")
//    Single<MealList> getAllCategories();
//    @GET("search.php?s=")
//    Single<MealList> getMealInfoByName(@Query("s") String name);
//    @GET("search.php")
//    Single<MealList> searchMealName(@Query("s") String mealName);
//    @GET("list.php?a=list")
//    Single<MealList> getArea();
    @GET("list.php?i=list")
    Observable<RootIngredients> getIngredient();
}
