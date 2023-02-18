package com.example.foodplanner.models.search;

import com.example.foodplanner.R;

public class AllCategories {
    private static AllCategories allCategories=null;
    private  Category[] categories;
    private AllCategories() {
        categories= new Category[]{
                new Category("Beef", R.drawable.beef),
                new Category("Breakfast", R.drawable.breakfast),
                new Category("Chicken", R.drawable.chicken),
                new Category("Dessert", R.drawable.dessert),
                new Category("Goat", R.drawable.goat),
                new Category("Lamb", R.drawable.lamb),
                new Category("Miscellaneous", R.drawable.miscellaneous),
                new Category("Pasta", R.drawable.pasta),
                new Category("Pork", R.drawable.pork),
                new Category("Seafood", R.drawable.seafood),
                new Category("Side", R.drawable.side),
                new Category("Starter", R.drawable.starter),
                new Category("Vegan", R.drawable.vegan),
                new Category("Vegetarian", R.drawable.vegetarian)
        };
    }

    public static AllCategories getInstance() {
        if (allCategories == null) {
            allCategories = new AllCategories();
        }

        return allCategories;
    }
    public Category[] getAllCategories() {
        return categories;
    }
}
