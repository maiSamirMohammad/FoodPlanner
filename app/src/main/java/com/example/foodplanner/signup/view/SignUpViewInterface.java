package com.example.foodplanner.signup.view;

import androidx.annotation.NonNull;

import com.example.foodplanner.signup.model.SignupUser;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public interface SignUpViewInterface {

    public void registerUser(String disPlayName,String email,String password,String confirmPassword);
    public void onSuccessRegistrationView();
    public void onFailureRegistrationView(@NonNull Task<AuthResult> task);
}
