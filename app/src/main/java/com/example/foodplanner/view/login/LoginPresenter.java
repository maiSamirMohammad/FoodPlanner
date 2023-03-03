package com.example.foodplanner.view.login;

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
    public void onLoginSuccess() {
        mListener.onLoginSuccess();
    }

    @Override
    public void onLoginError(String errorMessage) {
        mListener.onLoginError(errorMessage);
    }
}
