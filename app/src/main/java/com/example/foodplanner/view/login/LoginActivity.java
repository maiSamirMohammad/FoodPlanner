package com.example.foodplanner.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.view.LeadingActivity;

public class LoginActivity extends AppCompatActivity implements LoginListener {

    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private ProgressBar mProgressBar;

    private LoginPresenterInterface mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPresenter = new LoginPresenter(this);

        mEmailEditText = findViewById(R.id.email_edit_text);
        mPasswordEditText = findViewById(R.id.password_edit_text);
        mLoginButton = findViewById(R.id.login_button);
        mProgressBar = findViewById(R.id.progress_bar);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                if (validateCredentials(email, password)) {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mPresenter.loginUser(email, password);
                }
            }
        });
    }

    @Override
    public void onValidationError(String message) {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess() {
        mProgressBar.setVisibility(View.GONE);
        Intent intent = new Intent(this, LeadingActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginError(String message) {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private boolean validateCredentials(String email, String password) {
        // Check for a valid email address
        if (TextUtils.isEmpty(email)) {
            mEmailEditText.setError("getString(R.string.error_field_required)");
            mEmailEditText.requestFocus();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmailEditText.setError("getString(R.string.error_invalid_email)");
            mEmailEditText.requestFocus();
            return false;
        }

        // Check for a valid password
        if (TextUtils.isEmpty(password)) {
            mPasswordEditText.setError("getString(R.string.error_field_required)");
            mPasswordEditText.requestFocus();
            return false;
        } else if (password.length() < 6) {
            mPasswordEditText.setError("getString(R.string.error_invalid_password)");
            mPasswordEditText.requestFocus();
            return false;
        }

        return true;
    }
}