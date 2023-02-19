package com.example.foodplanner.view.weekplanner;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.models.detailedmeal.DetailedMeal;
import com.example.foodplanner.presenter.WeekPlanPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeekPlanActivity extends AppCompatActivity {

    private RecyclerView recyclerViewSaturday, recyclerViewSunday, recyclerViewMonday, recyclerViewTuesday, recyclerViewWednesday, recyclerViewThursday, recyclerViewFriday;

    private WeekPlanAdapter weekPlanAdapterSaturday, weekPlanAdapterSunday, weekPlanAdapterMonday, weekPlanAdapterTuesday, weekPlanAdapterWednesday, weekPlanAdapterThursday, weekPlanAdapterFriday;

    private List<DetailedMeal> mealsWeekPlanSaturday = new ArrayList<>(), mealsWeekPlanSunday = new ArrayList<>(), mealsWeekPlanMonday = new ArrayList<>(), mealsWeekPlanTuesday = new ArrayList<>(), mealsWeekPlanWednesday = new ArrayList<>(), mealsWeekPlanThursday = new ArrayList<>(), mealsWeekPlanFriday = new ArrayList<>();

    public static TextView tv_Saturday, tv_Sunday, tv_Monday, tv_Tuesday, tv_Wednesday, tv_Thursday, tv_Friday;

    private static final String TAG = "WeekPlanActivity";

    private WeekPlanPresenter weekPlanPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_plan);


        recyclerViewSaturday = findViewById(R.id.recyclerViewFavoriteMealsSaturday);
        recyclerViewSunday = findViewById(R.id.recyclerViewFavoriteMealsSunday);
        recyclerViewMonday = findViewById(R.id.recyclerViewFavoriteMealsMonday);
        recyclerViewTuesday = findViewById(R.id.recyclerViewFavoriteMealsTueday);
        recyclerViewWednesday = findViewById(R.id.recyclerViewFavoriteMealsWednesday);
        recyclerViewThursday = findViewById(R.id.recyclerViewFavoriteMealsThursday);
        recyclerViewFriday = findViewById(R.id.recyclerViewFavoriteMealsFriday);

        tv_Saturday = findViewById(R.id.tv_Saturday);
        tv_Sunday = findViewById(R.id.tv_Sunday);
        tv_Monday = findViewById(R.id.tv_Monday);
        tv_Tuesday = findViewById(R.id.tv_Tuesday);
        tv_Wednesday = findViewById(R.id.tv_Wednesday);
        tv_Thursday = findViewById(R.id.tv_Thursday);
        tv_Friday = findViewById(R.id.tv_Friday);

        List<RecyclerView> recyclerViewArrayList = new ArrayList<>();
        recyclerViewArrayList = Arrays.asList(recyclerViewSaturday, recyclerViewSunday, recyclerViewMonday, recyclerViewTuesday, recyclerViewWednesday, recyclerViewThursday, recyclerViewFriday);


        for (RecyclerView recyclerView : recyclerViewArrayList) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(linearLayoutManager);
        }

        weekPlanPresenter = new WeekPlanPresenter();
        List<DetailedMeal> mealsItemsArrayList = weekPlanPresenter.returnStoredMealsItems();
        List<DetailedMeal> returnStoredMealsItemsWithWeekDayNotNull = new ArrayList<>();

        for (DetailedMeal mealsItem : mealsItemsArrayList) {
            if (!mealsItem.getWeekDay().equals("NULL")) {
                returnStoredMealsItemsWithWeekDayNotNull.add(mealsItem);
            }
        }

        for (DetailedMeal mealsItem : returnStoredMealsItemsWithWeekDayNotNull) {
            switch (mealsItem.getWeekDay()) {
                case "Saturday":
                    mealsWeekPlanSaturday.add(mealsItem);
                    break;
                case "Sunday":
                    mealsWeekPlanSunday.add(mealsItem);
                    break;
                case "Monday":
                    mealsWeekPlanMonday.add(mealsItem);
                    break;
                case "Tuesday":
                    mealsWeekPlanTuesday.add(mealsItem);
                    break;
                case "Wednesday":
                    mealsWeekPlanWednesday.add(mealsItem);
                    break;
                case "Thursday":
                    mealsWeekPlanThursday.add(mealsItem);
                    break;
                case "Friday":
                    mealsWeekPlanFriday.add(mealsItem);
                    break;
            }
        }

        if (mealsWeekPlanSaturday.size() != 0) {
            tv_Saturday.setVisibility(View.VISIBLE);
            weekPlanAdapterSaturday = new WeekPlanAdapter(mealsWeekPlanSaturday);
            recyclerViewSaturday.setAdapter(weekPlanAdapterSaturday);
        }
        if (mealsWeekPlanSunday.size() != 0) {
            tv_Sunday.setVisibility(View.VISIBLE);
            weekPlanAdapterSunday = new WeekPlanAdapter(mealsWeekPlanSunday);
            recyclerViewSunday.setAdapter(weekPlanAdapterSunday);
        }
        if (mealsWeekPlanMonday.size() != 0) {
            tv_Monday.setVisibility(View.VISIBLE);
            weekPlanAdapterMonday = new WeekPlanAdapter(mealsWeekPlanMonday);
            recyclerViewMonday.setAdapter(weekPlanAdapterMonday);
        }
        if (mealsWeekPlanTuesday.size() != 0) {
            tv_Tuesday.setVisibility(View.VISIBLE);
            weekPlanAdapterTuesday = new WeekPlanAdapter(mealsWeekPlanTuesday);
            recyclerViewTuesday.setAdapter(weekPlanAdapterTuesday);
        }
        if (mealsWeekPlanWednesday.size() != 0) {
            tv_Wednesday.setVisibility(View.VISIBLE);
            weekPlanAdapterWednesday = new WeekPlanAdapter(mealsWeekPlanWednesday);
            recyclerViewWednesday.setAdapter(weekPlanAdapterWednesday);
        }
        if (mealsWeekPlanThursday.size() != 0) {
            tv_Thursday.setVisibility(View.VISIBLE);
            weekPlanAdapterThursday = new WeekPlanAdapter(mealsWeekPlanThursday);
            recyclerViewThursday.setAdapter(weekPlanAdapterThursday);
        }
        if (mealsWeekPlanFriday.size() != 0) {
            tv_Friday.setVisibility(View.VISIBLE);
            weekPlanAdapterFriday = new WeekPlanAdapter(mealsWeekPlanFriday);
            recyclerViewFriday.setAdapter(weekPlanAdapterFriday);
        }
    }


    @Override
    public void onPause() {
        super.onPause();

        mealsWeekPlanSaturday.clear();
        mealsWeekPlanSunday.clear();
        mealsWeekPlanMonday.clear();
        mealsWeekPlanTuesday.clear();
        mealsWeekPlanWednesday.clear();
        mealsWeekPlanThursday.clear();
        mealsWeekPlanFriday.clear();
    }
}