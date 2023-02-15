package com.example.foodplanner.presenter;

import androidx.annotation.NonNull;

import com.example.foodplanner.models.FirebaseRepositoryInterface;
import com.example.foodplanner.models.SignupUser;
import com.example.foodplanner.network.LogOutResult;
import com.example.foodplanner.network.SignUpResult;
import com.example.foodplanner.view.signup.SignUpViewInterface;
import com.example.foodplanner.view.ProfileFragmentInterface;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class FirebasePresenter implements FirebasePresenterInterface, SignUpResult , LogOutResult {
    SignUpViewInterface signUpViewInterface;
    FirebaseRepositoryInterface firebaseRepositoryInterface;
    ProfileFragmentInterface profileFragmentInterface;

    public FirebasePresenter(SignUpViewInterface signUpViewInterface, FirebaseRepositoryInterface firebaseRepositoryInterface) {
        this.signUpViewInterface= signUpViewInterface;
        this.firebaseRepositoryInterface = firebaseRepositoryInterface;
    }
    public FirebasePresenter(ProfileFragmentInterface profileFragmentInterface, FirebaseRepositoryInterface firebaseRepositoryInterface) {
        this.profileFragmentInterface= profileFragmentInterface;
        this.firebaseRepositoryInterface = firebaseRepositoryInterface;
    }



    @Override
    public void registerUser(String disPlayName,String email,String password,String confirmPassword) {
        firebaseRepositoryInterface.registerUser(this,new SignupUser(disPlayName,email,password,confirmPassword));

    }

    @Override
    public void logoutCurrentUser() {
        firebaseRepositoryInterface.logoutCurrentUser(this);
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
