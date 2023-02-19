package com.example.foodplanner.view.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.models.search.Category;
import com.example.foodplanner.models.search.Ingredient;
import com.example.foodplanner.presenter.AllIngredientPresenter;
import com.example.foodplanner.presenter.SearchPresenter;
import com.example.foodplanner.view.search.adapter.CategoryAdapter;
import com.example.foodplanner.view.search.adapter.IngredientAdapter;

import java.util.ArrayList;

public class AllIngredientsActivity extends AppCompatActivity implements AllIngredientsActivityInterface{
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    IngredientAdapter ingredientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_ingredients);


        getIngredients();
    }


    @Override
    public void getIngredients() {
        AllIngredientPresenter.getAllIngredients(this);
    }

    @Override
    public void onSuccessResult(ArrayList<Ingredient> ingredients) {
        recyclerView=findViewById(R.id.rv_ingredients);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ingredientAdapter= new IngredientAdapter(this,this,ingredients);
        recyclerView.setAdapter(ingredientAdapter);

    }

    @Override
    public void onFailureResult(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        Log.e("=====TAG=====", "onFailureResult: "+ error );
    }

    @Override
    public void navigateToParticularIngredientMeals(String ingredientName) {
        Intent intent = new Intent(this, ParticularIngredientMealsActivity.class);
        intent.putExtra("ingredientName",ingredientName);
        startActivity(intent);

    }
}