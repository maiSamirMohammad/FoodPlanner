package com.example.foodplanner.view.mealdetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.CheckBox;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.models.FirebaseFirebaseRepository;
import com.example.foodplanner.models.detailedmeal.DetailedMeal;

import com.example.foodplanner.models.detailedmeal.IngredientWithMeasure;

import com.example.foodplanner.view.AddAndRemoveFavoriteViewInterface;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class MealDetailsAdapter extends RecyclerView.Adapter<MealDetailsAdapter.Holder> {

    AddAndRemoveFavoriteViewInterface addAndRemoveFavoriteViewInterface;
    private final ArrayList<DetailedMeal> detailedMealsList;
    MealDetailsInterface mealDetailsInterface;




    public MealDetailsAdapter(ArrayList<DetailedMeal> detailedMealsList, AddAndRemoveFavoriteViewInterface addAndRemoveFavoriteViewInterface, MealDetailsInterface mealDetailsInterface) {
        this.detailedMealsList = detailedMealsList;
        this.addAndRemoveFavoriteViewInterface = addAndRemoveFavoriteViewInterface;
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
        String userID = FirebaseFirebaseRepository.getInstance(holder.black_background.getContext()).getSharedPreferences().getString("userID", null);
        if (userID != null) {
            holder.black_background.setVisibility(View.VISIBLE);
            holder.btnFavorite.setVisibility(View.VISIBLE);
            holder.btn_add_to_calender.setVisibility(View.VISIBLE);

            holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (holder.btnFavorite.isChecked()) {
                        addAndRemoveFavoriteViewInterface.addMeal(detailedMeal);
                    } else {
                        addAndRemoveFavoriteViewInterface.removeMeal(detailedMeal);

                    }

                }
            });
        }
        ArrayList<IngredientWithMeasure> ingredients=new ArrayList<IngredientWithMeasure>();
        if (detailedMeal.strIngredient1!=null&&!detailedMeal.strIngredient1.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient1,detailedMeal.strMeasure1.toString()));
        } if (detailedMeal.strIngredient2!=null&&!detailedMeal.strIngredient2.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient2,detailedMeal.strMeasure2.toString()));
        } if (detailedMeal.strIngredient3!=null&&!detailedMeal.strIngredient3.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient3,detailedMeal.strMeasure3.toString()));
        } if (detailedMeal.strIngredient4!=null&&!detailedMeal.strIngredient4.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient4,detailedMeal.strMeasure4.toString()));
        } if (detailedMeal.strIngredient5!=null&&!detailedMeal.strIngredient5.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient5,detailedMeal.strMeasure5.toString()));
        } if (detailedMeal.strIngredient6!=null&&!detailedMeal.strIngredient6.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient6,detailedMeal.strMeasure6.toString()));
        } if (detailedMeal.strIngredient7!=null&&!detailedMeal.strIngredient7.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient7,detailedMeal.strMeasure7.toString()));
        } if (detailedMeal.strIngredient8!=null&&!detailedMeal.strIngredient8.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient8,detailedMeal.strMeasure8.toString()));
        } if (detailedMeal.strIngredient9!=null&&!detailedMeal.strIngredient9.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient9,detailedMeal.strMeasure9.toString()));
        } if (detailedMeal.strIngredient10!=null&&!detailedMeal.strIngredient10.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient10,detailedMeal.strMeasure10.toString()));

        } if (detailedMeal.strIngredient11!=null&&!detailedMeal.strIngredient11.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient11,detailedMeal.strMeasure11.toString()));
        } if (detailedMeal.strIngredient12!=null&&!detailedMeal.strIngredient12.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient12,detailedMeal.strMeasure12.toString()));
        } if (detailedMeal.strIngredient13!=null&&!detailedMeal.strIngredient13.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient13,detailedMeal.strMeasure13.toString()));
        } if (detailedMeal.strIngredient14!=null&&!detailedMeal.strIngredient14.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient14,detailedMeal.strMeasure14.toString()));
        } if (detailedMeal.strIngredient15!=null&&!detailedMeal.strIngredient15.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient15,detailedMeal.strMeasure15.toString()));
        } if (detailedMeal.strIngredient16!=null&&!detailedMeal.strIngredient16.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient16,detailedMeal.strMeasure16.toString()));
        } if (detailedMeal.strIngredient17!=null&&!detailedMeal.strIngredient17.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient17,detailedMeal.strMeasure17.toString()));
        } if (detailedMeal.strIngredient18!=null&&!detailedMeal.strIngredient18.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient18,detailedMeal.strMeasure18.toString()));
        } if (detailedMeal.strIngredient19!=null&&!detailedMeal.strIngredient19.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient19,detailedMeal.strMeasure19.toString()));
        } if (detailedMeal.strIngredient20!=null&&!detailedMeal.strIngredient20.isEmpty()){
            ingredients.add(new IngredientWithMeasure(detailedMeal.strIngredient20,detailedMeal.strMeasure20.toString()));
        }

        holder.mealDetailsIngredientsAdapter= new MealDetailsIngredientsAdapter(ingredients);
        holder.recyclerViewIngredients.setAdapter( holder.mealDetailsIngredientsAdapter);

        //getLifecycle().addObserver((LifecycleObserver) holder.mealVideo);
        if (!detailedMeal.getStrYoutube().isEmpty() && !detailedMeal.getStrYoutube().equals("")&& detailedMeal.getStrYoutube() != null)  {
            String[] split = detailedMeal.getStrYoutube().split("=");
            holder.mealVideo.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = split[1];
                    youTubePlayer.cueVideo(videoId, 0);
                }
            });
        }

        holder.btn_add_to_calender.setOnClickListener(view -> {
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
        RecyclerView recyclerViewIngredients;
        CheckBox btnFavorite;
        Button btn_add_to_calender;
        View black_background;
        MealDetailsIngredientsAdapter mealDetailsIngredientsAdapter;
        LinearLayoutManager layoutManager;

        public Holder(@NonNull View itemView) {
            super(itemView);
            meal_photo = itemView.findViewById(R.id.iv_details_food);
            meal_name_tv = itemView.findViewById(R.id.tv_details_name_of_meal);
            meal_country = itemView.findViewById(R.id.tv_details_country);
            meal_instructions = itemView.findViewById(R.id.tv_details_instructions);
            mealVideo = itemView.findViewById(R.id.video);
            recyclerViewIngredients = itemView.findViewById(R.id.rv_ingredients);
            btnFavorite = itemView.findViewById(R.id.btn_favorite);
            btn_add_to_calender = itemView.findViewById(R.id.btn_add_to_calender);
            black_background = itemView.findViewById(R.id.black_background);
            layoutManager=new LinearLayoutManager(recyclerViewIngredients.getContext());
            layoutManager.setOrientation(RecyclerView.HORIZONTAL);
            recyclerViewIngredients.setLayoutManager(layoutManager);

        }
    }
}

