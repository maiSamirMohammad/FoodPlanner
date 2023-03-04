package com.example.foodplanner.presenter;

import com.example.foodplanner.view.login.LoginListener;
import com.example.foodplanner.view.login.LoginModel;

public class LoginPresenter implements LoginPresenterInterface, LoginListener {

    private LoginModel mModel;
    private LoginListener mListener;

    public LoginPresenter(LoginListener listener) {
        mModel = new LoginModel();
        mListener = listener;
    }

    @Override
    public void loginUser(String email, String password) {
        mModel.loginUser(email, password, mListener);
    }

    public boolean validateCredentials(String email, String password) {
        return mModel.validateCredentials(email, password, mListener);
    }

    @Override
    public void onValidationError(String message) {

    }

    @Override
    public void onLoginSuccess(String userId) {
        mListener.onLoginSuccess(userId);
    }

    @Override
    public void onLoginError(String errorMessage) {
        mListener.onLoginError(errorMessage);
    }
}
