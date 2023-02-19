package com.example.foodplanner.view.weekplanner;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.models.detailedmeal.DetailedMeal;

import java.util.ArrayList;
import java.util.List;

public class WeekPlanAdapter extends RecyclerView.Adapter<WeekPlanAdapter.ViewHolder> {

    private Context context;
    private ViewGroup viewGroup;
    private List<DetailedMeal> mealsWeekPlanner = new ArrayList<>();
    private static final String TAG = "WeekPlanAdapter";
    private Boolean firstTimeInTheView = true;
    private ProgressDialog progressDialog;


    public WeekPlanAdapter(List<DetailedMeal> mealsWeekPlanner) {
        this.mealsWeekPlanner = mealsWeekPlanner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        this.viewGroup = parent;
        context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_week_meal, parent, false);          //\\\\\\\\\\
        ViewHolder viewHolder = new ViewHolder(itemView);
        Log.i(TAG, "onCreateViewHolder: ");

        progressDialog = new ProgressDialog(viewGroup.getContext());
        progressDialog.setTitle("Removing meal from week plan");
        progressDialog.setMessage("Please wait while removing the selected item from your week plan.");
        progressDialog.setCanceledOnTouchOutside(true);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DetailedMeal mealsItem = mealsWeekPlanner.get(position);
        holder.week_planner_tv_mealName.setText(mealsItem.getStrMeal());

        Glide.with(viewGroup.getContext()).load(mealsItem.getStrMealThumb()).into(holder.week_planner_img_mealImg);

        holder.btn_removeWeekPlannerItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    progressDialog.show();
                                    mealsWeekPlanner.remove(position);
                                    notifyDataSetChanged();


                                    progressDialog.dismiss();


                                    if (mealsWeekPlanner.size() == 0 & mealsItem.getWeekDay().equals("Saturday")) {
                                        WeekPlanActivity.tv_Saturday.setVisibility(View.GONE);
                                    } else if (mealsWeekPlanner.size() == 0 & mealsItem.getWeekDay().equals("Sunday")) {
                                        WeekPlanActivity.tv_Sunday.setVisibility(View.GONE);
                                    } else if (mealsWeekPlanner.size() == 0 & mealsItem.getWeekDay().equals("Monday")) {
                                        WeekPlanActivity.tv_Monday.setVisibility(View.GONE);
                                    } else if (mealsWeekPlanner.size() == 0 & mealsItem.getWeekDay().equals("Tuesday")) {
                                        WeekPlanActivity.tv_Tuesday.setVisibility(View.GONE);
                                    } else if (mealsWeekPlanner.size() == 0 & mealsItem.getWeekDay().equals("Wednesday")) {
                                        WeekPlanActivity.tv_Wednesday.setVisibility(View.GONE);
                                    } else if (mealsWeekPlanner.size() == 0 & mealsItem.getWeekDay().equals("Thursday")) {
                                        WeekPlanActivity.tv_Thursday.setVisibility(View.GONE);
                                    } else if (mealsWeekPlanner.size() == 0 & mealsItem.getWeekDay().equals("Friday")) {
                                        WeekPlanActivity.tv_Friday.setVisibility(View.GONE);
                                    }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // todo
                Intent intent;
            }
        });


    }

    @Override
    public int getItemCount() {


        return mealsWeekPlanner.size();


    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView week_planner_tv_mealName;
        public ImageView week_planner_img_mealImg;
        public ImageButton btn_removeWeekPlannerItem;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            week_planner_tv_mealName = itemView.findViewById(R.id.week_planner_tv_mealName);
            week_planner_img_mealImg = itemView.findViewById(R.id.week_planner_img_mealImg);
            btn_removeWeekPlannerItem = itemView.findViewById(R.id.btn_removeWeekPlannerItem);
        }
    }


}
