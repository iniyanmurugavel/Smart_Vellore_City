package com.smart_vellore_city.Tourism.plan_trip;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.smart_vellore_city.R;

import java.util.Objects;

public class HotelBookingDetailsActivity extends AppCompatActivity {

    ImageView iv_coverpage;

    String name, star, address, hotelDesc, image, imageRooms;

    TextView tv_star, tv_h_name, tv_h_address, tv_h_desc;

    Dialog dialog;

    Button btn_review_booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_booking_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Hotel Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        iv_coverpage = findViewById(R.id.iv_coverpage);

        tv_star = findViewById(R.id.tv_star);
        tv_h_name = findViewById(R.id.tv_h_name);
        tv_h_address = findViewById(R.id.tv_h_address);
        tv_h_desc = findViewById(R.id.tv_h_desc);

        btn_review_booking = findViewById(R.id.btn_review_booking);


        btn_review_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HotelBookingDetailsActivity.this, HotelReviewBooking.class);
                startActivity(i);
                finish();
            }
        });

        getHotelDetails();

    }


    public void getHotelDetails() {
        //collect our intent
        Intent intent = getIntent();
        HotelListPojo pojo = intent.getParcelableExtra("HotelDetails");


        //now collect all values
        star = pojo.getStar();
        name = pojo.getName();
        address = pojo.getAddress();
        hotelDesc = pojo.getHotelDesc();
        image = pojo.getImage();
        imageRooms = pojo.getRoomImage();

        Glide.with(getApplicationContext())
                .applyDefaultRequestOptions(new RequestOptions()
                        .placeholder(R.drawable.ic_default_image)
                        .error(R.drawable.ic_default_image))
                .load(imageRooms).into(iv_coverpage);


        tv_star.setText("" + star);
        tv_h_name.setText(name);
        tv_h_address.setText(address);
        tv_h_desc.setText(hotelDesc);

    }



}
