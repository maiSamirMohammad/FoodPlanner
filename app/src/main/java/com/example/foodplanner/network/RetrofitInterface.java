package com.example.foodplanner.network;

import com.example.foodplanner.models.detailedmeal.DetailedMeal;
import com.example.foodplanner.models.MealList;
import com.example.foodplanner.models.search.Ingredient;
import com.example.foodplanner.models.search.RootCategories;
import com.example.foodplanner.models.search.RootIngredients;

import java.util.ArrayList;
import com.example.foodplanner.models.detailedmeal.DetailedMealList;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("random.php")
    Observable<MealList> getRandomMeal();

    @GET("filter.php")
    Observable<MealList> getFilteredMealsCountries(@Query("a") String country);

    @GET("filter.php")
    Observable<MealList> getFilteredMealsCategories(@Query("c") String category);
    @GET("filter.php")
    Observable<MealList> getFilteredMealsIngredients(@Query("i") String ingredient);

    @GET("lookup.php")
    Observable<DetailedMealList> getDetailedMeal(@Query("i") String detailedMeal);

    @GET("list.php?i=list")
    Observable<RootIngredients> getIngredient();

    @GET("categories.php")
    Observable<RootCategories> getAllCategories();
//    @GET("search.php?s=")
//    Single<MealList> getMealInfoByName(@Query("s") String name);
//    @GET("search.php")
//    Single<MealList> searchMealName(@Query("s") String mealName);
//    @GET("list.php?a=list")
//    Single<MealList> getArea();
}
