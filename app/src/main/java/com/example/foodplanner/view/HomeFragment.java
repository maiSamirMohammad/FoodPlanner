package com.example.foodplanner.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.models.MealList;
import com.example.foodplanner.network.RetrofitClient;
import com.example.foodplanner.network.RetrofitInterface;
import com.example.foodplanner.presenter.ParticularAreaMealPresenter;
import com.example.foodplanner.view.meal.MealAdapter;
import com.example.foodplanner.view.meal.MealBigAdapter;
import com.example.foodplanner.view.meal.OnMealClick;
import com.example.foodplanner.view.meal.viewDetailsActivity;

import java.util.ArrayList;
import java.util.Random;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment implements OnMealClick {
    private RecyclerView recyclerViewFirst;
    private RecyclerView recyclerViewSecond;
    private MealAdapter adapter;
    private MealBigAdapter adapterBig;
    private ArrayList<SimpleMeal> simpleMeals;
    private String[] randomCountries;
    private String[] randomCategories;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Retrofit retrofitClient = RetrofitClient.getClient();
        RetrofitInterface retrofitInterface = retrofitClient.create(RetrofitInterface.class);

        initializeVariables(view);
        //setListeners();
        apiFirstCall(retrofitInterface);
        apiSecondCall(retrofitInterface);
    }

    private void initializeVariables(View view)
    {
        recyclerViewFirst = view.findViewById(R.id.recycler_view_home);
        recyclerViewSecond = view.findViewById(R.id.recycler_view_home2);
        randomCategories = new String[]{"Beef","Breakfast","Chicken","Dessert","Goat","Lamb","Miscellaneous","Pasta","Pork","Seafood","Side","Starter","Vegan","Vegetarian"};
        randomCountries = new String[]{"American","British","Canadian","Chinese","Croatian","Dutch","Egyptian","French","Greek","Indian","Irish","Italian","Jamaican","Japanese","Kenyan","Malaysian","Mexican","Moroccan","Polish","Portuguese","Russian","Spanish","Thai","Tunisian","Turkish","Unknown","Vietnamese"};
    }

    private void apiFirstCall(RetrofitInterface retrofitInterface)
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

                        }
                );
    }
    private void apiSecondCall(RetrofitInterface retrofitInterface)
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

    @Override
    public void onClickIndex(int position) {
        Toast.makeText(getContext(), "HomeFragment", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), viewDetailsActivity.class);
        startActivity(intent);
    }
}