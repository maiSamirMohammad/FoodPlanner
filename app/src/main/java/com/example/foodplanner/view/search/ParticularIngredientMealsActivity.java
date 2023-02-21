package com.example.foodplanner.view.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.presenter.ParticularCategoryMealsPresenter;
import com.example.foodplanner.presenter.ParticularIngredientMealsPresenter;
import com.example.foodplanner.view.mealdetails.ViewDetailsActivity;
import com.example.foodplanner.view.search.adapter.ParticularCategoryAdapter;
import com.example.foodplanner.view.search.adapter.ParticularIngredientAdapter;

import java.util.ArrayList;

public class ParticularIngredientMealsActivity extends AppCompatActivity implements ParticularIngredientMealsActivityInterface {
    String ingredientName;
    TextView tvIngredient;
    RecyclerView recyclerView;
    GridLayoutManager gridlayoutManager;
    ParticularIngredientAdapter particularIngredientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particular_ingredient_meals);

        tvIngredient=findViewById(R.id.tv_particular_ingredient);
        Intent myIntent = getIntent();
        if (myIntent != null) {
            ingredientName = myIntent.getStringExtra("ingredientName");
            tvIngredient.setText(ingredientName);
            getParticularIngredientMeals(ingredientName);

        }
    }

    @Override
    public void getParticularIngredientMeals(String ingredientName) {
        ParticularIngredientMealsPresenter.getParticularIngredientMeals(ingredientName ,this);


    }

    @Override
    public void onSuccessResult(ArrayList<SimpleMeal> meals) {
        //send data to the adapter :D
        recyclerView= findViewById(R.id.rv_particular_ingredient_meals);
        gridlayoutManager =new GridLayoutManager(this,2);
        gridlayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridlayoutManager);
        particularIngredientAdapter= new ParticularIngredientAdapter(meals,this);
        recyclerView.setAdapter(particularIngredientAdapter);

    }

    @Override
    public void onFailureResult(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToViewDetails(String position) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;
        sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("mealcurrentid", position);
        editor.apply();
        Intent intent = new Intent(this, ViewDetailsActivity.class);
        startActivity(intent);

    }
}