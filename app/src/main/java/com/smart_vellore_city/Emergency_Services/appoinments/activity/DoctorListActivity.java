package com.smart_vellore_city.Emergency_Services.appoinments.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.smart_vellore_city.Emergency_Services.appoinments.adapters.TabAppoinmentPagerAdapter;
import com.smart_vellore_city.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorListActivity extends AppCompatActivity {

    @BindView(R.id.tab_doctor_list)TabLayout tab_doctor_list;
    @BindView(R.id.vp_doctor_list)ViewPager vp_doctor_list;
    TabAppoinmentPagerAdapter pagerAdapter;
    @BindView(R.id.dl_toolbar) Toolbar dl_toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        ButterKnife.bind(this);

        setSupportActionBar(dl_toolbar);
        getSupportActionBar().setTitle("Find a doctor");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pagerAdapter = new TabAppoinmentPagerAdapter(getSupportFragmentManager());
        tab_doctor_list.setupWithViewPager(vp_doctor_list);

        vp_doctor_list.setAdapter(pagerAdapter);

    }
}
