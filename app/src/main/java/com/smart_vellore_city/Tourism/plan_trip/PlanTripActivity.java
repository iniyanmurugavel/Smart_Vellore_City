package com.smart_vellore_city.Tourism.plan_trip;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.smart_vellore_city.R;


public class PlanTripActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    PlanTripPagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide);

        initializeToolbarAndViews();
    }



    /**
     * Initializing Toolbar and RecyclerView
     */
    private void initializeToolbarAndViews() {

        Toolbar toolbar = findViewById(R.id.pt_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        viewPager = (ViewPager) findViewById(R.id.pt_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.pt_sliding_tabs);

        pagerAdapter = new PlanTripPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}
