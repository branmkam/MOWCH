package com.example.mowch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.zip.DataFormatException;

public class InstrutionsForRouteActivity extends AppCompatActivity {


    ListView listView;
    String[] instructions_string = new String[]{"go to the back", "wait", "knock quietly", "wait", "knock quietly", "wait", "knock quietly"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrutions_for_route);

        Button close = (Button) findViewById(R.id.close_instructions);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView = findViewById(R.id.instructions_list);
        Myadapter myadapter = new Myadapter(this, instructions_string);
        listView.setAdapter(myadapter);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width*.98), (int) (height*.43));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = 0;
        params.y = 700;
        getWindow().setAttributes(params);
      /*  ArrayAdapter<String> instructions_string = new ArrayAdapter<>(this, R.layout.instructionslist, )*/

    }

    class Myadapter extends ArrayAdapter<String> {
        Context context;
        String[] data;

        Myadapter(Context c, String title[]){
            super(c, R.layout.instructionslist, R.id.list_instruction_item, title) ;
            this.context = c;
            this.data = title;

        }

       /* @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.instructionslist, parent, false);


            return super.getView(position, convertView, parent);
        }
    }*/
    }

}