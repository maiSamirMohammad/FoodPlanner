package com.example.foodplanner.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.foodplanner.R;
import com.example.foodplanner.models.SimpleMeal;
import com.example.foodplanner.models.detailedmeal.DetailedMeal;
import com.example.foodplanner.presenter.FavoritePresenter;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment implements FavoriteFragmentInterface{
    RecyclerView favoriteRecyclerView;
    FavoriteMealsAdapter favoriteMealsAdapter;
    LinearLayoutManager layoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);

        layoutManager = new LinearLayoutManager(requireContext());
        favoriteMealsAdapter = new FavoriteMealsAdapter(requireContext(), new ArrayList<>(), this);
        favoriteRecyclerView.setAdapter(favoriteMealsAdapter);
        favoriteRecyclerView.setLayoutManager(layoutManager);

        FavoritePresenter.getMeals((LifecycleOwner) requireContext(),requireContext(),this);

    }
    private void initUI(@NonNull View view) {
        favoriteRecyclerView = view.findViewById(R.id.rv_my_favorite);

    }

    @Override
    public void showData(List<DetailedMeal> meals) {
        favoriteMealsAdapter.setList(meals);
        favoriteMealsAdapter.notifyDataSetChanged();
    }

    @Override
    public void removeMeal(DetailedMeal meal) {
        FavoritePresenter.removeFromFav(meal,requireContext());
    }


}