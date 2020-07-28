package com.example.mowch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


public class ChangingEmailSettings extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changing_email_settings);



        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width*.85), (int) (height*.60));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = 0;
        getWindow().setAttributes(params);

        Button pause = (Button) findViewById(R.id.confirmchange);
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
        Intent intent = new Intent(this, SettingsFragment.class);
        startActivity(intent);
    }
}