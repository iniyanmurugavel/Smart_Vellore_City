package com.smart_vellore_city.parking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.smart_vellore_city.R;
import com.smart_vellore_city.parking.Pojo.ParkingAvailable;
import com.smart_vellore_city.parking.adapter.ParkingAvailableAdapter;

import java.util.ArrayList;
import java.util.List;

public class ParkingAvailableActivity extends AppCompatActivity {

    RecyclerView recycler_parking;
    List<ParkingAvailable> parkingAvailableList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_location);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Parking Available");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        parkingAvailableList = new ArrayList<>();
        recycler_parking = (RecyclerView) findViewById(R.id.recycler_parking);

        recycler_parking.setHasFixedSize(true);
        recycler_parking.setLayoutManager(new LinearLayoutManager(this));

        parkingAvailableList.add(new ParkingAvailable("Bean Hospital", "0.8 km", "Free Parking", "0", "yes"));
        parkingAvailableList.add(new ParkingAvailable("Vellore Bus Stand", "0.8 km", "Pay Parking", "10", "no"));
        parkingAvailableList.add(new ParkingAvailable("Vellore Fort Stand", "0.8 km", "Free Parking", "10", "no"));
        parkingAvailableList.add(new ParkingAvailable("Bean Hospital", "0.8 km", "Free Parking", "0", "yes"));
        parkingAvailableList.add(new ParkingAvailable("Bean Hospital", "0.8 km", "Free Parking", "0", "yes"));

        ParkingAvailableAdapter adapter = new ParkingAvailableAdapter(getApplicationContext(), parkingAvailableList);

        recycler_parking.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ic_map:
                // TODO put your code here to respond to the button tap
                startActivity(new Intent(this, ParkingMap.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.parking_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


}
