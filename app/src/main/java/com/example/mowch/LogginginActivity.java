package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class LogginginActivity extends AppCompatActivity {

    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggingin);

        signup = (Button) findViewById(R.id.signup_button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennewActivity();
            }
        });

        }

    private void opennewActivity() {
        Intent intent = new Intent(this, ForgotPasswordLastActivity.class);
        startActivity(intent);
    }


}
