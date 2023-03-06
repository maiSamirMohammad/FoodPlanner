package com.example.foodplanner.view.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.models.FirebaseFirebaseRepository;
import com.example.foodplanner.view.mealdetails.ViewDetailsActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarfromViewDetails extends AppCompatActivity {
    CalendarView simpleCalendarView;
    Date mStartTime, mEndTime;
    Button returnToMeal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendarfrom_view_details);
        returnToMeal = findViewById(R.id.btn_calendar_return);
        returnToMeal.setOnClickListener(view -> {
            Intent intent = new Intent(CalendarfromViewDetails.this, ViewDetailsActivity.class);
            startActivity(intent);
        });

        simpleCalendarView = findViewById(R.id.simpleCalendarView);
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // Note that Month starts with 0 not 1
                Toast.makeText(CalendarfromViewDetails.this, dayOfMonth + "/" + (month+1) + "/" + year, Toast.LENGTH_LONG).show();

                String startTime = Integer.toString(year) + "-" + Integer.toString(month + 1) + "-" + Integer.toString(dayOfMonth) + "T09:00:00";
                String endTime = Integer.toString(year) + "-" + Integer.toString(month + 1) + "-" + Integer.toString(dayOfMonth) + "T17:00:00";

                SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                try {
                    mStartTime = mSimpleDateFormat.parse(startTime);
                    mEndTime = mSimpleDateFormat.parse(endTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                // Calendar is a core application in Android so you don't REALLY have to check if it exists
                Intent mIntent = new Intent(Intent.ACTION_EDIT);
                mIntent.setType("vnd.android.cursor.item/event");
                mIntent.putExtra("beginTime", mStartTime.getTime());
                mIntent.putExtra("time", true);
                mIntent.putExtra("endTime", mEndTime.getTime());
                mIntent.putExtra("title", FirebaseFirebaseRepository.getInstance(CalendarfromViewDetails.this).getSharedPreferences().getString("mealcurrentname",null));
                startActivity(mIntent);
            }
        });
    }
}