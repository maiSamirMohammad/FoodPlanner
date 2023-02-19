package com.example.foodplanner.view.mealdetails;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.models.detailedmeal.DetailedMeal;
import com.example.foodplanner.models.FirebaseFirebaseRepository;
import com.example.foodplanner.models.detailedmeal.DetailedMealList;
import com.example.foodplanner.network.RetrofitClient;
import com.example.foodplanner.network.RetrofitInterface;
import com.example.foodplanner.view.HomeFragment;
import com.example.foodplanner.view.meal.MealBigAdapter;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ViewDetailsActivity extends AppCompatActivity {
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
                            mealDetailsAdapter = new MealDetailsAdapter(detailedMeals);
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
}