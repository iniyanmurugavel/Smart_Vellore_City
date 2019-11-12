package com.smart_vellore_city.Tourism.plan_trip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.Objects;

public class HotelBookingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<HotelListPojo> hotelDetailsArraylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_booking);
        initViews();

    }

    public void initViews() {
        recyclerView = findViewById(R.id.hotel_rv);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Hotels List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HotelBookingActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        loadData();
    }

    public void loadData() {
        hotelDetailsArraylist.add(new HotelListPojo("Regency Sameera Vellore by GRT Hotels",
                "Address: No.145, Green Circle, New By-pass Rd, Vellore, Tamil Nadu 632004",
                "Free Cancellation, Free Wifi, Free Breakfast", "The guests can approach the tour desk for the currency exchange. The property provides 24-hour front desk, luggage storage and valet parking for the convenience of the guests. The dry cleaning, ironing service and laundry facilities are available at a surcharge.\n" +
                "\n" +
                "NH 46 is a 24 hours coffee shop. À la carte and buffet can be enjoyed at Gingee Restaurant. The Blues Bar serves refreshing alcoholic and non-alcoholic beverages. Packed lunches can be requested. Room service is available. \n" +
                "\n" +
                "Couples particularly like the location — they rated it 8.1 for a two-person trip.\n" +
                "\n" +
                "This property is also rated for the best value in Vellore! Guests are getting more for their money when compared to other properties in this city.", "089395 57722", "4.1",
                "5 STAR", "Y", "Y", "Y", "Y",
                "Y", "https://media-cdn.tripadvisor.com/media/photo-s/02/83/f3/bd/front-view.jpg",
                "https://lh5.googleusercontent.com/p/AF1QipObI1O-DhC6-mR_1mF2MEEaxHXWGz6rzoU70qX6=w325-h187-k-no"));
        hotelDetailsArraylist.add(new HotelListPojo("Hotel Aavanaa Inn",
                "Address: No. 144, Arcot Road, (Opp to CMC Hospital), Vellore, Tamil Nadu 632004",
                "Free Wifi, Free Breakfast", "The guests can approach the tour desk for the currency exchange. The property provides 24-hour front desk, luggage storage and valet parking for the convenience of the guests. The dry cleaning, ironing service and laundry facilities are available at a surcharge.\n" +
                "\n" +
                "NH 46 is a 24 hours coffee shop. À la carte and buffet can be enjoyed at Gingee Restaurant. The Blues Bar serves refreshing alcoholic and non-alcoholic beverages. Packed lunches can be requested. Room service is available. \n" +
                "\n" +
                "Couples particularly like the location — they rated it 8.1 for a two-person trip.\n" +
                "\n" +
                "This property is also rated for the best value in Vellore! Guests are getting more for their money when compared to other properties in this city.", "0416 221 5073", "3.6",
                "3 STAR", "Y", "Y", "N", "N",
                "Y", "https://imgcld.yatra.com/ytimages/image/upload/t_hotel_tg_details_seo/v1478761964/Domestic%20Hotels/Hotels_vellore/Hotel%20Aavanaa%20Inn/Overview.jpg",
                "https://lh5.googleusercontent.com/proxy/a9XNWqoLIGKCMa1E7Cm9WzyQJoZbLqFaVJiHWof6TkQq1L7x4ip8zwC-5Ht-CBvvBifPcPiutyJUDMg5oB5ZFkHMOJvoj782JHGwlUoMVGApOtmncbGgyPF5SmjxAiiWDwXo-sT800vhzBgu7GiV1-qTdv2AwA=w325-h178-k-no"));
        hotelDetailsArraylist.add(new HotelListPojo("SGRT Residency",
                "Address: 313, South Avenue Road, Phase 2, Sathuvachari, Vellore, Tamil Nadu 632009",
                "Free Breakfast", "The guests can approach the tour desk for the currency exchange. The property provides 24-hour front desk, luggage storage and valet parking for the convenience of the guests. The dry cleaning, ironing service and laundry facilities are available at a surcharge.\n" +
                "\n" +
                "NH 46 is a 24 hours coffee shop. À la carte and buffet can be enjoyed at Gingee Restaurant. The Blues Bar serves refreshing alcoholic and non-alcoholic beverages. Packed lunches can be requested. Room service is available. \n" +
                "\n" +
                "Couples particularly like the location — they rated it 8.1 for a two-person trip.\n" +
                "\n" +
                "This property is also rated for the best value in Vellore! Guests are getting more for their money when compared to other properties in this city.", " 077081 28731", "3.7", "3 STAR", "Y", "Y",
                "Y", "N",
                "N", "https://media-cdn.tripadvisor.com/media/photo-s/12/0c/a2/d9/sgrt-residency-entrance.jpg",
                "https://lh5.googleusercontent.com/p/AF1QipPtYwba5RsT0WCG3y6Gc-Wu-9ta-xlw9cLxhvlZ=w325-h216-k-no"));

        HotelBookingAdapter adapter = new HotelBookingAdapter(hotelDetailsArraylist, this, 0,recyclerItemClickListener);
        recyclerView.setAdapter(adapter);
    }



    HotelRecyclerItemClickListener recyclerItemClickListener = new HotelRecyclerItemClickListener() {
        @Override
        public void onItemClick(HotelListPojo pojo) {
            Intent i = new Intent(HotelBookingActivity.this, HotelBookingDetailsActivity.class);
            i.putExtra("HotelDetails", pojo);
            startActivity(i);
            finish();
        }
    };
}
