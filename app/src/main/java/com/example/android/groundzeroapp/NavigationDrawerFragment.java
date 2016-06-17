package com.example.android.groundzeroapp;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
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

import flashing.FlashingFragment;
import lookup.LookUpFragment;
import speedreading.SpeedReadingFragment;
import speedreadingtests.SpeedReadingTests;
import fieldofviewwidening.FieldOfViewFragment;
import warmup.WarmUpFragment;


public class NavigationDrawerFragment extends Fragment implements NavDrawerAdapter.ClickOnItem {


    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    RecyclerView recyclerView;
    int position;


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
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
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

        Fragment fragment;

        if (position == 0) {
            fragment = new SpeedReadingTests();
            setFragment(fragment);
        }
        else if (position == 1) {
            fragment = new FieldOfViewFragment();
            setFragment(fragment);
        } else if (position == 2) {
            fragment = new FlashingFragment();
            setFragment(fragment);
        } else if (position == 3) {
            fragment = new LookUpFragment();
            setFragment(fragment);
        } else if (position == 4) {
            fragment = new WarmUpFragment();
            setFragment(fragment);
        } else if (position == 5) {
            fragment = new SpeedReadingFragment();
            setFragment(fragment);
        } else {
            ToastMessage.showToast(getActivity(), "Fragment error");
        }
        drawerLayout.closeDrawer(GravityCompat.START);

    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container_for_fragments, fragment)
                .commit();
    }

}
