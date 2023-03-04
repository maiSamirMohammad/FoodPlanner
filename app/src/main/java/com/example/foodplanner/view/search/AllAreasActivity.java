package com.example.foodplanner.view.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import com.example.foodplanner.R;
import com.example.foodplanner.models.search.Area;
import com.example.foodplanner.presenter.SearchPresenter;
import com.example.foodplanner.view.search.adapter.AreaAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AllAreasActivity extends AppCompatActivity implements AllAreasActivityInterface {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    AreaAdapter areaAdapter;
    SearchView searchView;
    List<Area> areas=new ArrayList<>();
    List<Area> displayList=new ArrayList<>();
    ImageView closeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_areas);

        recyclerView=findViewById(R.id.rv_areas);
        searchView=findViewById(R.id.sv_search_area);
        closeScreen=findViewById(R.id.iv_close_search_by_area);
        closeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        areas.addAll(getAreas());
        displayList.addAll(getAreas());

        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        areaAdapter= new AreaAdapter(this,displayList);
        recyclerView.setAdapter(areaAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!newText.isEmpty()){
                    displayList.clear();
                    String search = newText.toLowerCase(Locale.ROOT);
                    for (Area area :areas) {
                        if (area.getAreaName().toLowerCase(Locale.ROOT).startsWith(search)) {
                            displayList.add(area);
                        }
                    }
                    // myAdapter.setList(displayList);
                    areaAdapter.notifyDataSetChanged();

                }else{
                    displayList.clear();
                    displayList.addAll(areas);
                    // myAdapter.setList(displayList);
                    areaAdapter.notifyDataSetChanged();


                }

                return true;
            }
        });



    }

    @Override
    public List<Area> getAreas() {
        return new SearchPresenter().getAreas();
    }

    @Override
    public void navigateToParticularAreaMeal(String areaName) {
        Intent intent = new Intent(this, ParticularAreaMealActivity.class);
        intent.putExtra("areaName",areaName);
        startActivity(intent);

    }
}