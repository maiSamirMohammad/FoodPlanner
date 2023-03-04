package com.example.foodplanner.view.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.models.SimpleMeal;

import com.example.foodplanner.presenter.ParticularAreaMealPresenter;
import com.example.foodplanner.view.mealdetails.ViewDetailsActivity;
import com.example.foodplanner.view.search.adapter.ParticularAreaAdapter;

import java.util.ArrayList;


import java.util.Locale;


public class ParticularAreaMealActivity extends AppCompatActivity implements ParticularAreaMealActivityInterface{
    String areaName;
    TextView tvArea;
    RecyclerView recyclerView;
    GridLayoutManager gridlayoutManager;
    ParticularAreaAdapter particularAreaAdapter;
    SearchView searchView;
    ArrayList<SimpleMeal> mealsByArea=new ArrayList<>();
    ArrayList<SimpleMeal> displayList=new ArrayList<>();
    ImageView closeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particular_area_meal);

        recyclerView= findViewById(R.id.rv_particular_area_meal);
        gridlayoutManager =new GridLayoutManager(this,2);
        gridlayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridlayoutManager);
        particularAreaAdapter= new ParticularAreaAdapter(new ArrayList<>(),this);
        recyclerView.setAdapter(particularAreaAdapter);

        tvArea=findViewById(R.id.tv_particular_area);
        Intent myIntent = getIntent();
        if (myIntent != null) {
            areaName = myIntent.getStringExtra("areaName");
            tvArea.setText(areaName);
            getParticularAreaMeals(areaName);
        }

        closeScreen=findViewById(R.id.iv_close_search_by_particular_area);
        closeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        searchView=findViewById(R.id.sv_search_in_particular_area);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (!newText.isEmpty()){
                    displayList.clear();
                    particularAreaAdapter.setList(displayList);
                    particularAreaAdapter.notifyDataSetChanged();
                    Log.i("TAG", "onQueryTextChange displayList: "+displayList);
                    Log.i("TAG", "onQueryTextChange mealsByArea: "+mealsByArea);
                    String search = newText.toLowerCase(Locale.ROOT);
                    for (SimpleMeal meal :mealsByArea) {
                        if (meal.getStrMeal().toLowerCase(Locale.ROOT).startsWith(search)) {
                            displayList.add(meal);
                        }
                    }
                    particularAreaAdapter.setList(displayList);
                    particularAreaAdapter.notifyDataSetChanged();

                }else{
                    displayList.clear();
                    displayList.addAll(mealsByArea);
                    particularAreaAdapter.setList(displayList);
                    particularAreaAdapter.notifyDataSetChanged();


                }

                return true;
            }
        });
    }

    @Override
    public void getParticularAreaMeals(String areaName) {
         ParticularAreaMealPresenter.getParticularAreaMeals(areaName ,this);
    }

    @Override
    public void onSuccessResult(ArrayList<SimpleMeal> meals) {
        //send data to the adapter :D
        mealsByArea.addAll(meals);
        displayList.addAll(meals);
        particularAreaAdapter.setList(displayList);
        particularAreaAdapter.notifyDataSetChanged();



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