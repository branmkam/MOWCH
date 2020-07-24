package com.example.mowch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ListofDrivers extends Fragment {

    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private HeadAdmin headAdmin;

    public ListofDrivers() {
        // Required empty public constructor
    }

    //create default test case
    public void createTestFields(HeadAdmin h) {
        Admin rb = new Admin("Rachel Bearman", "rachelbearman@cchmow.org", "rAcHeL20");

        Driver d1 = new Driver("Brandon Kaminski", "branmkam@live.unc.edu", "d1pwd", rb);
        Driver d2 = new Driver("John Smith", "johnsmith@example.net", "d2pwd", rb);
        Address a1 = new Address("Charlotte", "Wang", "100 E Franklin Street", "Chapel Hill", false, "no pork");
        Address a2 = new Address("Nada", "Rahmouni", "200 E Franklin Street", "Chapel Hill", false, "");
        Address a3 = new Address("Vivek", "Patel", "300 E Franklin Street", "Chapel Hill", false, "no peanuts");
        Address a4 = new Address("Tatiana", "Kelliher", "400 E Franklin Street", "Chapel Hill", false, "");
        Address a5 = new Address("Maya", "Agnihotri", "500 E Franklin Street", "Chapel Hill", false, "");

        h.getAccounts().add(rb);
        h.getAccounts().add(d1);
        h.getAccounts().add(d2);
        h.getDrivers().add(d1);
        h.getDrivers().add(d2);

        ArrayList<Address> AL1 = new ArrayList<Address>();
        AL1.add(a1);
        AL1.add(a2);

        ArrayList<Address> AL2 = new ArrayList<Address>();
        AL1.add(a3);
        AL1.add(a4);
        AL1.add(a5);

        Route r1 = new Route(1);
        r1.setAddresses(AL1);
        rb.assignRoute(d1, r1);

        Route r2 = new Route(2);
        r2.setAddresses(AL2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        headAdmin = HeadAdmin.getInstance();
        createTestFields(headAdmin);

        View view =  inflater.inflate(R.layout.fragment_listof_drivers, container, false);

        ArrayList<ExampleDriver> exampleList = new ArrayList<>();
        for(Driver d : headAdmin.getDrivers())
        {
            ExampleDriver ed = new ExampleDriver(R.drawable.user2, d);
            exampleList.add(ed);
        }

        mrecyclerView = view.findViewById(R.id.recycler_view);
        mrecyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(view.getContext());
        mAdapter = new DriverAdapter(exampleList);

        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(mAdapter);

        return view;



    }
}