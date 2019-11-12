package com.smart_vellore_city.agri.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.smart_vellore_city.agri.adapter.AgriPagerAdapter;
import com.smart_vellore_city.R;

/**
 * Created by Priyadharshini on 16-11-2018.
 */

public class AgriActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    AgriPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agri);

        initializeToolbarAndViews();

    }


    /**
     * Initializing Toolbar and RecyclerView
     */
    private void initializeToolbarAndViews() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        viewPager = (ViewPager) findViewById(R.id.agri_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        pagerAdapter = new AgriPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}
