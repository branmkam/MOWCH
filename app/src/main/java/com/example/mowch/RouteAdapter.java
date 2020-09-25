package com.example.mowch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder>{
    
    private ArrayList<ExampleRoute> mExampleRoute; // ExampleRoute can be used

    int mExpandedPosition = -1;
    public static class RouteViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView; // map icon
        public TextView textView; // route name
        public ImageButton infoButton;
        public ImageButton removeDriver; // remove driver red button
        public Button assignDriver;
        public TextView driverName;

        public RouteViewHolder(@NonNull View itemView) {
            super(itemView);

            // setting all the relavent buttons/textviews
            imageView = itemView.findViewById(R.id.route_icon);
            textView = itemView.findViewById(R.id.driver2);
            infoButton = itemView.findViewById(R.id.infobutton);
            removeDriver = itemView.findViewById(R.id.remove_button2);
            assignDriver = itemView.findViewById(R.id.assign_driver);
            driverName = itemView.findViewById(R.id.route_name_current);
        }

        @SuppressLint("ResourceAsColor")
        public void bind(ExampleRoute route) {
            boolean expanded = route.isExpanded();
            boolean assigned = route.isAssigned();
            // Set the visibility based on state

            View button2 = itemView.findViewById(R.id.infobutton);
            View removeDriver2 = itemView.findViewById(R.id.remove_button2);
            TextView driverName2 = itemView.findViewById(R.id.route_name_current);

            if(expanded) {
                button2.setVisibility(View.VISIBLE); // make it appear when it is clicked on
            }
            if(!expanded) {
                button2.setVisibility(View.GONE); // make it disappear when it is closed out
            }

            if(assigned) {
                textView.setTextColor(R.color.lightblue);
                removeDriver2.setVisibility(View.VISIBLE); // make it appear when it is clicked on
                driverName2.setText("John Smith"); // TODO: make this into the actual selected driver
            }
            if(!assigned) {
                textView.setTextColor(R.color.black);
                removeDriver2.setVisibility(View.INVISIBLE); // make it disappear when it is closed out
                driverName2.setText("No driver selected");
            }

            View subItem = itemView.findViewById(R.id.sub_item2);
            int textColor = driverName.getCurrentTextColor();
            if(route.isAssigned()){
                driverName.setTextColor(R.color.lightblue);
            } else {
                driverName.setTextColor(R.color.black);
            }
            subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);
        }
    }

    public RouteAdapter(ArrayList<ExampleRoute> ExampleRoute){
        mExampleRoute = ExampleRoute;
    }
    @NonNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.routecardview, parent, false);
        RouteAdapter.RouteViewHolder evh = new RouteAdapter.RouteViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull RouteAdapter.RouteViewHolder holder, int position) {

        ExampleRoute currentItem = mExampleRoute.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());   // setting icon
        holder.textView.setText("Route " + currentItem.getRoute().getRouteNum());  // setting name
        holder.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context h = v.getContext();
                Intent intent = new Intent(h, RouteInstructionsActivity.class); // open the instructions
                h.startActivity(intent);
            }
        });

        holder.removeDriver.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                holder.removeDriver.setVisibility(View.INVISIBLE);
                holder.driverName.setText("No driver assigned");
                holder.textView.setTextColor(R.color.lightblue);
                currentItem.setAssigned(false);
                holder.bind(currentItem);
            }
        });

        holder.assignDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context h = v.getContext();
                Intent intent = new Intent(h, DriversPopActivity.class);
                h.startActivity(intent);
                currentItem.setAssigned(true);

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
        return mExampleRoute.size();
    }



}
