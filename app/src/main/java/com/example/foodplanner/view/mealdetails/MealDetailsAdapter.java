package com.example.foodplanner.view.mealdetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.models.DetailedMeal;
import com.example.foodplanner.models.DetailedMealList;
import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.view.meal.MealAdapter;
import com.example.foodplanner.view.meal.OnMealClick;

import java.util.ArrayList;

public class MealDetailsAdapter extends RecyclerView.Adapter<com.example.foodplanner.view.mealdetails.MealDetailsAdapter.Holder>{
    private final ArrayList<DetailedMeal> detailedMealList;
    private final OnMealClick listOnClickItem;

    public MealDetailsAdapter(ArrayList<DetailedMeal> detailedMealList, OnMealClick listOnClickItem) {
        this.detailedMealList = detailedMealList;
        this.listOnClickItem = listOnClickItem;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_details, parent, false);
        return new com.example.foodplanner.view.mealdetails.MealDetailsAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        DetailedMeal detailedMeal = detailedMealList.get(position);
        holder.meal_name_tv.setText(detailedMeal.getStrMeal());
        holder.meal_id_tv.setText(String.valueOf(detailedMeal.getIdMeal()));
        Glide.with(holder.meal_photo.getContext()).load(detailedMeal.getStrMealThumb()).into(holder.meal_photo);
    }

    @Override
    public int getItemCount() {
        return detailedMealList.size();
    }


    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView meal_photo;
        public TextView meal_name_tv, meal_id_tv;

        public Holder(@NonNull View itemView) {
            super(itemView);
            meal_photo = itemView.findViewById(R.id.iv_details_food);
            meal_name_tv = itemView.findViewById(R.id.tv_details_name_of_meal);
            meal_id_tv = itemView.findViewById(R.id.dish_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listOnClickItem != null)
                    {
                        listOnClickItem.onClickIndex(meal_id_tv.getText().toString());
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
        }
    }
}



