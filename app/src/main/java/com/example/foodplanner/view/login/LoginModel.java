package com.example.foodplanner.view.login;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class LoginModel {
    private FirebaseAuth mAuth;

    public LoginModel() {
        mAuth = FirebaseAuth.getInstance();
    }

    public void loginUser(String email, String password, final LoginListener listener) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String userId = mAuth.getUid();
                            listener.onLoginSuccess(userId);
                        } else {
                            listener.onLoginError(task.getException().getMessage());
                        }
                    }
                });
    }

    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }

    public boolean validateCredentials(String email, String password, final LoginListener listener) {
        if (!isEmailValid(email)) {
            listener.onValidationError("Invalid email address");
            return false;
        } else if (!isPasswordValid(password)) {
            listener.onValidationError("Password should be at least 6 characters");
            return false;
        }
        return true;
    }
}