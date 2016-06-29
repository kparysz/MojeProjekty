package com.example.android.groundzeroapp.fieldofviewwidening;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.groundzeroapp.R;


public class FieldOfViewFragment extends Fragment {

    ImageView firstGrid, secondGrid, thirdGrid, fourthGrid;

    public FieldOfViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_field_of_view, container, false);
        firstGrid = (ImageView) view.findViewById(R.id.field_of_view_grid_one);
        secondGrid = (ImageView) view.findViewById(R.id.field_of_view_grid_two);
        thirdGrid = (ImageView) view.findViewById(R.id.field_of_view_grid_three);
        fourthGrid = (ImageView) view.findViewById(R.id.field_of_view_grid_four);

        firstGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DRY Please extract this piece of code to extra static method
                Intent intent = new Intent(getActivity(), Pyramids.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        secondGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SchultzTables.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        thirdGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WideningAnimation.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        fourthGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WideningText.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        return view;
    }

}
























