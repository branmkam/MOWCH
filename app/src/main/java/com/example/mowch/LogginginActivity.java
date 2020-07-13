package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class LogginginActivity extends AppCompatActivity {

    Button signup;
    Button login;
    Button forgotpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggingin);

        signup = (Button) findViewById(R.id.signup_button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });

        login = (Button) findViewById(R.id.loginfield);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartScreenActivity();
            }
        });

        forgotpassword = (Button) findViewById(R.id.forgot_password_button);
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgotPasswordActivity();;
            }
        });


        }
    private void openForgotPasswordActivity(){
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    private void openSignUpActivity() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
    private void openStartScreenActivity() {
        Intent intent = new Intent(this, UserNavigationDrawerActivity.class);
        startActivity(intent);
    }




}
