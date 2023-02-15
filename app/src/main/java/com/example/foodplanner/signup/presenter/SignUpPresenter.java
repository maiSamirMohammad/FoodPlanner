package com.example.foodplanner.signup.presenter;

import androidx.annotation.NonNull;

import com.example.foodplanner.signup.model.RepositoryInterface;
import com.example.foodplanner.signup.model.SignupUser;
import com.example.foodplanner.signup.network.LogOutResult;
import com.example.foodplanner.signup.network.SignUpResult;
import com.example.foodplanner.signup.view.SignUpViewInterface;
import com.example.foodplanner.view.ProfileFragmentInterface;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignUpPresenter implements SignUpPresenterInterface, SignUpResult , LogOutResult {
    SignUpViewInterface signUpViewInterface;
    RepositoryInterface repositoryInterface;
    ProfileFragmentInterface profileFragmentInterface;

    public SignUpPresenter(SignUpViewInterface signUpViewInterface, RepositoryInterface repositoryInterface) {
        this.signUpViewInterface= signUpViewInterface;
        this.repositoryInterface= repositoryInterface;
    }
    public SignUpPresenter(ProfileFragmentInterface profileFragmentInterface, RepositoryInterface repositoryInterface) {
        this.profileFragmentInterface= profileFragmentInterface;
        this.repositoryInterface= repositoryInterface;
    }



    @Override
    public void registerUser(String disPlayName,String email,String password,String confirmPassword) {
        repositoryInterface.registerUser(this,new SignupUser(disPlayName,email,password,confirmPassword));

    }

    @Override
    public void logoutCurrentUser() {
        repositoryInterface.logoutCurrentUser(this);
    }

    @Override
    public void onSuccessRegistration() {
        signUpViewInterface.onSuccessRegistrationView();
    }

    @Override
    public void onFailureRegistration(@NonNull Task<AuthResult> task) {
        signUpViewInterface.onFailureRegistrationView( task);


    }

    @Override
    public void onSuccessLogOut() {
        profileFragmentInterface.onSuccessLogOut();

    }

    @Override
    public void onFailureLogOut(Exception exception) {
        profileFragmentInterface.onFailureLogOut(exception);

    }
}
