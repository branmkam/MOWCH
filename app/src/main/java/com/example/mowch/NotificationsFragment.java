package com.example.mowch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class NotificationsFragment extends Fragment {


    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_notifications, container, false);

        ArrayList<InfoBox> mExampleList = new ArrayList<>();
        mExampleList.add(new InfoBox(R.drawable.ellipse_new, "Message 1"));
        mExampleList.add(new InfoBox(R.drawable.ellipse_new, "Message 2"));
        mExampleList.add(new InfoBox(R.drawable.ellipse_new, "Message 3"));

        // Make sure when you are adding notifcations to add it to index 0 since you want the most recent ones to be on top

        mrecyclerView = view.findViewById(R.id.recycler_view_notif);
        mrecyclerView.setHasFixedSize(false); // list size is bound to change
        layoutManager = new LinearLayoutManager(view.getContext());
        mAdapter = new NotificationAdapter(mExampleList);
        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(mAdapter);
        return view;
    }

}