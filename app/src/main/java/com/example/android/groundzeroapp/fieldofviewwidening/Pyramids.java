package com.example.android.groundzeroapp.fieldofviewwidening;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.groundzeroapp.R;
import com.example.android.groundzeroapp.slidetabs.SlidingTabLayout;


public class Pyramids extends AppCompatActivity {

    ViewPager pager;
    SlidingTabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_pyramids);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        pager = (ViewPager) findViewById(R.id.numbersOfPyramidsPager);
        tabLayout = (SlidingTabLayout) findViewById(R.id.numbersOfPyramidsTabs);
        if (tabLayout != null) {
            tabLayout.setDistributeEvenly(true);
        }
        pager.setAdapter(new PyramidsPagerAdapter(getSupportFragmentManager()));
        tabLayout.setViewPager(pager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    class PyramidsPagerAdapter extends FragmentPagerAdapter {

        String[] tabs;

        public PyramidsPagerAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.pyramidsTabs);
        }

        @Override
        public Fragment getItem(int position) {
            MyFragment myFragment = MyFragment.getInstance(position);
            return myFragment;
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

    public static class MyFragment extends Fragment {
        TextView textView;

        public static MyFragment getInstance(int position) {
            MyFragment myFragment = new MyFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            myFragment.setArguments(args);
            return myFragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragment_widening_layout, container, false);
            textView = (TextView) layout.findViewById(R.id.fragment_text_view);
            Bundle bundle = getArguments();
            if (bundle != null) {
                textView.setText("Gowno " + bundle.getInt("position"));
            }
            return layout;
        }
    }
}



