package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;

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


        mrecyclerView = findViewById(R.id.recycler_view3);
        mrecyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        mAdapter = new DriverPopAdapter(exampleList);

        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(mAdapter);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.8));
       /* WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = 0;
        getWindow().setAttributes(params);*/
    }
}