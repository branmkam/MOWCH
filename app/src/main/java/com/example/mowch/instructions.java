package com.example.mowch;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class instructions extends AppCompatActivity {

    /*ListView listView;
    ListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    private SimpleAdapter sa;
    Button close;

    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_instructions);

        /*close = (Button) findViewById(R.id.close_instructions);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        listView = (ListView) findViewById(R.id.instructions_list);

        HashMap<String,String> item;
        for(int i = 0; i< addresses_list.length; i++){
            item = new HashMap<String,String>();
            item.put( "line1", addresses_list[i]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.addresslist,
                new String[] { "line1"},
                new int[] {R.id.list_instruction_item});
        ((ListView)findViewById(R.id.instructions_list)).setAdapter(sa);

*/



        // for displaying the popup
        /*DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width*.98), (int) (height*.625));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = 0;
        params.y = 400;
        getWindow().setAttributes(params);*/
    }

    private String[] addresses_list =
            {"go to the back",
                    "knock on back door","elderly"};


}
