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
        holder.getTextViewIngredientMeasure().setText(ingredientWithMeasures.get(position).getIngredientMeasure());
        holder.getTextViewIngredientName().setText(ingredientWithMeasures.get(position).getIngredientName());
        Glide.with(holder.getView().getContext())
                .load("https://www.themealdb.com/images/ingredients/" + ingredientWithMeasures.get(position).getIngredientName() + "-Small.png")
                .placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image).into(holder.getRoundedImageView());


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
        private final TextView textViewIngredientName;
        private final TextView textViewIngredientMeasure;
        private final ImageView roundedImageView;
        View view;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewIngredientName = itemView.findViewById(R.id.textViewIngredientNameItem_mealDetails);

            textViewIngredientMeasure = itemView.findViewById(R.id.textViewIngredientMeasureItem);

            roundedImageView = itemView.findViewById(R.id.imageViewIngredientImageItem_mealDetails);
            view = itemView;
        }

        public TextView getTextViewIngredientName() {
            return textViewIngredientName;
        }

        public TextView getTextViewIngredientMeasure() {
            return textViewIngredientMeasure;
        }

        public ImageView getRoundedImageView() {
            return roundedImageView;
        }

        public View getView() {
            return view;
        }
    }
}
