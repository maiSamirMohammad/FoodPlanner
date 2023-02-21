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
import com.example.foodplanner.presenter.AllCategoriesPresenter;
import com.example.foodplanner.presenter.AllIngredientPresenter;
import com.example.foodplanner.presenter.SearchPresenter;
import com.example.foodplanner.view.search.adapter.AreaAdapter;
import com.example.foodplanner.view.search.adapter.CategoryAdapter;

import java.util.ArrayList;

public class AllCategoriesActivity extends AppCompatActivity implements AllCategoriesActivityInterface {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        getCategories();


    }

    @Override
    public void getCategories() {
        AllCategoriesPresenter.getAllCategories(this);
    }

    @Override
    public void onSuccessResult(ArrayList<Category> categories) {
        recyclerView=findViewById(R.id.rv_categories);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        categoryAdapter= new CategoryAdapter(this,this,categories);
        recyclerView.setAdapter(categoryAdapter);
    }

    @Override
    public void onFailureResult(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        Log.e("=====TAG=====", "onFailureResult: "+ error );

    }

    @Override
    public void navigateToParticularCategoryMeals(String categoryName) {
        Intent intent = new Intent(this, ParticularCategoryMealsActivity.class);
        intent.putExtra("categoryName",categoryName);
        startActivity(intent);

    }
}