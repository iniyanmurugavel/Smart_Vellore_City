package com.smart_vellore_city.E_Market.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.smart_vellore_city.E_Market.fragments.EMarketingFragment;

/**
 * Created by Priyadharshini on 17-11-2018.
 */

public class EMarketingPagerAdapter extends FragmentPagerAdapter {

    public static final int Num_of_Pages = 8;
    public static final String Titles[] = {"Vegetables", "Fruits", "Fishery", "Medicals",
            "Automobiles", "Flowers",
            "Organic Manures & Fertilizers",
            "Electronics"
    };


    public EMarketingPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Bundle b = new Bundle();
        EMarketingFragment fragment = new EMarketingFragment();
        b.putInt("CurrentPage", position + 1);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public int getCount() {
        return Num_of_Pages;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }
}
