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

import com.example.android.groundzeroapp.fieldofviewwidening.FieldOfViewFragment;
import com.example.android.groundzeroapp.flashing.FlashingFragment;
import com.example.android.groundzeroapp.lookup.LookUpFragment;
import com.example.android.groundzeroapp.speedreading.SpeedReadingFragment;
import com.example.android.groundzeroapp.speedreadingtests.SpeedReadingTests;
import com.example.android.groundzeroapp.warmup.WarmUpFragment;


public class NavigationDrawerFragment extends Fragment implements NavDrawerAdapter.ClickOnItem {


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
        int[] fragmentIDs = {R.id.speed_reading_test_root, R.id.field_of_view_root,
                R.id.look_up_root, R.id.warm_up_root, R.id.speed_reading_root, R.id.flashing_root};
        for (int i = 0; i < titles.length; i++) {
            NavDrawerSingleRowRepresentation singleRow = new NavDrawerSingleRowRepresentation();
            singleRow.title = titles[i];
            singleRow.id = fragmentIDs[i];
            singleRowRepresentations.add(singleRow);
        }
        return singleRowRepresentations;
    }

    @Override
    public void itemClicked(int viewId) {

        Fragment fragment;

        switch (viewId) {
            case R.id.speed_reading_test_root:
                fragment = new SpeedReadingTests();
                setFragment(fragment);
                break;
            case R.id.field_of_view_root:
                fragment = new FieldOfViewFragment();
                setFragment(fragment);
                break;
            case R.id.flashing_root:
                fragment = new FlashingFragment();
                setFragment(fragment);
                break;
            case R.id.look_up_root:
                fragment = new LookUpFragment();
                setFragment(fragment);
                break;
            case R.id.warm_up_root:
                fragment = new WarmUpFragment();
                setFragment(fragment);
                break;
            case R.id.speed_reading_root:
                fragment = new SpeedReadingFragment();
                setFragment(fragment);
                break;
            default:
                ToastMessage.showToast(getActivity(), "Fragment error");
        }

        drawerLayout.closeDrawer(GravityCompat.START);

    }

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container_for_fragments, fragment)
                .commit();
    }


}
