package com.example.mowch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import java.sql.Driver;
import java.util.ArrayList;

public class DriversPopActivity extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers_pop);

        ArrayList<ExampleDriver> exampleList = new ArrayList<>();
        exampleList.add(new ExampleDriver(R.drawable.user2, "John Smith"));
        exampleList.add(new ExampleDriver(R.drawable.user2,"Rachel Bearman"));
        exampleList.add(new ExampleDriver(R.drawable.user2,"Vivek Patel"));
        exampleList.add(new ExampleDriver(R.drawable.user2, "John Smith"));
        exampleList.add(new ExampleDriver(R.drawable.user2,"Rachel Bearman"));
        exampleList.add(new ExampleDriver(R.drawable.user2,"Vivek Patel"));
        exampleList.add(new ExampleDriver(R.drawable.user2, "John Smith"));
        exampleList.add(new ExampleDriver(R.drawable.user2,"Rachel Bearman"));
        exampleList.add(new ExampleDriver(R.drawable.user2,"Vivek Patel"));
        exampleList.add(new ExampleDriver(R.drawable.user2, "John Smith"));
        exampleList.add(new ExampleDriver(R.drawable.user2,"Rachel Bearman"));
        exampleList.add(new ExampleDriver(R.drawable.user2,"Vivek Patel"));



        AlertDialog.Builder builderSingle = new AlertDialog.Builder(DriversPopActivity.this, R.style.AppTheme_Transparent);
        builderSingle.setIcon(R.drawable.user2);
        builderSingle.setTitle("Select Driver:");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(DriversPopActivity.this, android.R.layout.select_dialog_item);
        arrayAdapter.add("Vivek");
        arrayAdapter.add("John");
        arrayAdapter.add("Rachel");
        arrayAdapter.add("Vivek");
        arrayAdapter.add("John");
        arrayAdapter.add("Rachel");
        arrayAdapter.add("Vivek");
        arrayAdapter.add("John");
        arrayAdapter.add("Rachel");
        arrayAdapter.add("Vivek");
        arrayAdapter.add("John");
        arrayAdapter.add("Rachel");
        arrayAdapter.add("Vivek");
        arrayAdapter.add("John");
        arrayAdapter.add("Rachel");
        arrayAdapter.add("Vivek");
        arrayAdapter.add("John");
        arrayAdapter.add("Rachel");
        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                AlertDialog.Builder builderInner = new AlertDialog.Builder(DriversPopActivity.this);
                finish();
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builderSingle.create();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        alertDialog.getWindow().setLayout((int) (width*.8), (int) (height*.8));

        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                finish();

            }
        });

        alertDialog.show();


        /*mrecyclerView = findViewById(R.id.recycler_view3);
        mrecyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        mAdapter = new DriverPopAdapter(exampleList);

        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(mAdapter);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.8));*/
       /* WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = 0;
        getWindow().setAttributes(params);*/
    }



}