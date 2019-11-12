package com.smart_vellore_city.Tourism.plan_trip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.smart_vellore_city.R;

import java.util.Objects;

public class HotelReviewBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_review_booking);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Review Booking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btn_book = findViewById(R.id.btn_book);

        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HotelReviewBooking.this, "Payment Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
