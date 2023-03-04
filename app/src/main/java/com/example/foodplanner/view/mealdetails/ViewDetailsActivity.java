package com.example.foodplanner.view.mealdetails;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.models.detailedmeal.DetailedMeal;
import com.example.foodplanner.models.FirebaseFirebaseRepository;
import com.example.foodplanner.models.detailedmeal.DetailedMealList;
import com.example.foodplanner.network.RetrofitClient;
import com.example.foodplanner.network.RetrofitInterface;
import com.example.foodplanner.presenter.FavoritePresenter;
import com.example.foodplanner.view.AddAndRemoveFavoriteViewInterface;
import com.example.foodplanner.view.calendar.CalendarfromViewDetails;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;


public class ViewDetailsActivity extends AppCompatActivity implements MealDetailsInterface,AddAndRemoveFavoriteViewInterface {

    private RecyclerView recyclerViewDetails;
    private MealDetailsAdapter mealDetailsAdapter;
    String mealId;
    private RetrofitInterface retrofitInterface;
    ArrayList<DetailedMeal> detailedMeals;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        initValues();
        callApi();
    }

    private void callApi()
    {
        Observable<DetailedMealList> callFirst = retrofitInterface.getDetailedMeal(mealId);
        callFirst.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        myResponse -> {
                            detailedMeals = myResponse.getMeals();
                            recyclerViewDetails.setHasFixedSize(true);

                            mealDetailsAdapter = new MealDetailsAdapter(detailedMeals, this,this);



                            recyclerViewDetails.setAdapter(mealDetailsAdapter);
                        },
                        error->{
                            error.printStackTrace();
                        }
                );
    }
    private void initValues()
    {
        recyclerViewDetails = findViewById(R.id.rv_view_details);
        mealId = FirebaseFirebaseRepository.getInstance(this).getSharedPreferences().getString("mealcurrentid",null);
        Retrofit retrofitClient = RetrofitClient.getClient();
        retrofitInterface = retrofitClient.create(RetrofitInterface.class);
    }


    @Override
    public void onSuccessResult(DetailedMeal meals) {
    }

    @Override
    public void onFailureResult(String error) {
    }

    @Override
    public void navigateToCalendar(String meal) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;
        sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("mealcurrentname", meal);
        editor.apply();

        Intent intent = new Intent(this, CalendarfromViewDetails.class);
        startActivity(intent);
    }

    @Override
    public void addMeal(DetailedMeal detailedMeal ) {
        FavoritePresenter.addMeal(detailedMeal,this);

    }
    @Override
    public void removeMeal(DetailedMeal detailedMeal ) {
        FavoritePresenter.removeFromFav(detailedMeal,this);
    }


}