package com.example.android.learning;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    List<SingleRowRepresentation> allElements = Collections.emptyList();
    LayoutInflater inflater;
    Context context;
    ClickListener clickListener;

    public CustomAdapter(Context context, List<SingleRowRepresentation> allElements) {
        this.allElements = allElements;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.single_navigation_drawer_row, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        SingleRowRepresentation current = allElements.get(position);
        holder.title.setText(current.title);
        holder.image.setImageResource(current.image);
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return allElements.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView image;

        public CustomViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.single_row_text);
            image = (ImageView) itemView.findViewById(R.id.single_row_image);
            itemView.setOnClickListener(this);
        }

        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClicked(v, getAdapterPosition());
            }
        }

    }

    public interface ClickListener {
        public void itemClicked(View view, int position);
    }
}
