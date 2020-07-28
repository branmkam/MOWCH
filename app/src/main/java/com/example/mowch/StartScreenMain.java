package com.example.mowch;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.MapFragment;

import java.util.ArrayList;


public class StartScreenMain extends Fragment {

    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public StartScreenMain() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_start_screen2, container, false);

        Button start = (Button) view.findViewById(R.id.start_button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<InfoBox> exampleList = new ArrayList<>();
        exampleList.add(new InfoBox(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new InfoBox(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new InfoBox(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new InfoBox(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new InfoBox(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new InfoBox(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new InfoBox(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new InfoBox(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new InfoBox(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));


        mrecyclerView = view.findViewById(R.id.start_screen_recycler_view);
        mrecyclerView.setHasFixedSize(false); // list size is bound to change
        layoutManager = new LinearLayoutManager(view.getContext());
        mAdapter = new StartScreenAdapter(exampleList);  //error right here
        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(mAdapter);

        return view;
    }


}