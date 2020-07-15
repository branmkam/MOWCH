package com.example.mowch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder>{
    
    private ArrayList<ExampleDriver> mExampleRoute; // ExampleDriver can be used

    int mExpandedPosition = -1;
    public static class RouteViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public RouteViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.route_icon);
            textView = itemView.findViewById(R.id.driver2);
        }

        public void bind(ExampleDriver driver) {
            boolean expanded = driver.isExpanded();
            // Set the visibility based on state

            View button2 = itemView.findViewById(R.id.infobutton);
            if(expanded) {
                button2.setVisibility(View.VISIBLE); // make it appear when it is clicked on
            }
            if(!expanded) {
                button2.setVisibility(View.GONE); // make it disappear when it is closed out
            }
            View subItem = itemView.findViewById(R.id.sub_item2);
            subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);

        }
    }

    public RouteAdapter(ArrayList<ExampleDriver> exampleDriver){
        mExampleRoute = exampleDriver;
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

        ExampleDriver currentItem = mExampleRoute.get(position);
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
        return mExampleRoute.size();
    }

}
