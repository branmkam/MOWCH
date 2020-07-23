package com.example.mowch;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;


public class ListofRoutes extends Fragment {

    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public ListofRoutes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_listof_routes, container, false);

        ArrayList<ExampleDriver> exampleList = new ArrayList<>();
        exampleList.add(new ExampleDriver(R.drawable.ic_outline_map_24, "Route 1"));
        exampleList.add(new ExampleDriver(R.drawable.ic_outline_map_24,"Route 2"));
        exampleList.add(new ExampleDriver(R.drawable.ic_outline_map_24,"Route 3"));

        mrecyclerView = view.findViewById(R.id.recycler_view2);
        mrecyclerView.setHasFixedSize(false); // list size is bound to change
        layoutManager = new LinearLayoutManager(view.getContext());
        mAdapter = new RouteAdapter(exampleList);
        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(mAdapter);

        return view;
    }
}