package com.example.android.groundzeroapp.fieldofviewwidening;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.android.groundzeroapp.PagerAdapter;
import com.example.android.groundzeroapp.R;
import com.example.android.groundzeroapp.slidetabs.SlidingTabLayout;

public class WideningText extends AppCompatActivity {

    ViewPager pager;
    SlidingTabLayout tabLayout;
    String[] tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widening_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tabs = getResources().getStringArray(R.array.wideningTextTabs);
        pager = (ViewPager) findViewById(R.id.wideningTextPager);
        tabLayout = (SlidingTabLayout) findViewById(R.id.wideningTextTabs);
        if (tabLayout != null) {
            tabLayout.setDistributeEvenly(true);
        }
        pager.setAdapter(new PagerAdapter(this, getSupportFragmentManager(), tabs));
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
}
