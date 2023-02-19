package com.example.foodplanner.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.models.SimpleMeal;

import java.util.List;

public class FavoriteMealsAdapter  extends RecyclerView.Adapter<FavoriteMealsAdapter.ViewHolder>{
    private Context context;
    private List<SimpleMeal> meals;
    private FavoriteFragmentInterface favoriteFragmentInterface;
    public static final String TAG = "FavoriteAdapter";
    public FavoriteMealsAdapter( Context context,List<SimpleMeal> meals,
                             FavoriteFragmentInterface favoriteFragmentInterface){
        this.context = context;
        this.meals = meals;
        this.favoriteFragmentInterface= favoriteFragmentInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_checked_favorite_btn, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        Log.i(TAG, "=========== onCreateViewHolder ===========");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SimpleMeal currentMeal = meals.get(position);
        holder.meal_name_tv.setText(currentMeal.getStrMeal());
        Glide.with(holder.meal_photo.getContext())
                .load(currentMeal.getStrMealThumb())
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(holder.meal_photo);
        holder.btnRemoveFromFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                favoriteFragmentInterface.removeMeal(currentMeal);
            }
        });

    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public void setList(List<SimpleMeal> updatedMeals){
        this.meals = updatedMeals;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView meal_photo;
        TextView meal_name_tv;
        Button btnRemoveFromFavorite;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meal_photo = itemView.findViewById(R.id.dish_image);
            meal_name_tv = itemView.findViewById(R.id.dish_name);
            btnRemoveFromFavorite = itemView.findViewById(R.id.btn_remove_from_favorite);
        }
    }
}
