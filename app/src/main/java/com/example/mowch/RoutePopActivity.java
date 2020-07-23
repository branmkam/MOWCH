package com.example.mowch;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

public class RoutePopActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers_pop);

        AlertDialog.Builder builderSingle = new androidx.appcompat.app.AlertDialog.Builder(RoutePopActivity.this, R.style.AppTheme_Transparent);
        builderSingle.setIcon(R.drawable.ic_outline_map_24);
        builderSingle.setTitle("Select Route:");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(RoutePopActivity.this, android.R.layout.select_dialog_item);
        arrayAdapter.add("Route A");
        arrayAdapter.add("Route B");
        arrayAdapter.add("Route A");
        arrayAdapter.add("Route B");
        arrayAdapter.add("Route A");
        arrayAdapter.add("Route B");
        arrayAdapter.add("Route A");
        arrayAdapter.add("Route B");
        arrayAdapter.add("Route A");
        arrayAdapter.add("Route B");
        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                AlertDialog.Builder builderInner = new AlertDialog.Builder(RoutePopActivity.this);
                finish();
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builderSingle.create();

        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                finish();

            }
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        alertDialog.getWindow().setLayout((int) (width*.8), (int) (height*.8));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = -100;
        params.y = -60;
        getWindow().setAttributes(params);

        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                finish();
            }
        });
        alertDialog.show();

    }
}