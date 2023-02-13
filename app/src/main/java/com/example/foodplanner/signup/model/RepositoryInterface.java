package com.example.foodplanner.signup.model;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public interface RepositoryInterface {
    public void registerUser(SignupUser signupUser);
    public Boolean isValidEmail(SignupUser signupUser);
    public Boolean isValidPassword(SignupUser signupUser);
    public Boolean isValidConfirmPassword(SignupUser signupUser);
    public void updateUI(Boolean isFinished);
    public void onSuccessRegistration();
    public @NonNull Task<AuthResult> onFailureRegistration();

}
