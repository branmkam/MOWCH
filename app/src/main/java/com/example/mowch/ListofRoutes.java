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

        ArrayList<ExampleRoute> exampleList = new ArrayList<>();

        Driver d1 = new Driver("Brandon Kaminski", "branmkam@live.unc.edu", "d1pwd");
        Driver d2 = new Driver("John Smith", "johnsmith@example.net", "d2pwd");
        Address a1 = new Address("Charlotte", "Wang","100 E Franklin Street", "Chapel Hill", false, "no pork");
        Address a2 = new Address("Nada", "Rahmouni", "200 E Franklin Street", "Chapel Hill", false, "");
        Address a3 = new Address("Vivek", "Patel", "300 E Franklin Street", "Chapel Hill", false, "no peanuts");
        Address a4 = new Address("Tatiana", "Kelliher", "400 E Franklin Street", "Chapel Hill", false, "");
        Address a5 = new Address("Maya", "Agnihotri", "500 E Franklin Street", "Chapel Hill", false, "");


        ArrayList<Address> allAddresses = new ArrayList<>();
        allAddresses.add(a1);
        allAddresses.add(a2);
        allAddresses.add(a3);
        allAddresses.add(a4);
        allAddresses.add(a5);

        Route rb = new Route(0);
        rb.setAddresses(allAddresses);
        rb.setDriverAssigned(d1);

        Route r2 = new Route(1);
        r2.setAddresses(allAddresses);
        r2.setDriverAssigned(d2);

        Route r3 = new Route(2);
        r3.setAddresses(allAddresses);
        r3.setDriverAssigned(d1);


        exampleList.add(new ExampleRoute(R.drawable.ic_outline_map_24, rb));
        exampleList.add(new ExampleRoute(R.drawable.ic_outline_map_24,rb));
        exampleList.add(new ExampleRoute(R.drawable.ic_outline_map_24,rb));

        mrecyclerView = view.findViewById(R.id.recycler_view2);
        mrecyclerView.setHasFixedSize(false); // list size is bound to change
        layoutManager = new LinearLayoutManager(view.getContext());
        mAdapter = new RouteAdapter(exampleList);
        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(mAdapter);

        return view;
    }
}