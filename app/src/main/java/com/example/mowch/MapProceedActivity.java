package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MapProceedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proceed2);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width*.87), (int) (height*.29));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        getWindow().setAttributes(params);

        Button pause = (Button) findViewById(R.id.pause_button);
        Button go = (Button) findViewById(R.id.go);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openOtherPopup();

            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go();

            }
        });

        }


    @Override
    public void onBackPressed() {

    }

    private void openOtherPopup() {
        finish();
        Intent intent = new Intent(this, PausePop.class);
        startActivity(intent);
    }
    private void go() {
        finish();
    }



}