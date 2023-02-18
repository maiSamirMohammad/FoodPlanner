package com.example.foodplanner.models.search;

import android.util.Log;

import com.example.foodplanner.models.MealList;
import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.network.RetrofitInterface;
import com.example.foodplanner.presenter.ParticularAreaMealPresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParticularAreaMealRepository {
    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    public static void getParticularAreaMeals(String areaName){

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface =retrofit.create(RetrofitInterface.class);
        Observable<MealList> call = retrofitInterface.getFilteredMealsCountries(areaName);

//        call.enqueue(new Callback<MealList>() {
//            @Override
//            public void onResponse(Call<MealList> call, Response<MealList> response) {
//                if(response.isSuccessful()){
//                    ParticularAreaMealPresenter.onSuccessResult(response.body().getMeals());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MealList> call, Throwable t) {
//                ParticularAreaMealPresenter.onFailureResult(t.getCause().toString());
//            }
//
//
//
//        });

        call.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        myResponse -> {
                        ParticularAreaMealPresenter.onSuccessResult(myResponse.getMeals());

                        },
                        error->{
                            ParticularAreaMealPresenter.onFailureResult(error.getMessage());

                        }
                );

    }
}
