package com.example.brainybearapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brainybearapp.R;
import com.example.brainybearapp.RecyclerViewAction;
import com.example.brainybearapp.ActivityShapes;
import com.example.brainybearapp.lists.ShapesList;

import java.util.ArrayList;


public class ShapeAdapter extends RecyclerView.Adapter<ShapeAdapter.ColorViewHolder>{
    ArrayList<ShapesList> shape;
    private Context mContext;
    private RecyclerViewAction recyclerViewAction;

    public ShapeAdapter(ArrayList<ShapesList> shape, Context mContext, RecyclerViewAction recyclerViewAction) {
        this.shape = shape;
        this.mContext = mContext;
        this.recyclerViewAction = recyclerViewAction;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_shapes, parent, false);
        ColorViewHolder colorViewHolder = new ColorViewHolder(view);
        return colorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        final ShapesList shapelist = shape.get(position);

        holder.title.setImageResource(shapelist.getImage());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewAction.onViewClicked(v.getId(), holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return shape.size();
    }

    public static class ColorViewHolder extends RecyclerView.ViewHolder {

        ImageView title;
        public View layout;
        CardView container;

        public ColorViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;

            //Hooks
            title = itemView.findViewById(R.id.content);

        }


    }


}























