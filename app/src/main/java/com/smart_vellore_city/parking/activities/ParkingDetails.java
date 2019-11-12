package com.smart_vellore_city.parking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.smart_vellore_city.R;

import java.util.Objects;


public class ParkingDetails extends AppCompatActivity {

    LinearLayout showSlots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Parking Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showSlots=findViewById(R.id.showavailability);

        showSlots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ParkingDetails.this,ParkingSlots.class);
                startActivity(i);
            }
        });
    }
}
