package com.example.foodplanner.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodplanner.R;
import com.example.foodplanner.databinding.ActivityLeadingBinding;
import com.example.foodplanner.models.FirebaseFirebaseRepository;
import com.example.foodplanner.utility.InternetChecker;
import com.example.foodplanner.view.calendar.CalendarFragment;
import com.example.foodplanner.view.search.SearchFragment;
import com.example.foodplanner.view.signup.SignUpActivity;

public class LeadingActivity extends AppCompatActivity {
    ActivityLeadingBinding binding;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLeadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String userID= FirebaseFirebaseRepository.getInstance(this).getSharedPreferences().getString("userID",null);
        builder = new AlertDialog.Builder(this);

//        checkConnection();
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
                    if(userID!=null){
                        replaceFragment(new FavoriteFragment());
                    }else {
                        signupForMore();
                    }
                    break;

                case R.id.nav_calender:
                    if(userID!=null){
                        replaceFragment(new CalendarFragment());
                    }else {
                        signupForMore();
                    }
                    break;
                case R.id.nav_profile:
                    if(userID!=null){
                        replaceFragment(new ProfileFragment());
                    }else {
                    signupForMore();
                    }
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
    private void checkConnection()
    {
        new InternetChecker(this).observeForever(isConnected -> {
            if (isConnected) {
                Toast.makeText(this, "Internet Is Connected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Internet Is not Connected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}