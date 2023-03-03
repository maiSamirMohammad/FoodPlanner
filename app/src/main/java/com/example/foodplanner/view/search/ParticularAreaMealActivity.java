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
import com.example.foodplanner.view.mealdetails.ViewDetailsActivity;
import com.example.foodplanner.view.search.adapter.ParticularAreaAdapter;

import java.util.ArrayList;

public class ParticularAreaMealActivity extends AppCompatActivity implements ParticularAreaMealActivityInterface{
    String areaName;
    TextView tvArea;
    RecyclerView recyclerView;
    GridLayoutManager gridlayoutManager;
    ParticularAreaAdapter particularAreaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particular_area_meal);

        tvArea=findViewById(R.id.tv_particular_area);
        Intent myIntent = getIntent();
        if (myIntent != null) {

            areaName = myIntent.getStringExtra("areaName");
            tvArea.setText(areaName);
            getParticularAreaMeals(areaName);

        }
    }

    @Override
    public void getParticularAreaMeals(String areaName) {
         ParticularAreaMealPresenter.getParticularAreaMeals(areaName ,this);
    }

    @Override
    public void onSuccessResult(ArrayList<SimpleMeal> meals) {
        //send data to the adapter :D
        recyclerView= findViewById(R.id.rv_particular_area_meal);
        gridlayoutManager =new GridLayoutManager(this,2);
        gridlayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridlayoutManager);
        particularAreaAdapter= new ParticularAreaAdapter(meals,this);
        recyclerView.setAdapter(particularAreaAdapter);

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