package com.example.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodplanner.signup.model.Repository;
import com.example.foodplanner.signup.view.SignUpActivity;

public class StartScreenActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        String userID=Repository.getInstance(this).getSharedPreferences().getString("userID",null);
        if(userID!=null){
            Intent intent = new Intent(StartScreenActivity.this, LeadingActivity.class);
            startActivity(intent);
        }


    }

    private Button loginBtn, signupBtn, skipBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        initializeVariables();
        setListeners();
    }
    private void initializeVariables()
    {
        loginBtn = findViewById(R.id.btn_start_login);
        signupBtn = findViewById(R.id.btn_start_signup);
        skipBtn =  findViewById(R.id.btn_start_skip);
    }
    private void setListeners()
    {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartScreenActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartScreenActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartScreenActivity.this, LeadingActivity.class);
                startActivity(intent);
            }
        });

    }
}