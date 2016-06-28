package com.example.android.groundzeroapp.warmup;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.groundzeroapp.R;

public class WarmUpFragment extends Fragment {


    public WarmUpFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_warm_up, container, false);
    }

}
