package com.smart_vellore_city.Emergency_Services.appoinments.adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.smart_vellore_city.Emergency_Services.appoinments.fragments.DoctorListFragment;
import com.smart_vellore_city.SchoolColleges.fragments.SchoolCollegeFragment;


public class TabAppoinmentPagerAdapter extends FragmentPagerAdapter {
    private  final String TAG = TabAppoinmentPagerAdapter.class.getSimpleName();
    public static  int count = 4;
    public static String[] titles = {"All","Top Rated","Nearby","My List"};

    public TabAppoinmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Bundle b = new Bundle();
        DoctorListFragment doctorListFragment = new DoctorListFragment();
        b.putInt("currentPage",i+1);
        doctorListFragment.setArguments(b);
        return doctorListFragment;

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
