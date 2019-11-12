package com.smart_vellore_city.agri.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.smart_vellore_city.agri.fragment.AgriFragment;


/**
 * Created by Priyadharshini on 16-11-2018.
 */

public class AgriPagerAdapter extends FragmentPagerAdapter {

    private static final int PageCount = 3;
    private static final String title[] = {"Vegetables", "Fruits", "Flowers"};

    public AgriPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Bundle data = new Bundle();
        AgriFragment oneFragment = new AgriFragment();
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
