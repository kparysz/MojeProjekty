package com.example.android.groundzeroapp.fieldofviewwidening;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.android.groundzeroapp.PagerAdapter;
import com.example.android.groundzeroapp.R;
import com.example.android.groundzeroapp.slidetabs.SlidingTabLayout;

public class SchultzTables extends AppCompatActivity {

    SlidingTabLayout tabLayout;
    ViewPager viewPager;
    String[] tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schultz_tables);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tabLayout = (SlidingTabLayout) findViewById(R.id.schultzTablesTabs);
        if (tabLayout != null) {
            tabLayout.setDistributeEvenly(true);
        }
        viewPager = (ViewPager) findViewById(R.id.schultzTablesPager);
        tabs = getResources().getStringArray(R.array.schultzTablesTabs);
        viewPager.setAdapter(new PagerAdapter(this, getSupportFragmentManager(), tabs));
        tabLayout.setViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
