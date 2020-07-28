package com.example.mowch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EmergencyPop extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_emergency);



        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width*.79), (int) (height*.38));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = -100;
        params.y = -60;
        getWindow().setAttributes(params);

        Button pause = (Button) findViewById(R.id.notify);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOtherPopup();

            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void openOtherPopup() {
        finish();
    }


}
