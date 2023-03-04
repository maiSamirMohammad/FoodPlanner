package com.example.foodplanner.view.search.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.view.search.ParticularCategoryMealsActivityInterface;

import java.util.ArrayList;

public class ParticularCategoryAdapter  extends RecyclerView.Adapter<ParticularCategoryAdapter.MyViewHolder> {
    private static final String TAG = "MyAdapter";

    ArrayList<SimpleMeal> meals;
    ParticularCategoryMealsActivityInterface particularCategoryMealsActivityInterface;

    public void setList(ArrayList<SimpleMeal> updatedMeals){this.meals=updatedMeals;}


    public ParticularCategoryAdapter(ArrayList<SimpleMeal> meals, ParticularCategoryMealsActivityInterface particularCategoryMealsActivityInterface) {
        this.meals = meals;
        this.particularCategoryMealsActivityInterface = particularCategoryMealsActivityInterface;
    }


    @NonNull
    @Override
    public ParticularCategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_with_favorite_btn, parent, false);
        ParticularCategoryAdapter.MyViewHolder myViewHolder = new ParticularCategoryAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ParticularCategoryAdapter.MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: ");
        SimpleMeal current = meals.get(position);
        holder.meal_name_tv.setText(current.getStrMeal());
                Glide.with(holder.meal_photo.getContext())
                .load(current.getStrMealThumb())
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(holder.meal_photo);

        holder.meal_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                particularCategoryMealsActivityInterface.navigateToViewDetails(Long.toString(current.getIdMeal()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView meal_photo;
        TextView meal_name_tv, meal_id_tv;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            meal_photo = itemView.findViewById(R.id.dish_image);
            meal_name_tv = itemView.findViewById(R.id.dish_name);
            meal_id_tv = itemView.findViewById(R.id.dish_id);


        }
    }
}
