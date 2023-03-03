package com.example.foodplanner.view.login;

public interface LoginListener {
    void onValidationError(String message);
    void onLoginSuccess();
    void onLoginError(String message);
}
