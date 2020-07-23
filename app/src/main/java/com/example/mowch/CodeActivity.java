package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        Button code = (Button) findViewById(R.id.reset_password);
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencodeActivity();
            }
        });
    }

    private void opencodeActivity() {
        Intent intent = new Intent(this, ForgotPasswordLastActivity.class);
        startActivity(intent);
    }
}