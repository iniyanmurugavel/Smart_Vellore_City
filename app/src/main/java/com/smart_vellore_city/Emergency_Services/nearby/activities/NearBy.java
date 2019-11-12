package com.smart_vellore_city.Emergency_Services.nearby.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.smart_vellore_city.Emergency_Services.nearby.fragments.MapForNearBySearchFragment;
import com.smart_vellore_city.R;

import butterknife.ButterKnife;

public class NearBy extends AppCompatActivity {
    private String mEntryType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by);
        getSupportActionBar().setTitle("Nearby");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);


        if(getIntent()!=null){
            mEntryType = getIntent().getStringExtra("EntryType");
        }
        getSupportActionBar().setTitle("Nearby");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

        Fragment fragment = new MapForNearBySearchFragment();
        Bundle arguments = new Bundle();
        arguments.putString("EntryType",mEntryType);
        fragment.setArguments(arguments);
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

}
