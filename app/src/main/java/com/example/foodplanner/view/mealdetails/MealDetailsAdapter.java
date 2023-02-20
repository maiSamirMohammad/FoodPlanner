package com.example.foodplanner.view.mealdetails;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.models.detailedmeal.DetailedMeal;
import com.example.foodplanner.view.LoginActivity;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MealDetailsAdapter extends RecyclerView.Adapter<MealDetailsAdapter.Holder> {

    private final ArrayList<DetailedMeal> detailedMealsList;
    MealDetailsInterface mealDetailsInterface;

    public MealDetailsAdapter(ArrayList<DetailedMeal> detailedMealsList, MealDetailsInterface mealDetailsInterface) {
        this.detailedMealsList = detailedMealsList;
        this.mealDetailsInterface = mealDetailsInterface;
    }

    @NonNull
    @Override
    public MealDetailsAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealDetailsAdapter.Holder holder, int position) {

        DetailedMeal detailedMeal = detailedMealsList.get(position);
        holder.meal_name_tv.setText(detailedMeal.getStrMeal());
        holder.meal_country.setText(detailedMeal.getStrArea());
        holder.meal_instructions.setText(detailedMeal.getStrInstructions());
        Glide.with(holder.meal_photo.getContext()).load(detailedMeal.getStrMealThumb()).into(holder.meal_photo);

        //getLifecycle().addObserver((LifecycleObserver) holder.mealVideo);
        if (detailedMeal.getStrYoutube() != null ) {
            String[] split = detailedMeal.getStrYoutube().split("=");
            holder.mealVideo.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = split[1];
                    youTubePlayer.cueVideo(videoId, 0);
                }
            });
        }

        holder.calendarButton.setOnClickListener(view -> {
            mealDetailsInterface.navigateToCalendar(detailedMeal.getStrMeal());
        });
    }

    @Override
    public int getItemCount() {
        return detailedMealsList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        public ImageView meal_photo;
        public TextView meal_name_tv, meal_country, meal_instructions;
        private final YouTubePlayerView mealVideo;
        private Button calendarButton;
        RecyclerView recyclerViewIngredients;
        public Holder(@NonNull View itemView) {
            super(itemView);
            meal_photo = itemView.findViewById(R.id.iv_details_food);
            meal_name_tv = itemView.findViewById(R.id.tv_details_name_of_meal);
            meal_country = itemView.findViewById(R.id.tv_details_country);
            meal_instructions = itemView.findViewById(R.id.tv_details_instructions);
            mealVideo = itemView.findViewById(R.id.video);
            recyclerViewIngredients = itemView.findViewById(R.id.rv_ingredients);
            calendarButton = itemView.findViewById(R.id.calendarBtn);
            }
        }
}
