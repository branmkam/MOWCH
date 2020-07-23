package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgotPasswordActivity extends AppCompatActivity {
    Button signup;
    Button code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        signup = (Button) findViewById(R.id.signup_button3);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });

        code = (Button) findViewById(R.id.sendbutton);
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencodeActivity();
            }
        });


    }

    private void openSignUpActivity() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
    private void opencodeActivity() {
        Intent intent = new Intent(this, CodeActivity.class);
        startActivity(intent);
    }

}