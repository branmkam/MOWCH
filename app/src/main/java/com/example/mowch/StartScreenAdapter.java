package com.example.mowch;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StartScreenAdapter extends RecyclerView.Adapter<StartScreenAdapter.StartScreenViewHolder>{

    private ArrayList<ExampleDriver> mExampleStart;

    public static class StartScreenViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public ImageButton infoButton;

        public StartScreenViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.icon_route);
            textView = itemView.findViewById(R.id.route_address);
            infoButton = itemView.findViewById(R.id.info_button_on_start);
        }

    }

    public StartScreenAdapter(ArrayList<ExampleDriver> exampleDriver){
        mExampleStart = exampleDriver;
    }

    @NonNull
    @Override
    public StartScreenAdapter.StartScreenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.startcardview, parent, false);
        StartScreenAdapter.StartScreenViewHolder evh = new StartScreenAdapter.StartScreenViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull StartScreenAdapter.StartScreenViewHolder holder, int position) {
        ExampleDriver currentItem = mExampleStart.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());   // setting icon
        holder.textView.setText(currentItem.getDriverName());  // setting name
        holder.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context h = v.getContext();
                Intent intent = new Intent(h, InstrutionsForRouteActivity.class);
                h.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mExampleStart.size();
    }

}


