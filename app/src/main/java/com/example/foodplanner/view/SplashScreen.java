package com.example.foodplanner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.airbnb.lottie.LottieAnimationView;
import com.example.foodplanner.R;
import com.example.foodplanner.models.FirebaseFirebaseRepository;

public class SplashScreen extends AppCompatActivity {
    private LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        String userID= FirebaseFirebaseRepository.getInstance(this).getSharedPreferences().getString("userID",null);
        lottieAnimationView = findViewById(R.id.gif_splash);
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(userID!=null){
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(SplashScreen.this, StartScreenActivity.class);
                    startActivity(intent);
                }
            }
//        }, 3500);
        }, 1800);


    }
}