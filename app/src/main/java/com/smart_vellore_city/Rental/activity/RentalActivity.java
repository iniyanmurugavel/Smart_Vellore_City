package com.smart_vellore_city.Rental.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.seatgeek.placesautocomplete.OnPlaceSelectedListener;
import com.seatgeek.placesautocomplete.PlacesAutocompleteTextView;
import com.seatgeek.placesautocomplete.model.Place;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Rental.adapter.RentalAdapter;
import com.smart_vellore_city.Rental.model.RentalPojo;
import com.smart_vellore_city.Tourism.interfaces.RecyclerClickListener;

import java.util.ArrayList;
import java.util.Calendar;


public class RentalActivity extends AppCompatActivity implements RecyclerClickListener {

    RecyclerView recyclerView;
    CardView cd_bicycle, cd_bike, cd_car;
    TextView tv_car, tv_bike, tv_bicycle;
    ArrayList<RentalPojo> pojo = new ArrayList<>();
    String selectedRentalService = "Bicycle";
    TextInputEditText startDate, endDate, location;
    DatePickerDialog datePickerDialog;
    int mYear, mMonth, mDay;
    Dialog dialog;
    PlacesAutocompleteTextView places_autocomplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental);

        dataList();
        initializeToolbarAndViews();
        onClick();

    }

    /**
     * Initializing Toolbar and RecyclerView
     */
    private void initializeToolbarAndViews() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.rental_rv);

        cd_bicycle = (CardView) findViewById(R.id.cd_bicycle);
        cd_bike = (CardView) findViewById(R.id.cd_bike);
        cd_car = (CardView) findViewById(R.id.cd_car);

        tv_car = (TextView) findViewById(R.id.tv_car);
        tv_bike = (TextView) findViewById(R.id.tv_bike);
        tv_bicycle = (TextView) findViewById(R.id.tv_bicycle);

        startDate = (TextInputEditText) findViewById(R.id.startDate);
        endDate = (TextInputEditText) findViewById(R.id.endDate);
        location = (TextInputEditText) findViewById(R.id.location);

        places_autocomplete = (PlacesAutocompleteTextView) findViewById(R.id.places_autocomplete);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RentalAdapter adapter = new RentalAdapter(pojo, this, 1, RentalActivity.this);
        recyclerView.setAdapter(adapter);

        cd_car.setBackgroundResource(R.drawable.background_gradient_rounded_white);
        cd_bike.setBackgroundResource(R.drawable.background_gradient_rounded_white);
        cd_bicycle.setBackgroundResource(R.drawable.background_gradient_rounded_corners_accent);
        tv_car.setTextColor(getResources().getColor(R.color.textColor_Black));
        tv_bike.setTextColor(getResources().getColor(R.color.textColor_Black));
        tv_bicycle.setTextColor(getResources().getColor(android.R.color.white));

    }

    private void onClick() {
        places_autocomplete.setOnPlaceSelectedListener(
                new OnPlaceSelectedListener() {
                    @Override
                    public void onPlaceSelected(final Place place) {
                        // do something awesome with the selected place
                    }
                }
        );
        cd_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cd_car.setBackgroundResource(R.drawable.background_gradient_rounded_corners_accent);
                cd_bike.setBackgroundResource(R.drawable.background_gradient_rounded_white);
                cd_bicycle.setBackgroundResource(R.drawable.background_gradient_rounded_white);

                tv_car.setTextColor(getResources().getColor(android.R.color.white));
                tv_bicycle.setTextColor(getResources().getColor(R.color.textColor_Black));
                tv_bike.setTextColor(getResources().getColor(R.color.textColor_Black));

                selectedRentalService = "Car";

                RentalAdapter adapter = new RentalAdapter(pojo, RentalActivity.this, 0, RentalActivity.this);
                recyclerView.setAdapter(adapter);

                dataList();

            }
        });
        cd_bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cd_car.setBackgroundResource(R.drawable.background_gradient_rounded_white);
                cd_bike.setBackgroundResource(R.drawable.background_gradient_rounded_corners_accent);
                cd_bicycle.setBackgroundResource(R.drawable.background_gradient_rounded_white);

                tv_car.setTextColor(getResources().getColor(R.color.textColor_Black));
                tv_bicycle.setTextColor(getResources().getColor(R.color.textColor_Black));
                tv_bike.setTextColor(getResources().getColor(android.R.color.white));

                selectedRentalService = "Bike";
                RentalAdapter adapter = new RentalAdapter(pojo, RentalActivity.this, 2, RentalActivity.this);
                recyclerView.setAdapter(adapter);

                dataList();
            }
        });
        cd_bicycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd_car.setBackgroundResource(R.drawable.background_gradient_rounded_white);
                cd_bike.setBackgroundResource(R.drawable.background_gradient_rounded_white);
                cd_bicycle.setBackgroundResource(R.drawable.background_gradient_rounded_corners_accent);

                tv_car.setTextColor(getResources().getColor(R.color.textColor_Black));
                tv_bike.setTextColor(getResources().getColor(R.color.textColor_Black));
                tv_bicycle.setTextColor(getResources().getColor(android.R.color.white));

                selectedRentalService = "Bicycle";

                RentalAdapter adapter = new RentalAdapter(pojo, RentalActivity.this, 1, RentalActivity.this);
                recyclerView.setAdapter(adapter);

                dataList();


            }
        });


        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectDate(startDate);

            }
        });

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate(endDate);
            }
        });
    }

    public void selectDate(final TextInputEditText editText) {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        datePickerDialog = new DatePickerDialog(RentalActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        editText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();

    }


    public void dataList() {

        pojo.clear();

        if (selectedRentalService.equalsIgnoreCase("Car")) {

            pojo.add(new RentalPojo("Ford Figo", "HatchBack", "\u20B9 2280.00",
                    "Extra : 9.00 \u20B9 / km ", "× 5", "M", "40",
                    "D", "https://media.zigcdn.com/media/model/2016/Jan/ford_figo_420x210.jpg"));
            pojo.add(new RentalPojo("Hyundai Grand I10", "HatchBack", "\u20B9 2280.00",
                    "Extra : 9.00 \u20B9 / km ", "× 5", "M", "43",
                    "D", "https://imgd.aeplcdn.com/1056x594/n/hajvnra_1420182.jpg?q=80"));
            pojo.add(new RentalPojo("Honda Jazz", "HatchBack", "\u20B9 3000.00",
                    "Extra : 10.00 \u20B9 / km ", "× 5", "M", "40",
                    "D", "https://media.zigcdn.com/media/model/2018/Aug/honda-city-right_600x300.jpg"));
            pojo.add(new RentalPojo("Honda Amaze", "Sedan", "\u20B9 3000.00",
                    "Extra : 9.00 \u20B9 / km ", "× 5", "M", "35",
                    "D", "https://carnbikeexpert.com/wp-content/uploads/2016/03/Honda-Amaze-Exterior.jpg"));
            pojo.add(new RentalPojo("Mahindra Scorpio", "SUV", "\u20B9 3360.00",
                    "Extra : 13.00 \u20B9 / km ", "× 7", "M", "60",
                    "D", "https://imgd.aeplcdn.com/1056x594/n/q2tasra_1425655.jpg?q=80"));

        }

        if (selectedRentalService.equalsIgnoreCase("Bicycle")) {

            pojo.add(new RentalPojo("Trek", "Marlin 5, With Gear", "\u20B9 40.00 / Hr",
                    "\u20B9 480 / Day ", "", "", "",
                    "", "https://static.evanscycles.com/production/bikes/mountain-bikes/product-image/484-319/trek-marlin-5-2019-mountain-bike-green-EV340595-6000-1.jpg"));
            pojo.add(new RentalPojo("BTWIN", "Reverside 120, With Gear", "\u20B9 30.00 / Hr",
                    "\u20B9 360 / Day ", "", "", "",
                    "", "https://media.decathlon.in/3773665/riverside-120-hybrid-cycle.jpg"));
            pojo.add(new RentalPojo("BTWIN", "Reverside 100, With Gear", "\u20B9 20.00 / Hr",
                    "\u20B9 240 / Day ", "", "", "",
                    "", "https://media.decathlon.in/3499004/riverside-100-hybrid-cycle.jpg"));
            pojo.add(new RentalPojo("BTWIN", "Reverside 50, No Gear", "\u20B9 10.00 / Hr",
                    "\u20B9 120 / Day ", "", "", "",
                    "", "https://media.decathlon.in/3985879/btwin-riverside-50-hybrid-bikes.jpg"));
            pojo.add(new RentalPojo("Firfox", "Karma, With Gear", "\u20B9 20.00 / Hr",
                    "\u20B9 240 / Day ", "", "", "",
                    "", "https://s3.ap-south-1.amazonaws.com/choosemybicycle/media/1443799865.43-Karma.jpg"));


        }

        if (selectedRentalService.equalsIgnoreCase("Bike")) {

            pojo.add(new RentalPojo("Honda Activa ", "5G, 83 Kmph", "\u20B9 56.00 / Hr",
                    "\u20B9 600 / Day ", "", "", "",
                    "", "https://media.zigcdn.com/media/model/2016/Feb/honda_activa125_320x160.jpg"));
            pojo.add(new RentalPojo("Hyosung ", "650 model , 18 Kmpl", "\u20B9 50.00 / Hr",
                    "\u20B9 600 / Day ", "", "", "",
                    "", "https://media.zigcdn.com/media/model/2016/Feb/hyosung_gt650r_600x300.jpg"));
            pojo.add(new RentalPojo("Bajaj ", "Pulsar  135 LS, 65 Kmpl", "\u20B9 80.00 / Hr",
                    "\u20B9 850 / Day ", "", "", "",
                    "", "https://media.zigcdn.com/media/model/2018/Apr/pulsar-135ls-2018-right-side-view_600x300.jpg"));
            pojo.add(new RentalPojo("Royal Enfield ", "Thunderbird 350, 40 Kmpl", "\u20B9 120.00 / Hr",
                    "\u20B9 1050 / Day ", "", "", "",
                    "", "https://d2pa5gi5n2e1an.cloudfront.net/global/images/product/motorcycle/Royal_Enfield_Thunderbird_350/Royal_Enfield_Thunderbird_350_L_1.jpg"));
            pojo.add(new RentalPojo("Bajaj ", "Dominar 400, 26.50 kmpl", "\u20B9 100.00 / Hr",
                    "\u20B9 1000 / Day ", "", "", "",
                    "", "https://media.zigcdn.com/media/model/2018/Jan/bajaj-dominar-400_600x300.jpg"));


        }

    }


    public void alertConfirmation() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        View v = inflater.inflate(R.layout.alert_rental_confirmation, null);

        Button alert_btn_submit = (Button) v.findViewById(R.id.alert_btn_submit);
        ImageView iv_close = (ImageView) v.findViewById(R.id.iv_close);


        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        alert_btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RentalActivity.this, "Thank you .. Our support team will contact you soon.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setView(v);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();

    }


    @Override
    public void onItemClick() {
        alertConfirmation();
    }
}
