package com.example.foodplanner.signup.model;


import androidx.annotation.NonNull;

import com.example.foodplanner.signup.network.SignUpResult;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Repository implements RepositoryInterface {


    private FirebaseAuth mAuth;


    private static Repository repo = null;

    public static Repository getInstance() {
        if (repo == null) {
            repo = new Repository();
        }
        return repo;
    }

    private Repository() {
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


    }


    @Override
    public void registerUser(SignUpResult signUpResult, SignupUser signupUser) {

        mAuth.createUserWithEmailAndPassword(signupUser.getEmail(), signupUser.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            signUpResult.onSuccessRegistration();

                        } else {
                            signUpResult.onFailureRegistration(task);


                        }
                    }
                });

    }


}
