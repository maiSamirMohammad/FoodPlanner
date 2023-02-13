package com.example.foodplanner.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "DetailedMeal")
public class DetailedMeal {
    @PrimaryKey
    @ColumnInfo(name = "strMeal")
    private String strMeal;
    @ColumnInfo(name = "strCategory")
    private String strCategory;
    @ColumnInfo(name = "strArea")
    private String strArea;
    @ColumnInfo(name = "strInstructions")
    private String strInstructions;
    @ColumnInfo(name = "strMealThumb")
    private String strMealThumb;
    @ColumnInfo(name = "strYoutube")
    private String strYoutube;
    @ColumnInfo(name = "strIngredient")
    private ArrayList<String> strIngredient;
    @ColumnInfo(name = "strMeasure")
    private ArrayList<String> strMeasure;

    public DetailedMeal(String strMeal, String strCategory, String strArea, String strInstructions, String strMealThumb, String strYoutube, ArrayList<String> strIngredient, ArrayList<String> strMeasure) {
        this.strMeal = strMeal;
        this.strCategory = strCategory;
        this.strArea = strArea;
        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
        this.strYoutube = strYoutube;
        this.strIngredient = strIngredient;
        this.strMeasure = strMeasure;
    }

    public DetailedMeal() {
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public ArrayList<String> getStrIngredient() {
        return strIngredient;
    }

    public void setStrIngredient(ArrayList<String> strIngredient) {
        this.strIngredient = strIngredient;
    }

    public ArrayList<String> getStrMeasure() {
        return strMeasure;
    }

    public void setStrMeasure(ArrayList<String> strMeasure) {
        this.strMeasure = strMeasure;
    }
}
