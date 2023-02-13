package com.example.foodplanner.signup.presenter;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public interface SignUpPresenterInterface {
    public void registerUser(String disPlayName,String email,String password,String confirmPassword);
    public void onSuccessRegistration();
    public @NonNull Task<AuthResult> onFailureRegistration();

}
