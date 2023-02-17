package com.example.foodplanner.view.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodplanner.R;
import com.example.foodplanner.models.search.Area;
import com.example.foodplanner.presenter.SearchPresenter;
import com.example.foodplanner.view.search.adapter.AreaAdapter;

public class AllAreasActivity extends AppCompatActivity implements AllAreasActivityInterface {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    AreaAdapter areaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_areas);

        recyclerView=(RecyclerView) findViewById(R.id.rv_areas);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        areaAdapter= new AreaAdapter(this,getAreas());
        recyclerView.setAdapter(areaAdapter);
    }

    @Override
    public Area[] getAreas() {
        return new SearchPresenter().getAreas();
    }
}