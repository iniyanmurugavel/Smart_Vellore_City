package com.smart_vellore_city.E_Market.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.smart_vellore_city.E_Market.adapter.EMarketingPagerAdapter;
import com.smart_vellore_city.R;

public class EMarketActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    EMarketingPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_market);

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


        viewPager = (ViewPager) findViewById(R.id.emarket_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        pagerAdapter = new EMarketingPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}
