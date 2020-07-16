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

public class DriverPopAdapter extends RecyclerView.Adapter<DriverPopAdapter.DriverPopViewHolder> {
    private ArrayList<ExampleDriver> mExampleDriver;

    int mExpandedPosition = -1;
    public static class DriverPopViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public DriverPopViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.route_icon);
            textView = itemView.findViewById(R.id.driver);
        }

        public void bind(ExampleDriver driver) {
            boolean expanded = driver.isExpanded();

            // Set the visibility based on state

        }
    }

    public DriverPopAdapter(ArrayList<ExampleDriver> exampleDriver){
        mExampleDriver = exampleDriver;
    }
    @NonNull
    @Override
    public DriverPopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.popdrivers, parent, false);
        DriverPopViewHolder evh = new DriverPopViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull DriverPopViewHolder holder, int position) {

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
