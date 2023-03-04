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

import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.models.search.Category;

import com.example.foodplanner.view.search.AllCategoriesActivityInterface;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private static final String TAG = "MyAdapter";
    AllCategoriesActivityInterface allCategoriesActivityInterface;
    ArrayList<Category> categories;
    Context context;

    public void setList(ArrayList<Category> updatedCategories){this.categories=updatedCategories;}


    public CategoryAdapter(Context context, AllCategoriesActivityInterface allCategoriesActivityInterface, ArrayList<Category> categories) {
        this.allCategoriesActivityInterface = allCategoriesActivityInterface;
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_area,parent,false);
        CategoryAdapter.MyViewHolder myViewHolder=new CategoryAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: ");
        Category current =categories.get(position);
        holder.name.setText(current.getStrCategory());



        Glide.with(context)
                .load(current.getStrCategoryThumb())
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(holder.photo);

        holder.wholeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allCategoriesActivityInterface.navigateToParticularCategoryMeals(current.getStrCategory());

            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
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
