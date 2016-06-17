package com.example.android.groundzeroapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.MyViewHolder> {

    LayoutInflater inflater;
    Context context;
    List<NavDrawerSingleRowRepresentation> singleRow = Collections.emptyList();
    ClickOnItem clickOnItem;

    public NavDrawerAdapter(Context context, List<NavDrawerSingleRowRepresentation> singleRow) {
        this.context = context;
        this.singleRow = singleRow;
        inflater = LayoutInflater.from(context);
    }

    public void setClickOnItem(ClickOnItem clickOnItem) {
        this.clickOnItem = clickOnItem;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_single_row, parent, false);
        MyViewHolder holder;
        holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavDrawerSingleRowRepresentation current = singleRow.get(position);
        holder.navDrawerTextItem.setText(current.title);
    }

    @Override
    public int getItemCount() {
        return singleRow.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView navDrawerTextItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            navDrawerTextItem = (TextView) itemView.findViewById(R.id.nav_drawer_single_row_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickOnItem.itemClicked(getAdapterPosition());
        }
    }

    interface ClickOnItem {
        public void itemClicked(int position);
    }
}
