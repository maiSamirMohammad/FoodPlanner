package com.example.foodplanner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.foodplanner.databinding.ActivityLeadingBinding;

public class LeadingActivity extends AppCompatActivity {
    ActivityLeadingBinding binding;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLeadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        builder = new AlertDialog.Builder(this);

        replaceFragment(new HomeFragment());

        binding.bottomNavigationBar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.nav_search:
                    replaceFragment(new SearchFragment());
                    break;
                case R.id.nav_favorite:
                    replaceFragment(new FavoriteFragment());
                    //signupForMore();
                    break;

                case R.id.nav_calender:
                    replaceFragment(new CalendarFragment());
                    //signupForMore();
                    break;
                case R.id.nav_profile:
                    signupForMore();
                    break;
            }
            return true;
        });


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    public void signupForMore() {
        builder.setTitle("Sign up for more features!")
                .setMessage("Save your favorite dishes \n and plan your meals")
                .setCancelable(true)
                .setPositiveButton("Sign up", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(LeadingActivity.this, SignUpActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }
}