package com.smart_vellore_city.Emergency_Services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.smart_vellore_city.Emergency_Services.appoinments.ActivityAppoinment;
import com.smart_vellore_city.Emergency_Services.nearby.activities.NearBy;
import com.smart_vellore_city.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmergencyDashboardActivity extends AppCompatActivity {
@BindView(R.id.li_nearby)FrameLayout li_nearby;
@BindView(R.id.li_appoinments)FrameLayout li_appoinments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Health Care");

        li_nearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToNearByActivity = new Intent(EmergencyDashboardActivity.this,NearBy.class);
                moveToNearByActivity.putExtra("EntryType","EmergencyService");
                startActivity(moveToNearByActivity);
            }
        });
        li_appoinments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToNearByActivity = new Intent(EmergencyDashboardActivity.this,ActivityAppoinment.class);
                startActivity(moveToNearByActivity);
            }
        });

    }
}
