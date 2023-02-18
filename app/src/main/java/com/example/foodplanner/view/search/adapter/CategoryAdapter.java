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

import com.example.foodplanner.view.search.AllCategoriesActivityInterface;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private static final String TAG = "MyAdapter";
    AllCategoriesActivityInterface allCategoriesActivityInterface;
    Category[] categories;
    Context context;

    public CategoryAdapter(Context context, AllCategoriesActivityInterface allCategoriesActivityInterface, Category[] categories) {
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
        Category current =categories[position];
        holder.name.setText(current.getCategoryName());
        //holder.photo.setImageResource(current.getImageResourceId());

        holder.photo.setImageBitmap(
                decodeSampledBitmapFromResource(context.getResources(), current.getImageResourceId(), 100, 80));

//        Glide.with(context)
//                .load(R.drawable.loading_animation)
//                .placeholder(R.drawable.loading_animation)
//                .error(R.drawable.ic_broken_image)
//                .into(holder.photo);

        holder.wholeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allCategoriesActivityInterface.navigateToParticularCategoryMeals(current.getCategoryName());

            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.length;
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
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
