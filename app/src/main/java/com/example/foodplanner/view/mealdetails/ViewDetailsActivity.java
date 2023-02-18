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
import com.example.foodplanner.models.DetailedMeal;
import com.example.foodplanner.models.DetailedMealList;
import com.example.foodplanner.models.FirebaseFirebaseRepository;
import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.network.RetrofitClient;
import com.example.foodplanner.network.RetrofitInterface;
import com.example.foodplanner.view.HomeFragment;
import com.example.foodplanner.view.meal.MealAdapter;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ViewDetailsActivity extends AppCompatActivity {
    private ImageView imageMeal;
    private YouTubePlayerView videoView;
    private TextView nameMeal, country, instructions;
    private RecyclerView ingredientsRecycler;
    private DetailedMeal detailedMeal;
    String mealId;
    private RetrofitInterface retrofitInterface;
    private Retrofit retrofitClient;
    List<String> ingredients;
    Context context;
    MealDetailsAdapter mealDetailsAdapter;
    ArrayList<DetailedMeal> detailedMealList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        initValues();
        Toast.makeText(this, "details - Meal ID: " + mealId, Toast.LENGTH_SHORT).show();
        apiCall();
        //setMealValues();
    }

    private void initValues()
    {
        imageMeal = findViewById(R.id.iv_details_food);
        videoView = findViewById(R.id.video);
        nameMeal = findViewById(R.id.tv_details_name_of_meal);
        country = findViewById(R.id.tv_details_country);
        instructions = findViewById(R.id.tv_details_instructions);
        ingredientsRecycler = findViewById(R.id.rv_ingredients);

        mealId = FirebaseFirebaseRepository.getInstance(this).getSharedPreferences().getString("mealcurrentid",null);
        retrofitClient = RetrofitClient.getClient();
        retrofitInterface = retrofitClient.create(RetrofitInterface.class);
    }
    private void apiCall()
    {
        Call<DetailedMealList> callFirst = retrofitInterface.getDetailedMeal(mealId);
        callFirst.enqueue(new Callback<DetailedMealList>() {
            @Override
            public void onResponse(Call<DetailedMealList> call, Response<DetailedMealList> response) {
                if (response.isSuccessful()) {
                    response.body().getMeals();
                    detailedMealList = response.body().getMeals();
                    mealDetailsAdapter = new MealDetailsAdapter(detailedMealList, null);
                    ingredientsRecycler.setAdapter(mealDetailsAdapter);
                }
            }
            @Override
            public void onFailure(Call<DetailedMealList> call, Throwable t) {

            }
        });
    }

    private void setMealValues()
    {
        nameMeal.setText(detailedMeal.getStrMeal());
        country.setText(detailedMeal.getStrArea());
        instructions.setText(detailedMeal.getStrInstructions());
        Glide.with(context).load(detailedMeal.getStrMealThumb()).into(imageMeal);

        getLifecycle().addObserver((LifecycleObserver) videoView);
        if( !detailedMeal.getStrYoutube().isEmpty()) {
            String[] split = detailedMeal.getStrYoutube().split("=");
            videoView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = split[1];
                    youTubePlayer.loadVideo(videoId, 0);
                }
            });
        }

        if (!detailedMeal.getStrIngredient1().isEmpty()&& !detailedMeal.getStrMeasure1().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient1() + " : " + detailedMeal.getStrMeasure1());
        }
        if (!detailedMeal.getStrIngredient2().isEmpty()&& !detailedMeal.getStrMeasure2().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient2() + " : " + detailedMeal.getStrMeasure2());
        }
        if (!detailedMeal.getStrIngredient3().isEmpty()&& !detailedMeal.getStrMeasure3().isEmpty()) {
            ingredients.add( detailedMeal.getStrIngredient3() + " : " + detailedMeal.getStrMeasure3());
        }
        if (!detailedMeal.getStrIngredient4().isEmpty()&& !detailedMeal.getStrMeasure4().isEmpty()) {
            ingredients.add( detailedMeal.getStrIngredient4() + " : " + detailedMeal.getStrMeasure4());
        }
        if (!detailedMeal.getStrIngredient5().isEmpty()&& !detailedMeal.getStrMeasure5().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient5() + " : " + detailedMeal.getStrMeasure5());
        }
        if (!detailedMeal.getStrIngredient6().isEmpty()&& !detailedMeal.getStrMeasure6().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient6() + " : " + detailedMeal.getStrMeasure6());
        }
        if (!detailedMeal.getStrIngredient7().isEmpty()&& !detailedMeal.getStrMeasure7().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient7() + " : " + detailedMeal.getStrMeasure7());
        }
        if (!detailedMeal.getStrIngredient8().isEmpty()&& !detailedMeal.getStrMeasure8().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient8() + " : " + detailedMeal.getStrMeasure8());
        }
        if (!detailedMeal.getStrIngredient9().isEmpty()&& !detailedMeal.getStrMeasure9().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient9() + " : " + detailedMeal.getStrMeasure9());
        }
        if (!detailedMeal.getStrIngredient10().isEmpty()&& !detailedMeal.getStrMeasure10().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient10() + " : " + detailedMeal.getStrMeasure10());
        }
        if (!detailedMeal.getStrIngredient11().isEmpty()&& !detailedMeal.getStrMeasure11().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient11() + " : " + detailedMeal.getStrMeasure11());
        }
        if (!detailedMeal.getStrIngredient12().isEmpty()&& !detailedMeal.getStrMeasure12().isEmpty()) {
            ingredients.add( detailedMeal.getStrIngredient12() + " : " + detailedMeal.getStrMeasure12());
        }
        if (!detailedMeal.getStrIngredient13().isEmpty()&& !detailedMeal.getStrMeasure13().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient13() + " : " + detailedMeal.getStrMeasure13());
        }
        if (!detailedMeal.getStrIngredient14().isEmpty()&& !detailedMeal.getStrMeasure14().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient14() + " : " + detailedMeal.getStrMeasure14());
        }
        if (!detailedMeal.getStrIngredient15().isEmpty()&& !detailedMeal.getStrMeasure15().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient15() + " : " + detailedMeal.getStrMeasure15());
        }
        if (!detailedMeal.getStrIngredient16().isEmpty()&& !detailedMeal.getStrMeasure16().isEmpty()) {
            ingredients.add( detailedMeal.getStrIngredient16() + " : " + detailedMeal.getStrMeasure16());
        }
        if (!detailedMeal.getStrIngredient17().isEmpty()&& !detailedMeal.getStrMeasure17().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient17() + " : " + detailedMeal.getStrMeasure17());
        }
        if (!detailedMeal.getStrIngredient18().isEmpty()&& !detailedMeal.getStrMeasure18().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient18() + " : " + detailedMeal.getStrMeasure18());
        }
        if (!detailedMeal.getStrIngredient19().isEmpty()&& !detailedMeal.getStrMeasure19().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient19() + " : " + detailedMeal.getStrMeasure19());
        }
        if (!detailedMeal.getStrIngredient20().isEmpty()&& !detailedMeal.getStrMeasure20().isEmpty()) {
            ingredients.add(detailedMeal.getStrIngredient20() + " : " + detailedMeal.getStrMeasure20());
        }

//        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(requireContext(),ingredients);
//        ingredientsRecycler.setAdapter(ingredientsAdapter);

    }
}