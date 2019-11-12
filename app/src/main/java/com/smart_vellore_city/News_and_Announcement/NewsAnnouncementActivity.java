package com.smart_vellore_city.News_and_Announcement;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.smart_vellore_city.R;


public class NewsAnnouncementActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    NATabPageFragmentAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_announcement);

        initializeToolbarAndViews();

    }

    /**
     * Initializing Toolbar and RecyclerView
     */
    private void initializeToolbarAndViews() {

        Toolbar toolbar = findViewById(R.id.tourism_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.na_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        pagerAdapter = new NATabPageFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
