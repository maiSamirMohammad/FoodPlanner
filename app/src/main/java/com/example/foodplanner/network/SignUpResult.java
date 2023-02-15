package com.example.foodplanner.network;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public interface SignUpResult {
    public void onSuccessRegistration();
    public void onFailureRegistration(@NonNull Task<AuthResult> task);
}
