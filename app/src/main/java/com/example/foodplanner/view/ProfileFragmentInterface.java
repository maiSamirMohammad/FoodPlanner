package com.example.foodplanner.view;

public interface ProfileFragmentInterface {
    public void logoutCurrentUser();
    public void onSuccessLogOut();
    public void onFailureLogOut(Exception exception);
}
