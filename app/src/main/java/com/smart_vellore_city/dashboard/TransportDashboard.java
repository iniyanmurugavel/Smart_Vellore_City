package com.smart_vellore_city.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.smart_vellore_city.R;
import com.smart_vellore_city.Transport_Services.BusServices.Activity.Home;

public class TransportDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transport_dashboard);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Transport Services");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void onCardClick(View view){
        switch(view.getId()){
            case R.id.card_bus:
                Intent busService = new Intent(TransportDashboard.this,Home.class);
                startActivity(busService);
                break;
            case R.id.card_car:
                Intent carService = new Intent(TransportDashboard.this, com.smart_vellore_city.Auto_taxi.Activity.Home.class);
                startActivity(carService);
                break;
            case R.id.crad_train:
                Intent trainService = new Intent(TransportDashboard.this, com.smart_vellore_city.Transport_Services.TrainServices.Activity.Home.class);
                startActivity(trainService);
                break;
        }
    }
}
