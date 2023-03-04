package com.example.foodplanner.view.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodplanner.view.MainActivity;
import com.example.foodplanner.R;
import com.example.foodplanner.models.FirebaseFirebaseRepository;
import com.example.foodplanner.presenter.FirebasePresenter;
import com.example.foodplanner.presenter.FirebasePresenterInterface;
import com.example.foodplanner.view.login.LoginActivity;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import java.util.regex.Pattern;


public class SignUpActivity extends AppCompatActivity implements SignUpViewInterface {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-zA-Z])" +      //any letter
                    ".{8,}" +               //at least 8 characters
                    "$");
    private TextInputLayout textInputUsername ,textInputEmail,textInputPassword,textInputConfirmPassword;
    private ProgressBar progressBar;
    private FirebasePresenterInterface firebasePresenterInterface;
    private TextView goToLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
       // android.content.Context context=getApplicationContext();
        //initialize ui
        textInputUsername = findViewById(R.id.til_signup_person_name);
        textInputEmail = findViewById(R.id.til_signup_email);
        textInputPassword = findViewById(R.id.til_signup_password);
        textInputConfirmPassword = findViewById(R.id.til_signup_confirm_password);
        goToLogin =findViewById(R.id.tv_signup_login);
        progressBar= findViewById(R.id.progress_bar);


        //create presenter obj
        firebasePresenterInterface = new FirebasePresenter(this, FirebaseFirebaseRepository.getInstance(getApplicationContext()));

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //textWatcher to observe user input... is it empty?
        textInputUsername.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputUsername.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    textInputUsername.setError("Field can't be empty");
                }
            }
        });
        textInputEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputEmail.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    textInputEmail.setError("Field can't be empty");

                }

            }
        });
        textInputPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputPassword.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    textInputPassword.setError("Field can't be empty");

                }

            }
        });
        textInputConfirmPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputConfirmPassword.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    textInputConfirmPassword.setError("Field can't be empty");

                }

            }
        });


    }


    private boolean validateUsername() {
        String usernameInput = textInputUsername.getEditText().getText().toString();

        if (usernameInput.isEmpty()) {
            textInputUsername.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            textInputUsername.setError("Username too long");
            return false;
        } else {
            textInputUsername.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Please enter a valid email address");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }


    private boolean validatePassword() {
        String passwordInput = textInputPassword.getEditText().getText().toString();

        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            textInputPassword.setError("Password should be at least 8 characters including(digits and letters) in English");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }

    private boolean validateConfirmPassword() {
        String confirmPasswordInput = textInputConfirmPassword.getEditText().getText().toString();

        if (confirmPasswordInput.isEmpty()) {
            textInputConfirmPassword.setError("Field can't be empty");
            return false;
        } else if (!textInputPassword.getEditText().getText().toString().equals(confirmPasswordInput)) {
            textInputConfirmPassword.setError("Confirm password does not match password!");
            return false;
        } else {
            textInputConfirmPassword.setError(null);
            return true;
        }
    }

    // SIGNUP ON CLICK
    public void confirmInput(View v) {
        if (validateEmail() & validateUsername() & validatePassword() & validateConfirmPassword()) {
            progressBar.setVisibility(View.VISIBLE);

            Log.i("TAGTAGTAG", "confirmInput: " + textInputUsername.getEditText().getText().toString());

            registerUser(textInputUsername.getEditText().getText().toString(),
                    textInputEmail.getEditText().getText().toString(),
                    textInputPassword.getEditText().getText().toString(),
                    textInputConfirmPassword.getEditText().getText().toString()
            );

        }
    }


    @Override
    public void registerUser(String disPlayName, String email, String password, String confirmPassword) {
        firebasePresenterInterface.registerUser(disPlayName, email, password, confirmPassword);

    }

    @Override
    public void onSuccessRegistrationView() {
        progressBar.setVisibility(View.GONE);
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onFailureRegistrationView(@NonNull Task<AuthResult> task) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, (task.getException()).getMessage(), Toast.LENGTH_LONG).show();
        Log.i("TAGonFailureRegistration", "onFailureRegistration: "+task.getException().getMessage());

    }
}