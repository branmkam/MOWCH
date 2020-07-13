package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SignupActivity extends AppCompatActivity {

    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup = (Button) findViewById(R.id.signup_button2);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });
    }

    /*private void openLoggingInActivity() {
        Intent intent = new Intent(this, LogginginActivity.class);
        startActivity(intent);
    }*/
    private void openSignUpActivity() {
        Intent intent = new Intent(this, AgreementsActivity.class);
        startActivity(intent);
    }

}