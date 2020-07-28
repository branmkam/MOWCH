package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandMessagePopActivity extends AppCompatActivity {

    ListView listView;
    ListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    private SimpleAdapter sa;
    Button close;

    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_message_pop);

        close = (Button) findViewById(R.id.button27);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView = (ListView) findViewById(R.id.notifications);


//        HashMap<String,String> item;
//        for(int i = 0; i< addresses_list.length; i++){
//            item = new HashMap<String,String>();
//            item.put( "line1", addresses_list[i][0]);
//            item.put( "line2", addresses_list[i][1]);
//            list.add( item );
//        }

//        sa = new SimpleAdapter(this, list,
//                R.layout.addresslist,
//                new String[] { "line1","line2" },
//                new int[] {R.id.listItem, R.id.line_b});
//        ((ListView)findViewById(R.id.notifications)).setAdapter(sa);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width*.98), (int) (height*.625));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = 0;
        params.y = 400;
        getWindow().setAttributes(params);
    }
}