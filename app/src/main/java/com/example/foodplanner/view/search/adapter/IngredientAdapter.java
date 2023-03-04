package com.example.foodplanner.view.search.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.models.search.Category;
import com.example.foodplanner.models.search.Ingredient;
import com.example.foodplanner.view.search.AllCategoriesActivityInterface;
import com.example.foodplanner.view.search.AllIngredientsActivityInterface;

import java.util.ArrayList;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.MyViewHolder> {
    private static final String TAG = "MyAdapter";
    AllIngredientsActivityInterface allIngredientsActivityInterface;
    ArrayList<Ingredient> ingredients;
    Context context;

    public void setList(ArrayList<Ingredient> updatedIngredients){this.ingredients=updatedIngredients;}


    public IngredientAdapter(Context context, AllIngredientsActivityInterface allIngredientsActivityInterface,  ArrayList<Ingredient> ingredients) {
        this.allIngredientsActivityInterface = allIngredientsActivityInterface;
        this.ingredients = ingredients;
        this.context = context;
    }

    @NonNull
    @Override
    public IngredientAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_area,parent,false);
        IngredientAdapter.MyViewHolder myViewHolder=new IngredientAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientAdapter.MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: ");
        Ingredient current =ingredients.get(position);
        holder.name.setText(current.getStrIngredient());
        Glide.with(context)
                .load(context.getResources().getString(R.string.ingredient_img, current.getStrIngredient()))
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(holder.photo);

        holder.wholeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allIngredientsActivityInterface.navigateToParticularIngredientMeals(current.getStrIngredient());

            }
        });

    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout wholeItem;
        TextView name;
        ImageView photo;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            wholeItem=itemView.findViewById(R.id.layout_whole_item);
            name=itemView.findViewById(R.id.area_name);
            photo=itemView.findViewById(R.id.area_image);


        }

    }

}
