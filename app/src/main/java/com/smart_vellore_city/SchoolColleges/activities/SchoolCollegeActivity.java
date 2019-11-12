package com.smart_vellore_city.SchoolColleges.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.smart_vellore_city.R;
import com.smart_vellore_city.SchoolColleges.adapter.TabPagerAdapter;
import com.smart_vellore_city.Utils.Common;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchoolCollegeActivity extends AppCompatActivity {
    @BindView(R.id.tab_school_college)TabLayout tab_school_college;
    @BindView(R.id.vp_school_college)ViewPager vp_school_college;
    TabPagerAdapter pagerAdapter;



    private static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
    private static final int CALL_PERMISSION_REQUEST_CODE = 12345;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolcolleges);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getLocationPermission();
        pagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        vp_school_college.setAdapter(pagerAdapter);
        tab_school_college.setupWithViewPager(vp_school_college);



    }

    public void getLocationPermission() {
        String[] permissions = {Manifest.permission.CALL_PHONE};
        if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Common.ISCALLPERMISSIONENABLED = true;

        } else {
            ActivityCompat.requestPermissions(this, permissions, CALL_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CALL_PERMISSION_REQUEST_CODE: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Common.ISCALLPERMISSIONENABLED = true;
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Common.ISCALLPERMISSIONENABLED = false;
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
