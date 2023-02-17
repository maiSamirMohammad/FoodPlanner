package com.example.foodplanner.view.search.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.models.search.Area;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.MyViewHolder> {
    private static final String TAG = "MyAdapter";
    Context context;
    Area[] areas;

    public AreaAdapter(Context context,Area[] areas) {
        this.context = context;
        this.areas = areas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_area,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: ");
        Area current =areas[position];
        holder.name.setText(current.getAreaName());
        holder.photo.setImageResource(current.getImageResourceId());
        holder.wholeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, current.getAreaName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return areas.length;
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
