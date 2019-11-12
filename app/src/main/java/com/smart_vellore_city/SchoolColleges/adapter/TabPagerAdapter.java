package com.smart_vellore_city.SchoolColleges.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.smart_vellore_city.SchoolColleges.fragments.SchoolCollegeFragment;


public class TabPagerAdapter extends FragmentPagerAdapter {
    public static  int count = 2;
    public static String[] titles = {"Schools","Colleges"};

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Bundle b = new Bundle();
        SchoolCollegeFragment schoolCollegeFragment = new SchoolCollegeFragment();
        b.putInt("currentPage",i+1);
        schoolCollegeFragment.setArguments(b);
        return schoolCollegeFragment;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return count;
    }
}
