package com.smart_vellore_city.Movie_Booking.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.smart_vellore_city.Movie_Booking.Adapter.MovieAdapter;
import com.smart_vellore_city.Movie_Booking.Bean.MovieBean;
import com.smart_vellore_city.Movie_Booking.MovieFragment.EnglishMovieFragment;
import com.smart_vellore_city.Movie_Booking.MovieFragment.TamilMovieFragment;
import com.smart_vellore_city.Movie_Booking.MovieFragment.TeluguMovieFragment;
import com.smart_vellore_city.R;

import java.util.List;

/**
 * Created by admin on 09-06-2017.
 */

public class Movies extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<MovieBean> beanList;
    private RecyclerView.LayoutManager manager;
    private MovieAdapter adapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies);
        overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);

        viewPager = (ViewPager)findViewById(R.id.viewPage);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));

        tabLayout = (TabLayout)findViewById(R.id.tabLay);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

    public class CustomAdapter extends FragmentPagerAdapter {
        String fragment[] = {"Tamil","Telugu","English"};
        public CustomAdapter(FragmentManager fm, Context context) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new TamilMovieFragment();
                case 1:
                    return new TeluguMovieFragment();
                case 2:
                    return new EnglishMovieFragment();
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            return fragment.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragment[position];
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_down,R.anim.slide_out_down);
    }
}