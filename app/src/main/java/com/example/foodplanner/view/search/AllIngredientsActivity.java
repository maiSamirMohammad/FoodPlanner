package com.example.foodplanner.view.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.models.search.Category;
import com.example.foodplanner.models.search.Ingredient;
import com.example.foodplanner.presenter.AllIngredientPresenter;
import com.example.foodplanner.presenter.SearchPresenter;
import com.example.foodplanner.view.search.adapter.CategoryAdapter;
import com.example.foodplanner.view.search.adapter.IngredientAdapter;

import java.util.ArrayList;
import java.util.Locale;

public class AllIngredientsActivity extends AppCompatActivity implements AllIngredientsActivityInterface{
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    IngredientAdapter ingredientAdapter;
    SearchView searchView;
    ArrayList<Ingredient> ingredientArrayList=new ArrayList<>();
    ArrayList<Ingredient> displayList=new ArrayList<>();
    ImageView closeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_ingredients);

        recyclerView=findViewById(R.id.rv_ingredients);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ingredientAdapter= new IngredientAdapter(this,this,new ArrayList<>());
        recyclerView.setAdapter(ingredientAdapter);
        closeScreen=findViewById(R.id.close_all_ingredients_activity);
        closeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getIngredients();
        searchView=findViewById(R.id.sv_by_ingredient);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (!newText.isEmpty()){
                    displayList.clear();
                    ingredientAdapter.setList(displayList);
                    ingredientAdapter.notifyDataSetChanged();

                    String search = newText.toLowerCase(Locale.ROOT);
                    for (Ingredient ingredient :ingredientArrayList) {
                        if (ingredient.getStrIngredient().toLowerCase(Locale.ROOT).startsWith(search)) {
                            displayList.add(ingredient);
                        }
                    }
                    ingredientAdapter.setList(displayList);
                    ingredientAdapter.notifyDataSetChanged();

                }else{
                    displayList.clear();
                    displayList.addAll(ingredientArrayList);
                    ingredientAdapter.setList(displayList);
                    ingredientAdapter.notifyDataSetChanged();


                }

                return true;
            }
        });


    }


    @Override
    public void getIngredients() {
        AllIngredientPresenter.getAllIngredients(this);
    }

    @Override
    public void onSuccessResult(ArrayList<Ingredient> ingredients) {

        ingredientArrayList.addAll(ingredients);
        displayList.addAll(ingredients);
        ingredientAdapter.setList(displayList);
        ingredientAdapter.notifyDataSetChanged();

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