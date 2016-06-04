package com.example.android.learning;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class NavigationDrawerFragment extends Fragment implements CustomAdapter.ClickListener {

    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    CustomAdapter adapter;

    public NavigationDrawerFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        adapter = new CustomAdapter(getActivity(), setUpDateForRecycler());
        adapter.setClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    public List<SingleRowRepresentation> setUpDateForRecycler() {
        Resources resources = getResources();

        List<SingleRowRepresentation> fillWithElements = new ArrayList<>();
        String[] titles = resources.getStringArray(R.array.titles);
        int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4};

        for (int i = 0; i < 100; i++) {
            SingleRowRepresentation singleRow = new SingleRowRepresentation();

            singleRow.title = titles[i % titles.length] + " " + i;
            singleRow.image = images[i % images.length];


            fillWithElements.add(singleRow);
        }
        return fillWithElements;
    }

    public void setUp(final Toolbar toolbar, DrawerLayout drawerLayout) {
        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if (slideOffset < 0.6) {
                    toolbar.setAlpha(1 - slideOffset);
                }
            }
        };
        drawerLayout.addDrawerListener(drawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                drawerToggle.syncState();
            }
        });
    }

    @Override
    public void itemClicked(View view, int position) {
        ToastMessage.showToast(getActivity(), position + "");
        startActivity(new Intent(getActivity(), SubActivity.class));
    }
}
