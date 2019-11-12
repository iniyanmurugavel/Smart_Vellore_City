package com.smart_vellore_city.Home_Services.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smart_vellore_city.Home_Services.Adapter.HomeServicesAdapter;
import com.smart_vellore_city.Home_Services.Adapter.HomeServicesItemsAdapter;
import com.smart_vellore_city.Home_Services.Model.DataModel;
import com.smart_vellore_city.Home_Services.Model.ItemModel;
import com.smart_vellore_city.R;

import java.util.ArrayList;

public class HomeServices extends AppCompatActivity implements HomeServicesAdapter.ItemListener {

    RecyclerView recyclerView,recyclerViewItems;
    ArrayList arrayList,arrayListItems;

    String type = "";

    TextView tvPopular,tvPriceList;

    LinearLayout llNonAc,llAc,llDriver,llNonDriver;

    Button btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeservices);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewItems = (RecyclerView) findViewById(R.id.recyclerView_items);

        tvPopular = (TextView) findViewById(R.id.tv_popular);
        tvPriceList = (TextView) findViewById(R.id.tv_price_list);

        llNonAc = (LinearLayout) findViewById(R.id.ll_non_ac);
        llAc = (LinearLayout) findViewById(R.id.ll_ac);
        llNonDriver = (LinearLayout) findViewById(R.id.ll_non_driver);
        llDriver = (LinearLayout) findViewById(R.id.ll_driver);

        btnBook = (Button) findViewById(R.id.btn_book);

        arrayList = new ArrayList();
        arrayListItems = new ArrayList();

        Intent i = getIntent();
        if (!i.equals(null)){

            type = i.getStringExtra("Type");
        }

        init(type);

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(HomeServices.this);

                LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                final View dview = li.inflate(R.layout.alert_booking,null);

                builder.setView(dview);
                final AlertDialog dialog = builder.create();
                dialog.show();
                dialog.setCancelable(false);

                Button btnClose = (Button)dview.findViewById(R.id.btn_close);
                Button btnGetOtp = (Button)dview.findViewById(R.id.btn_getotp);

                final EditText etName = (EditText)dview.findViewById(R.id.et_name);
                final EditText etNumber = (EditText)dview.findViewById(R.id.et_number);

                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();
                    }
                });

                btnGetOtp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (etName.getText().toString().equalsIgnoreCase("") &&
                                etNumber.getText().toString().equalsIgnoreCase("")){

                            Toast.makeText(getApplicationContext(),"Enter Name and Number",Toast.LENGTH_SHORT).show();
                        }else if (etName.getText().toString().equalsIgnoreCase("")){

                            Toast.makeText(getApplicationContext(),"Enter Name",Toast.LENGTH_SHORT).show();

                        }else if (etNumber.getText().toString().equalsIgnoreCase("")){
                            Toast.makeText(getApplicationContext(),"Enter Number",Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(getApplicationContext(),"OTP Verified Successfully",Toast.LENGTH_SHORT).show();

                            dialog.dismiss();

                        }
                    }
                });

            }
        });


    }

    public void init(String type){

        if (type.equalsIgnoreCase("Plumber")){
            tvPopular.setText(R.string.popular_plum);
            tvPriceList.setText(R.string.price_plum);

            getSupportActionBar().setTitle("Plumber");

            arrayList.add(new DataModel("Minor Work", R.drawable.ic_minor_work, "#09A9FF"));
            arrayList.add(new DataModel("Tap Fitting", R.drawable.ic_tap, "#3E51B1"));
            arrayList.add(new DataModel("Sink Clogging", R.drawable.ic_sink_clogging, "#673BB7"));
            arrayList.add(new DataModel("Tap/Pipe leakages", R.drawable.ic_pipe_leak, "#4BAA50"));
            arrayList.add(new DataModel("Flush Leakage", R.drawable.ic_flust_leak, "#F94336"));

            arrayListItems.add(new ItemModel("Tap Installation (standard)","50/-"));
            arrayListItems.add(new ItemModel("Tap Installation (premium)","100/-"));
            arrayListItems.add(new ItemModel("Tap Repair (standard)","50/-"));
            arrayListItems.add(new ItemModel("Tap Repair (premium)","100/-"));
            arrayListItems.add(new ItemModel("Washer Change","50/-"));
            arrayListItems.add(new ItemModel("Shower Repairing","50/-"));
            arrayListItems.add(new ItemModel("Shower Kit Repairing or Replacement","100/-"));
            arrayListItems.add(new ItemModel("Kitchen Sink Replacement","200/-"));
            arrayListItems.add(new ItemModel("Kitchen Platform or Sink Leakage","On Inspection"));

            llNonAc.setVisibility(View.VISIBLE);
            llAc.setVisibility(View.GONE);

            llNonDriver.setVisibility(View.VISIBLE);
            llDriver.setVisibility(View.GONE);

        }else if (type.equalsIgnoreCase("Electrician")){
            tvPopular.setText(R.string.popular_elec);
            tvPriceList.setText(R.string.price_elec);

            getSupportActionBar().setTitle("Electrician");

            arrayList.add(new DataModel("Fan Related", R.drawable.ic_fan, "#0A9B88"));
            arrayList.add(new DataModel("Minor Work", R.drawable.ic_plug, "#09A9FF"));
            arrayList.add(new DataModel("Fuse / MCB Related", R.drawable.ic_socket, "#3E51B1"));
            arrayList.add(new DataModel("Light Fitting", R.drawable.ic_switch_on, "#673BB7"));

            arrayListItems.add(new ItemModel("Tubelight Installation","50/-"));
            arrayListItems.add(new ItemModel("Tubelight Chock Replacement","50/-"));
            arrayListItems.add(new ItemModel("Switch Or Socket Change [per unit]","50/-"));
            arrayListItems.add(new ItemModel("Switch Board Change","150/-"));
            arrayListItems.add(new ItemModel("MCB Change","150-250/-"));
            arrayListItems.add(new ItemModel("New Ceiling Fan Installaion","50/-"));

            llNonAc.setVisibility(View.VISIBLE);
            llAc.setVisibility(View.GONE);

            llNonDriver.setVisibility(View.VISIBLE);
            llDriver.setVisibility(View.GONE);

        }else if (type.equalsIgnoreCase("Driver")){
            tvPopular.setText(R.string.popular_driver);
            tvPriceList.setText(R.string.price_driver);

            getSupportActionBar().setTitle("Driver");

            arrayList.add(new DataModel("For 2 Hours", R.drawable.ic_delivery_man, "#4BAA50"));
            arrayList.add(new DataModel("For 4 Hours", R.drawable.ic_delivery_man, "#F94336"));
            arrayList.add(new DataModel("For 8 Hours", R.drawable.ic_delivery_man, "#0A9B88"));
            arrayList.add(new DataModel("Driver Outstation", R.drawable.ic_car_on_the_hill, "#09A9FF"));

            arrayListItems.add(new ItemModel("2 Hours","200/-"));
            arrayListItems.add(new ItemModel("4 Hours","350/-"));
            arrayListItems.add(new ItemModel("8 Hours","600/-"));
            arrayListItems.add(new ItemModel("Outstation 24 Hours","Rs 750/-"));

            llNonAc.setVisibility(View.VISIBLE);
            llAc.setVisibility(View.GONE);

            llNonDriver.setVisibility(View.GONE);
            llDriver.setVisibility(View.VISIBLE);

        }else if (type.equalsIgnoreCase("Carpenter")){
            tvPopular.setText(R.string.popular_carpenter);
            tvPriceList.setText(R.string.price_carpenter);

            getSupportActionBar().setTitle("Carpenter");

            arrayList.add(new DataModel("Minor Work", R.drawable.ic_saw, "#3E51B1"));
            arrayList.add(new DataModel("Door Repair", R.drawable.ic_open_door_entrance, "#673BB7"));
            arrayList.add(new DataModel("Kitchen Drawer", R.drawable.ic_cabinet, "#4BAA50"));
            arrayList.add(new DataModel("Cupboard Repair", R.drawable.ic_cupboard, "#F94336"));
            arrayList.add(new DataModel("New Furniture", R.drawable.ic_armchair, "#0A9B88"));

            arrayListItems.add(new ItemModel("Night Latch","450/-"));
            arrayListItems.add(new ItemModel("Tower Bolt","50/-"));
            arrayListItems.add(new ItemModel("Door Installation (upto 6 feet height)","250/-"));
            arrayListItems.add(new ItemModel("Door Closures","250/-"));
            arrayListItems.add(new ItemModel("Door Movement Repair","100/-"));
            arrayListItems.add(new ItemModel("Door Mesh Replacement","500-1000/-"));

            llNonAc.setVisibility(View.VISIBLE);
            llAc.setVisibility(View.GONE);

            llNonDriver.setVisibility(View.VISIBLE);
            llDriver.setVisibility(View.GONE);

        }else if (type.equalsIgnoreCase("Gardener")){
            tvPopular.setText(R.string.popular_gardener);
            tvPriceList.setText(R.string.price_gardener);

            getSupportActionBar().setTitle("Gardener");

            arrayList.add(new DataModel("Garden Maintanence", R.drawable.ic_watering_plants, "#09A9FF"));

            arrayListItems.add(new ItemModel("2 Hrs","200/-"));
            arrayListItems.add(new ItemModel("Monthly Gardener Service","On Inspection"));

            llNonAc.setVisibility(View.VISIBLE);
            llAc.setVisibility(View.GONE);

            llNonDriver.setVisibility(View.VISIBLE);
            llDriver.setVisibility(View.GONE);

        }else if (type.equalsIgnoreCase("Air Conditioner")){
            tvPopular.setText(R.string.popular_ac);
            tvPriceList.setText(R.string.price_ac);

            getSupportActionBar().setTitle("Air Conditioner");

            arrayList.add(new DataModel("AC Related", R.drawable.ic_ac, "#3E51B1"));

            arrayListItems.add(new ItemModel("",""));

            recyclerViewItems.setVisibility(View.GONE);

            llNonAc.setVisibility(View.GONE);
            llAc.setVisibility(View.VISIBLE);

            llNonDriver.setVisibility(View.VISIBLE);
            llDriver.setVisibility(View.GONE);

        }

        HomeServicesAdapter adapter = new HomeServicesAdapter(this, arrayList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

        HomeServicesItemsAdapter homeServicesItemsAdapter = new HomeServicesItemsAdapter(this, arrayListItems);
        recyclerViewItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewItems.setAdapter(homeServicesItemsAdapter);
    }

    @Override
    public void onItemClick(DataModel item) {

//        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();

    }
}
