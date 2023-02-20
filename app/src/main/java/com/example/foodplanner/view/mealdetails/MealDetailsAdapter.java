package com.example.foodplanner.view.mealdetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.models.FirebaseFirebaseRepository;
import com.example.foodplanner.models.detailedmeal.DetailedMeal;
import com.example.foodplanner.view.AddAndRemoveFavoriteViewInterface;
import com.example.foodplanner.view.FavoriteFragment;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class MealDetailsAdapter extends RecyclerView.Adapter<MealDetailsAdapter.Holder> {

    AddAndRemoveFavoriteViewInterface addAndRemoveFavoriteViewInterface;
    private final ArrayList<DetailedMeal> detailedMealsList;

    public MealDetailsAdapter(ArrayList<DetailedMeal> detailedMealsList, AddAndRemoveFavoriteViewInterface addAndRemoveFavoriteViewInterface) {
        this.detailedMealsList = detailedMealsList;
        this.addAndRemoveFavoriteViewInterface = addAndRemoveFavoriteViewInterface;

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
        String userID= FirebaseFirebaseRepository.getInstance(holder.black_background.getContext()).getSharedPreferences().getString("userID",null);
        if(userID!=null){
            holder.black_background.setVisibility(View.VISIBLE);
            holder.btnFavorite.setVisibility(View.VISIBLE);
            holder.btn_add_to_calender.setVisibility(View.VISIBLE);
            holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( holder.btnFavorite.isChecked()){
                    addAndRemoveFavoriteViewInterface.addMeal(detailedMeal);
                }else {
                    addAndRemoveFavoriteViewInterface.removeMeal(detailedMeal);

                }

            }
        });
        }

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
/*
        List<String> ingredients = null;
        if (detailedMeal.getStrIngredient1() != null && detailedMeal.getStrMeasure1() != null ) {
            ingredients.add(detailedMeal.getStrIngredient1() + " : " + detailedMeal.getStrMeasure1());
        }
        if (detailedMeal.getStrIngredient2() != null && detailedMeal.getStrMeasure2() != null ) {
            ingredients.add(detailedMeal.getStrIngredient2() + " : " + detailedMeal.getStrMeasure2());
        }
        if (detailedMeal.getStrIngredient3() != null && detailedMeal.getStrMeasure3() != null ) {
            ingredients.add( detailedMeal.getStrIngredient3() + " : " + detailedMeal.getStrMeasure3());
        }
        if (detailedMeal.getStrIngredient4() != null && detailedMeal.getStrMeasure4() != null ) {
            ingredients.add( detailedMeal.getStrIngredient4() + " : " + detailedMeal.getStrMeasure4());
        }
        if (detailedMeal.getStrIngredient5() != null && detailedMeal.getStrMeasure5() != null ) {
            ingredients.add(detailedMeal.getStrIngredient5() + " : " + detailedMeal.getStrMeasure5());
        }
        if (detailedMeal.getStrIngredient6() != null && detailedMeal.getStrMeasure6() != null ) {
            ingredients.add(detailedMeal.getStrIngredient6() + " : " + detailedMeal.getStrMeasure6());
        }
        if (detailedMeal.getStrIngredient7() != null && detailedMeal.getStrMeasure7() != null ) {
            ingredients.add(detailedMeal.getStrIngredient7() + " : " + detailedMeal.getStrMeasure7());
        }
        if (detailedMeal.getStrIngredient8() != null && detailedMeal.getStrMeasure8() != null ) {
            ingredients.add(detailedMeal.getStrIngredient8() + " : " + detailedMeal.getStrMeasure8());
        }
        if (detailedMeal.getStrIngredient9() != null && detailedMeal.getStrMeasure9() != null ) {
            ingredients.add(detailedMeal.getStrIngredient9() + " : " + detailedMeal.getStrMeasure9());
        }
        if (detailedMeal.getStrIngredient10() != null && detailedMeal.getStrMeasure10() != null ) {
            ingredients.add(detailedMeal.getStrIngredient10() + " : " + detailedMeal.getStrMeasure10());
        }
        if (detailedMeal.getStrIngredient11() != null && detailedMeal.getStrMeasure11() != null ) {
            ingredients.add(detailedMeal.getStrIngredient11() + " : " + detailedMeal.getStrMeasure11());
        }
        if (detailedMeal.getStrIngredient12() != null && detailedMeal.getStrMeasure12() != null ) {
            ingredients.add( detailedMeal.getStrIngredient12() + " : " + detailedMeal.getStrMeasure12());
        }
        if (detailedMeal.getStrIngredient13() != null && detailedMeal.getStrMeasure13() != null ) {
            ingredients.add(detailedMeal.getStrIngredient13() + " : " + detailedMeal.getStrMeasure13());
        }
        if (detailedMeal.getStrIngredient14() != null && detailedMeal.getStrMeasure14() != null ) {
            ingredients.add(detailedMeal.getStrIngredient14() + " : " + detailedMeal.getStrMeasure14());
        }
        if (detailedMeal.getStrIngredient15() != null && detailedMeal.getStrMeasure15() != null ) {
            ingredients.add(detailedMeal.getStrIngredient15() + " : " + detailedMeal.getStrMeasure15());
        }
        if (detailedMeal.getStrIngredient16() != null && detailedMeal.getStrMeasure16() != null ) {
            ingredients.add( detailedMeal.getStrIngredient16() + " : " + detailedMeal.getStrMeasure16());
        }
        if (detailedMeal.getStrIngredient17() != null && detailedMeal.getStrMeasure17() != null ) {
            ingredients.add(detailedMeal.getStrIngredient17() + " : " + detailedMeal.getStrMeasure17());
        }
        if (detailedMeal.getStrIngredient18() != null && detailedMeal.getStrMeasure18() != null ) {
            ingredients.add(detailedMeal.getStrIngredient18() + " : " + detailedMeal.getStrMeasure18());
        }
        if (detailedMeal.getStrIngredient19() != null && detailedMeal.getStrMeasure19() != null ) {
            ingredients.add(detailedMeal.getStrIngredient19() + " : " + detailedMeal.getStrMeasure19());
        }
        if (detailedMeal.getStrIngredient20() != null && detailedMeal.getStrMeasure20() != null ) {
            ingredients.add(detailedMeal.getStrIngredient20() + " : " + detailedMeal.getStrMeasure20());
        }
//        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(requireContext(),ingredients);
//        ingredientsRecycler.setAdapter(ingredientsAdapter);
 */
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
        Button  btn_add_to_calender;
        View black_background;
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
        }
        }
}
