package com.example.android.groundzeroapp;


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


public class NavigationDrawerFragment extends Fragment implements NavDrawerAdapter.ClickOnItem{


    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    RecyclerView recyclerView;

    public NavigationDrawerFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        NavDrawerAdapter adapter = new NavDrawerAdapter(getActivity(), fillListWithData());
        adapter.setClickOnItem(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void setUpData(DrawerLayout drawerLayout, Toolbar toolbar) {
        this.drawerLayout = drawerLayout;
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
        };
        drawerLayout.addDrawerListener(drawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                drawerToggle.syncState();
            }
        });
    }

    public List<NavDrawerSingleRowRepresentation> fillListWithData() {
        List<NavDrawerSingleRowRepresentation> singleRowRepresentations = new ArrayList<>();
        Resources resources = getResources();
        String[] titles = resources.getStringArray(R.array.titles);
        for (int i = 0; i < titles.length; i++) {
            NavDrawerSingleRowRepresentation singleRow = new NavDrawerSingleRowRepresentation();
            singleRow.title = titles[i];
            singleRowRepresentations.add(singleRow);
        }
        return singleRowRepresentations;
    }

    @Override
    public void itemClicked(int position) {
        ToastMessage.showToast(getActivity(), "Let's do this " + position);
    }
}
