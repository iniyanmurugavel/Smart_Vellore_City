package com.smart_vellore_city.Tourism.plan_trip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Priyadharshini on 16-11-2018.
 */

public class PlanTripPagerAdapter extends FragmentPagerAdapter {

    private static final int PageCount = 4;
    private static final String title[] = {"Tour Agent", "Hotel", "Resort", "Pg & Hostel"};

    public PlanTripPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Bundle data = new Bundle();
        PlanTripFragment oneFragment = new PlanTripFragment();
        data.putInt("current_page", position + 1);
        oneFragment.setArguments(data);
        return oneFragment;
    }

    @Override
    public int getCount() {
        return PageCount;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];

    }
}
