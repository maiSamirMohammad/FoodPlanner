package com.example.foodplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.example.foodplanner.databinding.ActivityLeadingBinding;

public class LeadingActivity extends AppCompatActivity {
    ActivityLeadingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLeadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());

        binding.bottomNavigationBar.setOnItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.nav_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.nav_search:
                    replaceFragment(new SearchFragment());
                    break;
                case R.id.nav_favorite:
                    replaceFragment(new FavoriteFragment());
                    break;
                case R.id.nav_calender:
                    replaceFragment(new CalendarFragment());
                    break;
                case R.id.nav_profile:
                    break;
            }


            return true;
        });


    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
    }


}