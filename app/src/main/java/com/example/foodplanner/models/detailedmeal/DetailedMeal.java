package com.example.foodplanner.models.detailedmeal;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "DetailedMeal")
public class DetailedMeal {
    @PrimaryKey
    @ColumnInfo(name = "idMeal")
    @NonNull
    private String idMeal;


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
    @ColumnInfo(name = "MealIngredient1")
    public String strIngredient1;

    @ColumnInfo(name = "MealIngredient2")
    public String strIngredient2;

    @ColumnInfo(name = "MealIngredient3")
    public String strIngredient3;

    @ColumnInfo(name = "MealIngredient4")
    public String strIngredient4;

    @ColumnInfo(name = "MealIngredient5")
    public String strIngredient5;

    @ColumnInfo(name = "MealIngredient6")
    public String strIngredient6;

    @ColumnInfo(name = "MealIngredient7")
    public String strIngredient7;

    @ColumnInfo(name = "MealIngredient8")
    public String strIngredient8;

    @ColumnInfo(name = "MealIngredient9")
    public String strIngredient9;

    @ColumnInfo(name = "MealIngredient10")
    public String strIngredient10;

    @ColumnInfo(name = "MealIngredient11")
    public String strIngredient11;

    @ColumnInfo(name = "MealIngredient12")
    public String strIngredient12;

    @ColumnInfo(name = "MealIngredient13")
    public String strIngredient13;

    @ColumnInfo(name = "MealIngredient14")
    public String strIngredient14;

    @ColumnInfo(name = "MealIngredient15")
    public String strIngredient15;

    @ColumnInfo(name = "MealIngredient16")
    public String strIngredient16;

    @ColumnInfo(name = "MealIngredient17")
    public String strIngredient17;

    @ColumnInfo(name = "MealIngredient18")
    public String strIngredient18;

    @ColumnInfo(name = "MealIngredient19")
    public String strIngredient19;

    @ColumnInfo(name = "MealIngredient20")
    public String strIngredient20;


    @ColumnInfo(name = "MealMeasure1")
    public String strMeasure1;

    @ColumnInfo(name = "MealMeasure2")
    public String strMeasure2;

    @ColumnInfo(name = "MealMeasure3")
    public String strMeasure3;

    @ColumnInfo(name = "MealMeasure4")
    public String strMeasure4;

    @ColumnInfo(name = "MealMeasure5")
    public String strMeasure5;

    @ColumnInfo(name = "MealMeasure6")
    public String strMeasure6;

    @ColumnInfo(name = "MealMeasure7")
    public String strMeasure7;

    @ColumnInfo(name = "MealMeasure8")
    public String strMeasure8;

    @ColumnInfo(name = "MealMeasure9")
    public String strMeasure9;

    @ColumnInfo(name = "MealMeasure10")
    public String strMeasure10;

    @ColumnInfo(name = "MealMeasure11")
    public String strMeasure11;

    @ColumnInfo(name = "MealMeasure12")
    public String strMeasure12;

    @ColumnInfo(name = "MealMeasure13")
    public String strMeasure13;

    @ColumnInfo(name = "MealMeasure14")
    public String strMeasure14;

    @ColumnInfo(name = "MealMeasure15")
    public String strMeasure15;

    @ColumnInfo(name = "MealMeasure16")
    public String strMeasure16;

    @ColumnInfo(name = "MealMeasure17")
    public String strMeasure17;

    @ColumnInfo(name = "MealMeasure18")
    public String strMeasure18;

    @ColumnInfo(name = "MealMeasure19")
    public String strMeasure19;


    @ColumnInfo(name = "MealMeasure20")
    public String strMeasure20;

    private String weekDay;

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public DetailedMeal() {
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
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

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    public String getStrIngredient6() {
        return strIngredient6;
    }

    public void setStrIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
    }

    public String getStrIngredient7() {
        return strIngredient7;
    }

    public void setStrIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
    }

    public String getStrIngredient8() {
        return strIngredient8;
    }

    public void setStrIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
    }

    public String getStrIngredient9() {
        return strIngredient9;
    }

    public void setStrIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
    }

    public String getStrIngredient10() {
        return strIngredient10;
    }

    public void setStrIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
    }

    public String getStrIngredient11() {
        return strIngredient11;
    }

    public void setStrIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
    }

    public String getStrIngredient12() {
        return strIngredient12;
    }

    public void setStrIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
    }

    public String getStrIngredient13() {
        return strIngredient13;
    }

    public void setStrIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
    }

    public String getStrIngredient14() {
        return strIngredient14;
    }

    public void setStrIngredient14(String strIngredient14) {
        this.strIngredient14 = strIngredient14;
    }

    public String getStrIngredient15() {
        return strIngredient15;
    }

    public void setStrIngredient15(String strIngredient15) {
        this.strIngredient15 = strIngredient15;
    }

    public String getStrIngredient16() {
        return strIngredient16;
    }

    public void setStrIngredient16(String strIngredient16) {
        this.strIngredient16 = strIngredient16;
    }

    public String getStrIngredient17() {
        return strIngredient17;
    }

    public void setStrIngredient17(String strIngredient17) {
        this.strIngredient17 = strIngredient17;
    }

    public String getStrIngredient18() {
        return strIngredient18;
    }

    public void setStrIngredient18(String strIngredient18) {
        this.strIngredient18 = strIngredient18;
    }

    public String getStrIngredient19() {
        return strIngredient19;
    }

    public void setStrIngredient19(String strIngredient19) {
        this.strIngredient19 = strIngredient19;
    }

    public String getStrIngredient20() {
        return strIngredient20;
    }

    public void setStrIngredient20(String strIngredient20) {
        this.strIngredient20 = strIngredient20;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public void setStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public void setStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public void setStrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public void setStrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    public String getStrMeasure6() {
        return strMeasure6;
    }

    public void setStrMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
    }

    public String getStrMeasure7() {
        return strMeasure7;
    }

    public void setStrMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
    }

    public String getStrMeasure8() {
        return strMeasure8;
    }

    public void setStrMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
    }

    public String getStrMeasure9() {
        return strMeasure9;
    }

    public void setStrMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
    }

    public String getStrMeasure10() {
        return strMeasure10;
    }

    public void setStrMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
    }

    public String getStrMeasure11() {
        return strMeasure11;
    }

    public void setStrMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
    }

    public String getStrMeasure12() {
        return strMeasure12;
    }

    public void setStrMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
    }

    public String getStrMeasure13() {
        return strMeasure13;
    }

    public void setStrMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
    }

    public String getStrMeasure14() {
        return strMeasure14;
    }

    public void setStrMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
    }

    public String getStrMeasure15() {
        return strMeasure15;
    }

    public void setStrMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
    }

    public String getStrMeasure16() {
        return strMeasure16;
    }

    public void setStrMeasure16(String strMeasure16) {
        this.strMeasure16 = strMeasure16;
    }

    public String getStrMeasure17() {
        return strMeasure17;
    }

    public void setStrMeasure17(String strMeasure17) {
        this.strMeasure17 = strMeasure17;
    }

    public String getStrMeasure18() {
        return strMeasure18;
    }

    public void setStrMeasure18(String strMeasure18) {
        this.strMeasure18 = strMeasure18;
    }

    public String getStrMeasure19() {
        return strMeasure19;
    }

    public void setStrMeasure19(String strMeasure19) {
        this.strMeasure19 = strMeasure19;
    }

    public String getStrMeasure20() {
        return strMeasure20;
    }

    public void setStrMeasure20(String strMeasure20) {
        this.strMeasure20 = strMeasure20;
    }
}
