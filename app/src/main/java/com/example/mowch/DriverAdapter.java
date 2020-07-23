package com.example.mowch;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.DriverViewHolder> {
    private ArrayList<ExampleDriver> mExampleDriver;

    int mExpandedPosition = -1;
    public static class DriverViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;
        public ImageButton sendButton;
        public ImageButton removeRoute;
        public Button assignRoute;

        public DriverViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.route_icon);
            textView = itemView.findViewById(R.id.driver);
            sendButton = itemView.findViewById(R.id.sendMessage);
            removeRoute = itemView.findViewById(R.id.remove_button);
            assignRoute = itemView.findViewById(R.id.assign_route);
        }

        public void bind(ExampleDriver driver) {
            boolean expanded = driver.isExpanded();
            // Set the visibility based on state

            View button2 = itemView.findViewById(R.id.sendMessage);
            if(expanded) {
                button2.setVisibility(View.VISIBLE);
            }
            if(!expanded) {
                button2.setVisibility(View.GONE);
            }
            View subItem = itemView.findViewById(R.id.sub_item);
            subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);

        }
    }

    public DriverAdapter(ArrayList<ExampleDriver> exampleDriver){
        mExampleDriver = exampleDriver;
    }
    @NonNull
    @Override
    public DriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drivercardview, parent, false);
        DriverViewHolder evh = new DriverViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull DriverViewHolder holder, int position) {

        ExampleDriver currentItem = mExampleDriver.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());   // setting icon
        holder.textView.setText(currentItem.getDriverName());  // setting name
        holder.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context h = v.getContext();
                Intent intent = new Intent(h, NotifyDriverActivity.class);
                h.startActivity(intent);
            }
        });

        holder.removeRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: remove the route assigned
            }
        });

        holder.assignRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context h = v.getContext();
                Intent intent = new Intent(h, RoutePopActivity.class);
                h.startActivity(intent);
            }
        });


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


        /*final boolean isExpanded = position==mExpandedPosition;
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(position);
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return mExampleDriver.size();
    }

}
