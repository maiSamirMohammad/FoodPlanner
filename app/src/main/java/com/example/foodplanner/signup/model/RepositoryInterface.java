package com.example.foodplanner.signup.model;


import com.example.foodplanner.signup.network.SignUpResult;

public interface RepositoryInterface {
    public void registerUser(SignUpResult signUpResult, SignupUser signupUser);



}
