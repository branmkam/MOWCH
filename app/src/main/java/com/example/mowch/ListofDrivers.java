package com.example.mowch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ListofDrivers extends Fragment {

    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public ListofDrivers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_listof_drivers, container, false);

        ArrayList<ExampleDriver> exampleList = new ArrayList<>();
        exampleList.add(new ExampleDriver(R.drawable.user2, "John Smith"));
        exampleList.add(new ExampleDriver(R.drawable.user2,"Rachel Bearman"));
        exampleList.add(new ExampleDriver(R.drawable.user2,"Vivek Patel"));

        mrecyclerView = view.findViewById(R.id.recycler_view);
        mrecyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(view.getContext());
        mAdapter = new DriverAdapter(exampleList);

        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(mAdapter);

        return view;



    }
}