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
import com.example.foodplanner.presenter.ParticularAreaMealPresenter;
import com.example.foodplanner.presenter.ParticularCategoryMealsPresenter;
import com.example.foodplanner.view.mealdetails.ViewDetailsActivity;
import com.example.foodplanner.view.search.adapter.ParticularAreaAdapter;
import com.example.foodplanner.view.search.adapter.ParticularCategoryAdapter;

import java.util.ArrayList;

public class ParticularCategoryMealsActivity extends AppCompatActivity implements ParticularCategoryMealsActivityInterface{
    String categoryName;
    TextView tvCategory;
    RecyclerView recyclerView;
    GridLayoutManager gridlayoutManager;
    ParticularCategoryAdapter particularCategoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particular_category_meals);

        tvCategory=findViewById(R.id.tv_particular_category);
        Intent myIntent = getIntent();
        if (myIntent != null) {
            categoryName = myIntent.getStringExtra("categoryName");
            tvCategory.setText(categoryName);
            getParticularCategoryMeals(categoryName);

        }
    }

    @Override
    public void getParticularCategoryMeals(String categoryName) {
        ParticularCategoryMealsPresenter.getParticularCategoryMeals(categoryName ,this);
    }

    @Override
    public void onSuccessResult(ArrayList<SimpleMeal> meals) {
        //send data to the adapter :D
        recyclerView= findViewById(R.id.rv_particular_category_meals);
        gridlayoutManager =new GridLayoutManager(this,2);
        gridlayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridlayoutManager);
        particularCategoryAdapter= new ParticularCategoryAdapter(meals,this);
        recyclerView.setAdapter(particularCategoryAdapter);

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