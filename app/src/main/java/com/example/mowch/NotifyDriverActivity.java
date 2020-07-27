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

public class NotifyDriverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifying_driver);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width*.79), (int) (height*.38));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        getWindow().setAttributes(params);

        String confirm = "Message Sent!";
        Button send_button = (Button) findViewById(R.id.send_button_contact);
        TextView message = findViewById(R.id.contact_driver);
        EditText editText = findViewById(R.id.type_here);
        send_button = findViewById(R.id.send_button_contact);
        Button finalSend_button = send_button;
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        finish();
                    }
                }, 200);
                finalSend_button.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                message.setText(confirm);
                message.setY(435);

            }
        });

    }


}