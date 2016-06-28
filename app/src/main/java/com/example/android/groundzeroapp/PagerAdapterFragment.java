package com.example.android.groundzeroapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PagerAdapterFragment extends Fragment {

    TextView textView;

    public static PagerAdapterFragment getInstance(int position) {
        PagerAdapterFragment fragment = new PagerAdapterFragment();
        Bundle args = new Bundle(3);
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int position = bundle.getInt("position");
        View layout = inflater.inflate(R.layout.fragment_widening_layout, container, false);
        textView = (TextView) layout.findViewById(R.id.fragment_text_view);

        textView.setText("Page " + position);

        return layout;
    }
}
