package com.example.foodplanner.signup.model;

import android.util.Log;
import androidx.annotation.NonNull;

import com.example.foodplanner.signup.presenter.SignUpPresenter;
import com.example.foodplanner.signup.presenter.SignUpPresenterInterface;
import com.example.foodplanner.signup.view.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Repository implements RepositoryInterface{

    private FirebaseAuth mAuth;
    @NonNull Task<AuthResult> result_task;


    private static Repository repo=null;

    public static Repository getInstance(){
        if (repo==null){
            repo = new Repository();
        }
        return repo;
    }

    private Repository(){
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


    }



    @Override
    public void registerUser(SignupUser signupUser) {
        mAuth.createUserWithEmailAndPassword(signupUser.getEmail(),signupUser.getPassword())
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            onSuccessRegistration();
                        } else {
                            result_task=task;
                            onFailureRegistration();
                        }
                    }
                });

    }

    @Override
    public Boolean isValidEmail(SignupUser signupUser) {


        return null;
    }

    @Override
    public Boolean isValidPassword(SignupUser signupUser) {
        return null;
    }

    @Override
    public Boolean isValidConfirmPassword(SignupUser signupUser) {
        return null;
    }

    @Override
    public void updateUI(Boolean isTaskFinished) {
        

    }

    @Override
    public void onSuccessRegistration() {
    }

    @Override
    public @NonNull Task<AuthResult> onFailureRegistration() {
        return result_task;

    }


}
