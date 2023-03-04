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
import com.example.foodplanner.models.detailedmeal.IngredientWithMeasure;

import java.util.ArrayList;
import java.util.List;

public class MealDetailsIngredientsAdapter extends RecyclerView.Adapter<MealDetailsIngredientsAdapter.ViewHolder> {
    ArrayList<IngredientWithMeasure> ingredientWithMeasures;


    public MealDetailsIngredientsAdapter(ArrayList<IngredientWithMeasure> list) {
        ingredientWithMeasures = list;
    }

    @NonNull
    @Override
    public MealDetailsIngredientsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ingredient_with_measure, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealDetailsIngredientsAdapter.ViewHolder holder, int position) {
        holder.ingredientMeasure.setText(ingredientWithMeasures.get(position).getIngredientMeasure());
        holder.ingredientName.setText(ingredientWithMeasures.get(position).getIngredientName());
        Glide.with(holder.ingredientImageView.getContext())
                .load(holder.ingredientImageView.getContext().getResources().getString(R.string.ingredient_img, ingredientWithMeasures.get(position).getIngredientName()))
                .placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image).into(holder.ingredientImageView);


    }

    @Override
    public int getItemCount() {
        return ingredientWithMeasures.size();
    }

    public void setList(ArrayList<IngredientWithMeasure> arrayList) {
        ingredientWithMeasures = arrayList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
         TextView ingredientName;
         TextView ingredientMeasure;
         ImageView ingredientImageView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientName = itemView.findViewById(R.id.tv_ingredient_name_in_meal_details);

            ingredientMeasure = itemView.findViewById(R.id.tv_ingredient_measure);

            ingredientImageView = itemView.findViewById(R.id.iv_ingredient_image_in_meal_details);

        }


    }
}
