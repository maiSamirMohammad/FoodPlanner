package com.example.foodplanner.models.search;

import com.example.foodplanner.models.MealList;
import com.example.foodplanner.network.RetrofitInterface;
import com.example.foodplanner.presenter.ParticularIngredientMealsPresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParticularIngredientMealsRepository {
    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    public static void getParticularIngredientMeals(String IngredientName){

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface =retrofit.create(RetrofitInterface.class);
        Observable<MealList> call = retrofitInterface.getFilteredMealsIngredients(IngredientName);



        call.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        myResponse -> {
                            ParticularIngredientMealsPresenter.onSuccessResult(myResponse.getMeals());

                        },
                        error->{
                            ParticularIngredientMealsPresenter.onFailureResult(error.getMessage());

                        }
                );

    }
}
