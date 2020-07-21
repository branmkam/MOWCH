package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.zip.DataFormatException;

public class InstrutionsForRouteActivity extends AppCompatActivity {


    ListView listView;
    String[] instructions_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrutions_for_route);

        listView = findViewById(R.id.instructions_list);
      /*  ArrayAdapter<String> instructions_string = new ArrayAdapter<>(this, R.layout.instructionslist, )*/

    }


}