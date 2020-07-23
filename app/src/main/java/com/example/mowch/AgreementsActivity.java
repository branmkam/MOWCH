package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;


public class AgreementsActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreements);

        textView = findViewById(R.id.lorem_ipsum2);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}