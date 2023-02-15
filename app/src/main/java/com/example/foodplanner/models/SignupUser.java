package com.example.foodplanner.models;

public class SignupUser {
    private String displayName;
    private String email;
    private String password;
    private String confirmPassword;


    //constructor
    public SignupUser(String displayName, String email, String password, String confirmPassword) {
        this.displayName = displayName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }


    //getters
    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    //setters


    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
