package com.example.mowch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationsViewHolder> {

    private ArrayList<InfoBox> mNotifications; // InfoBox can be used

    int mExpandedPosition = -1;

    public NotificationAdapter(ArrayList<InfoBox> mExampleList) {
        mNotifications = mExampleList;
    }

    public static class NotificationsViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;
//        public ImageButton infoButton;
//        public ImageButton removeDriver;
//        public Button assignDriver;


        public NotificationsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.notif_icon);
            textView = itemView.findViewById(R.id.driver3);
//            infoButton = itemView.findViewById(R.id.infobutton);
//            removeDriver = itemView.findViewById(R.id.remove_button2);
//            assignDriver = itemView.findViewById(R.id.assign_driver);
        }

        public void bind(InfoBox driver) {
            boolean expanded = driver.isExpanded();
            boolean read = driver.isRead();
            // Set the visibility based on state
            if(expanded) {
                imageView.setImageResource(R.drawable.notifications_read);
                driver.setRead(true);
            }
            if(read) {
                imageView.setImageResource(R.drawable.notifications_read);
                driver.setRead(true);
            }
            View subItem = itemView.findViewById(R.id.sub_item3);
            subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);

        }
    }

//    public NotificationAdapter(ArrayList<String> infoBox){
//        mNotifications = infoBox;
//    }
    @NonNull


    public NotificationAdapter.NotificationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notifcardview, parent, false);
        NotificationAdapter.NotificationsViewHolder evh = new NotificationAdapter.NotificationsViewHolder(v);
        return evh;
    }


    public void onBindViewHolder(@NonNull NotificationAdapter.NotificationsViewHolder holder, int position) {

        InfoBox currentItem = mNotifications.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());   // setting icon
        holder.textView.setText(currentItem.getDriverName());  // setting name


        /*holder.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context h = v.getContext();
                Intent intent = new Intent(h, RouteInstructionsActivity.class);
                h.startActivity(intent);
            }
        });

        holder.removeDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*Context h = v.getContext();
                Intent intent = new Intent(h, EmergencyPop.class);
                h.startActivity(intent);*//*
            }
        });

        holder.assignDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context h = v.getContext();
                Intent intent = new Intent(h, DriversPopActivity.class);
                h.startActivity(intent);
            }
        });*/

        holder.itemView.setOnClickListener(v -> {
            // Get the current state of the item
            boolean expanded = currentItem.isExpanded();
            // Change the state
            currentItem.setExpanded(!expanded);
            // Notify the adapter that item has changed
            notifyItemChanged(position);
        });

        // make driver clickable and expand


        holder.bind(currentItem);


       /* final boolean isExpanded = position==mExpandedPosition;
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(position);
            }
        });*/


    }

    public int getItemCount() {
        return mNotifications.size();
    }



}