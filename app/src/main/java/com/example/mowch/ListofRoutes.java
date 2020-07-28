package com.example.mowch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        ArrayList<InfoBox> exampleList = new ArrayList<>();
        exampleList.add(new InfoBox(R.drawable.ic_outline_map_24, "Route A"));
        exampleList.add(new InfoBox(R.drawable.ic_outline_map_24,"Route B"));
        exampleList.add(new InfoBox(R.drawable.ic_outline_map_24,"Route C"));

        mrecyclerView = view.findViewById(R.id.recycler_view2);
        mrecyclerView.setHasFixedSize(false); // list size is bound to change
        layoutManager = new LinearLayoutManager(view.getContext());
        mAdapter = new RouteAdapter(exampleList);
        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(mAdapter);

        return view;
    }
}