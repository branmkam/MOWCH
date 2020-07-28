package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class AgreementsActivity extends AppCompatActivity {
TextView textView;
String fullName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreements);
        Intent intent = getIntent();
        fullName = intent.getStringExtra("full_name");

        textView = findViewById(R.id.lorem_ipsum2);
        textView.setMovementMethod(new ScrollingMovementMethod());

        Button agree = (Button) findViewById(R.id.agree);
        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });
    }

    private void openSignUpActivity() {
        Intent intent = new Intent(this, UserNavigationDrawerActivity.class);
        intent.putExtra("full_name2", fullName);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }
}