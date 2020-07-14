package com.example.mowch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.DriverViewHolder> {
    private ArrayList<ExampleDriver> mExampleDriver;

    public static class DriverViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public DriverViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.route_icon);
            textView = itemView.findViewById(R.id.driver);
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
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView.setText(currentItem.getDriverName());
    }

    @Override
    public int getItemCount() {
        return mExampleDriver.size();
    }

}
