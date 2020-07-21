package com.example.mowch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class StartScreen2 extends Fragment {

    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public StartScreen2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_start_screen2, container, false);

        ArrayList<ExampleDriver> exampleList = new ArrayList<>();
        exampleList.add(new ExampleDriver(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new ExampleDriver(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new ExampleDriver(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new ExampleDriver(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new ExampleDriver(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new ExampleDriver(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new ExampleDriver(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new ExampleDriver(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));
        exampleList.add(new ExampleDriver(R.drawable.ic_outline_home_24, "123 H Street \nCarrboro, NC\n27232"));


        mrecyclerView = view.findViewById(R.id.start_screen_recycler_view);
        mrecyclerView.setHasFixedSize(false); // list size is bound to change
        layoutManager = new LinearLayoutManager(view.getContext());
        mAdapter = new StartScreenAdapter(exampleList);  //error right here
        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(mAdapter);

        return view;
    }
}