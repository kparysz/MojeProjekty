package com.example.android.groundzeroapp;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    String[] tabs;

    public PagerAdapter(Context context, FragmentManager fm, String[] tabNames) {
        super(fm);
        this.tabs = tabNames;
    }

    @Override
    public Fragment getItem(int position) {
        PagerAdapterFragment fragment = PagerAdapterFragment.getInstance(position);
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

}
