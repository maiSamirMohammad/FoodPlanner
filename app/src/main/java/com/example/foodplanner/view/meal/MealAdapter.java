package com.example.foodplanner.view.meal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.models.SimpleMeal;

import java.util.ArrayList;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.Holder> {
    private final ArrayList<SimpleMeal> simpleMealList;
    private final OnMealClick listOnClickItem;

    public MealAdapter(ArrayList<SimpleMeal> simpleMealList, OnMealClick listOnClickItem) {
        this.simpleMealList = simpleMealList;
        this.listOnClickItem = listOnClickItem;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_with_favorite_btn, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        SimpleMeal simpleMeal = simpleMealList.get(position);
        holder.meal_name_tv.setText(simpleMeal.getStrMeal());
        holder.meal_id_tv.setText(String.valueOf(simpleMeal.getIdMeal()));
        Glide.with(holder.meal_photo.getContext()).load(simpleMeal.getStrMealThumb()).into(holder.meal_photo);
    }

    @Override
    public int getItemCount() {
        return simpleMealList.size();
    }


    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView meal_photo;
        public TextView meal_name_tv, meal_id_tv;

        public Holder(@NonNull View itemView) {
            super(itemView);
            meal_photo = itemView.findViewById(R.id.dish_image);
            meal_name_tv = itemView.findViewById(R.id.dish_name);
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

