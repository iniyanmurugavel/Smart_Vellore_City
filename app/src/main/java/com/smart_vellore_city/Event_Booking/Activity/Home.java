package com.smart_vellore_city.Event_Booking.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.smart_vellore_city.R;

public class Home extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    ViewPager viewPager;
    TabLayout tabLayout;
    Fragment eventFragment,nodataFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_home);

        Toolbar toolbar = (Toolbar)findViewById(R.id.htab_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Event Booking");

        setupTabLayout();

    }
    private void setupTabLayout() {
        eventFragment = new EventFragment();
        nodataFragment = new NoDataFragment();
        replaceFragment(eventFragment);
        tabLayout = (TabLayout) findViewById(R.id.htab_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Today"),true);
        tabLayout.addTab(tabLayout.newTab().setText("This Week"));
        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        setCurrentTabFragment(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    private void setCurrentTabFragment(int tabPosition)
    {
        switch (tabPosition)
        {
            case 0 :
                replaceFragment(eventFragment);
                break;
            case 1 :
                replaceFragment(nodataFragment);
                break;
            case 2 :
                replaceFragment(eventFragment);
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
