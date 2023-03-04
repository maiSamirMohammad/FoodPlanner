package com.example.foodplanner.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.view.login.LoginActivity;
import com.example.foodplanner.view.signup.SignUpActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class StartScreenActivity extends AppCompatActivity {
    private Button loginBtn, signupBtn, skipBtn;
    SignInButton googleSignBtn;
    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;
    SharedPreferences.Editor editor;
    private  SharedPreferences sharedPreferences;
    String googleClientId = "855439930752-mg03i3irlhoi7afeis8j9qmb5rjfd9ng.apps.googleusercontent.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        initializeVariables();
        setListeners();
        googleSignIn();
    }
    private void initializeVariables()
    {
        loginBtn = findViewById(R.id.btn_start_login);
        signupBtn = findViewById(R.id.btn_start_signup);
        skipBtn =  findViewById(R.id.btn_start_skip);
        googleSignBtn = findViewById(R.id.btn_start_google);
    }
    private void setListeners()
    {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartScreenActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartScreenActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void googleSignIn() {
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(googleClientId)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(StartScreenActivity.this, googleSignInOptions);

        googleSignBtn.setOnClickListener(view -> {
            Intent intent = googleSignInClient.getSignInIntent();
            startActivityForResult(intent, 100);
        });

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            // When user already sign in redirect to Leading activity
            startActivity(new Intent(StartScreenActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            if (signInAccountTask.isSuccessful()) {
                try {
                    GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class);
                    if (googleSignInAccount != null) {
                        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
                        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Google sign in successful", Toast.LENGTH_SHORT).show();

                                    FirebaseUser user = firebaseAuth.getCurrentUser();
                                    String userID = user.getUid();
                                    sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
                                    editor = sharedPreferences.edit();
                                    editor.putString("userID", userID);
                                    editor.commit();
                                    //firebaseFirebaseRepository.registerUserGoogle();

                                    startActivity(new Intent(StartScreenActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                } else {
                                    Toast.makeText(StartScreenActivity.this, "Firebase authentication Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}