package com.example.foodplanner.signup.presenter;

import androidx.annotation.NonNull;

import com.example.foodplanner.signup.model.RepositoryInterface;
import com.example.foodplanner.signup.model.SignupUser;
import com.example.foodplanner.signup.view.SignUpViewInterface;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignUpPresenter implements SignUpPresenterInterface {
    SignUpViewInterface signUpViewInterface;
    RepositoryInterface repositoryInterface;
    public SignUpPresenter(SignUpViewInterface signUpViewInterface, RepositoryInterface repositoryInterface) {
        this.signUpViewInterface= signUpViewInterface;
        this.repositoryInterface= repositoryInterface;
    }

    @Override
    public void registerUser(String disPlayName,String email,String password,String confirmPassword) {
        repositoryInterface.registerUser(new SignupUser(disPlayName,email,password,confirmPassword));

    }

    @Override
    public void onSuccessRegistration() {
        repositoryInterface.onSuccessRegistration();
        signUpViewInterface.onSuccessRegistrationView();
    }

    @Override
    public @NonNull Task<AuthResult> onFailureRegistration() {
        signUpViewInterface.onFailureRegistrationView( repositoryInterface.onFailureRegistration());
         return repositoryInterface.onFailureRegistration();

    }
}
