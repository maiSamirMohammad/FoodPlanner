package com.example.foodplanner.models.search;

import android.util.Log;

import com.example.foodplanner.network.RetrofitInterface;
import com.example.foodplanner.presenter.AllIngredientPresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AllIngredientsRepository {
    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    public static void getAllIngredients(){


        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        RetrofitInterface retrofitInterface =retrofit.create(RetrofitInterface.class);
        Observable<RootIngredients> call = retrofitInterface.getIngredient();


        call.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
        ingredientArrayList -> {
            AllIngredientPresenter.onSuccessResult(ingredientArrayList.getMeals());


                        },
                        error->{
                            AllIngredientPresenter.onFailureResult(error.getMessage());

                        }

                );



    }
}
