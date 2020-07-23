package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class DeliveryPopup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_popup2);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width*.89), (int) (height*.255));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        getWindow().setAttributes(params);

        Button yes = (Button) findViewById(R.id.yes_button);
        Button no = (Button) findViewById(R.id.no_button);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYesPopup();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNoPopup();
            }
        });


    }

    @Override
    public void onBackPressed() {

    }

    private void openYesPopup() {
        finish();
        Intent intent = new Intent(this, MapProceedActivity.class);
        startActivity(intent);
    }
    private void openNoPopup() {
        finish();
        Intent intent = new Intent(this, NoOnClickDeliveryPopup.class);
        startActivity(intent);
    }
}