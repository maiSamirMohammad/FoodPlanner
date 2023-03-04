package com.example.foodplanner.view.login;

public interface LoginListener {
    void onValidationError(String message);
    void onLoginSuccess(String userId);
    void onLoginError(String message);
}
