package com.example.foodplanner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        icon.setOnCheckedChangeListener((buttonView, isChecked) ->{
//            if (isChecked){
//                Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_LONG).show();
//            }else {
//                Toast.makeText(getApplicationContext(),"bye bye",Toast.LENGTH_LONG).show();
//            }
//        } );
    }
}