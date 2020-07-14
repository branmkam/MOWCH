package com.example.mowch;

import android.app.MediaRouteButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import java.util.ArrayList;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.DriverViewHolder> {
    private ArrayList<ExampleDriver> mExampleDriver;

    int mExpandedPosition = -1;
    public static class DriverViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public DriverViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.route_icon);
            textView = itemView.findViewById(R.id.driver);
        }

        public void bind(ExampleDriver driver) {
            boolean expanded = driver.isExpanded();
            // Set the visibility based on state
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
