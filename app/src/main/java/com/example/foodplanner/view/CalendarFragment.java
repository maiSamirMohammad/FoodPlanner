package com.example.foodplanner.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.foodplanner.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class CalendarFragment extends Fragment {
    CalendarView simpleCalendarView;
    Date mStartTime, mEndTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        simpleCalendarView = requireView().findViewById(R.id.simpleCalendarView);
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // Note that Month starts with 0 not 1
                Toast.makeText(getContext(), dayOfMonth + "/" + (month+1) + "/" + year, Toast.LENGTH_LONG).show();

                String startTime = Integer.toString(year) + "-" + Integer.toString(month + 1) + "-" + Integer.toString(dayOfMonth) + "T09:00:00";
                String endTime = Integer.toString(year) + "-" + Integer.toString(month + 1) + "-" + Integer.toString(dayOfMonth) + "T12:00:00";

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
                startActivity(mIntent);
            }
        });
    }
}