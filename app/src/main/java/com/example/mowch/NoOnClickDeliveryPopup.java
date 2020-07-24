package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

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

public class NoOnClickDeliveryPopup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_on_click2);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width*.89), (int) (height*.38));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        getWindow().setAttributes(params);

        Button submit = (Button) findViewById(R.id.submit_delivery_status);

        TextView describe = findViewById(R.id.describe_why);
        EditText editText = findViewById(R.id.type_here2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                describe.setText("Thank you!");
                describe.setY(400);
                editText.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        openYesPopup();
                    }
                }, 200);
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

}