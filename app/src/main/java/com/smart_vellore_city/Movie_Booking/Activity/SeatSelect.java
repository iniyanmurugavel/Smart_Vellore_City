package com.smart_vellore_city.Movie_Booking.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.smart_vellore_city.Movie_Booking.Adapter.SelectSeatAdapter;
import com.smart_vellore_city.R;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class SeatSelect extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    SelectSeatAdapter adapter;
    Button pay_bn;
    TextView seatNum_tv,amount_tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theatre_seats);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Select Seats");

        pay_bn = (Button)findViewById(R.id.pay_bn);
        pay_bn.setOnClickListener(this);
        seatNum_tv = (TextView)findViewById(R.id.seatNum_tv);
        amount_tv = (TextView)findViewById(R.id.amount_tv);
        recyclerView = (RecyclerView)findViewById(R.id.seat_recycler);
        adapter = new SelectSeatAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.pay_bn){

            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("You want to pay now!")
                    .setConfirmText("Proceed")
                    .show();
        }
    }
}
