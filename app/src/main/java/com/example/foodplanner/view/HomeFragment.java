package com.example.foodplanner.view;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.models.MealList;
import com.example.foodplanner.network.RetrofitClient;
import com.example.foodplanner.network.RetrofitInterface;
import com.example.foodplanner.presenter.FavoritePresenter;
import com.example.foodplanner.view.meal.MealAdapter;
import com.example.foodplanner.view.meal.MealBigAdapter;
import com.example.foodplanner.view.meal.OnMealClick;
import com.example.foodplanner.view.mealdetails.ViewDetailsActivity;

import java.util.ArrayList;
import java.util.Random;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment implements OnMealClick {
    private RecyclerView recyclerViewFirst;
    private RecyclerView recyclerViewSecond;
    private MealAdapter adapter;
    private MealBigAdapter adapterBig;
    private ArrayList<SimpleMeal> simpleMeals;
    private String[] randomCountries;
    private String[] randomCategories;
    Retrofit retrofitClient;
    RetrofitInterface retrofitInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        retrofitClient = RetrofitClient.getClient();
        retrofitInterface = retrofitClient.create(RetrofitInterface.class);

        initializeVariables(view);
        //setListeners();
        apiFirstCall();
        apiSecondCall();
    }

    private void initializeVariables(View view)
    {
        recyclerViewFirst = view.findViewById(R.id.recycler_view_home);
        recyclerViewSecond = view.findViewById(R.id.recycler_view_home2);
        randomCategories = new String[]{"Beef","Chicken","Dessert","Lamb","Miscellaneous","Pork","Seafood","Side","Vegetarian"};
    }

    private void apiFirstCall()
    {
        Observable<MealList> callFirst = retrofitInterface.getRandomMeal();


        callFirst.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        myResponse -> {
                            simpleMeals = myResponse.getMeals();
                            recyclerViewFirst.setHasFixedSize(true);
                            adapterBig = new MealBigAdapter(simpleMeals, HomeFragment.this);
                            recyclerViewFirst.setAdapter(adapterBig);
                        },
                        error->{
                            error.printStackTrace();
                        }
                );
    }
    private void apiSecondCall()
    {
        Observable<MealList> callSecond = retrofitInterface.getFilteredMealsCategories(randomCategories[new Random().nextInt(randomCategories.length)]);

        callSecond.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        myResponse -> {
                            simpleMeals = myResponse.getMeals();
                            adapter = new MealAdapter(simpleMeals, HomeFragment.this);
                            recyclerViewSecond.setAdapter(adapter);
                        },
                        error->{
                            error.printStackTrace();
                        }
                );
    }
    private void setListeners()
    {
//        icon.setOnCheckedChangeListener((buttonView, isChecked) ->{
//            if (isChecked){
//                Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_LONG).show();
//            }else {
//                Toast.makeText(getApplicationContext(),"bye bye",Toast.LENGTH_LONG).show();
//            }
//        } );
    }

    public void onClickIndex(String position) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;
        sharedPreferences = getContext().getSharedPreferences("my_preferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("mealcurrentid", position);
        editor.apply();

        Intent intent = new Intent(getContext(), ViewDetailsActivity.class);
        startActivity(intent);
    }


}