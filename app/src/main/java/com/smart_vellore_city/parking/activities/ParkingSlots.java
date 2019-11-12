package com.smart_vellore_city.parking.activities;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;
import com.smart_vellore_city.R;
import com.smart_vellore_city.parking.Pojo.ParkingSlotsData;
import com.smart_vellore_city.parking.adapter.ParkingSlotAdapter;
import com.smart_vellore_city.parking.callback.GetSlots;

import java.util.ArrayList;

public class ParkingSlots extends AppCompatActivity implements GetSlots {

    private static final String TAG = "ParkingSlots";
    RecyclerView parkingSlotsRecycler;
    ArrayList<ParkingSlotsData> parkingSlotsDataArrayList;
    int[] carImages = {R.drawable.carone, R.drawable.cartwo, R.drawable.carthree, R.drawable.cartwo};
    ParkingSlotAdapter parkingSlotAdapter;
    RecyclerView.LayoutManager layoutManager;
     TextView confirm_slot, listofslots, totalAmount;
     ImageView myCar;
    LinearLayout bookingLayout;
    int slotAmount=0;
    ArrayList<String> slotList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_slots);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Parking Slot");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        parkingSlotsRecycler = findViewById(R.id.slotsrecycler);
        totalAmount = findViewById(R.id.totalAmount);
        confirm_slot = findViewById(R.id.confirmslot);
        listofslots = findViewById(R.id.listofslots);
        myCar = findViewById(R.id.mycar);
        bookingLayout = findViewById(R.id.bookinglayout);
        bookingLayout.setVisibility(View.GONE);
        confirm_slot.setVisibility(View.GONE);
        parkingSlotsDataArrayList = new ArrayList<>();
        parkingSlotsRecycler.setHasFixedSize(true);

        parkingSlotsDataArrayList.add(new ParkingSlotsData("A0", carImages[0], true));
        parkingSlotsDataArrayList.add(new ParkingSlotsData("A1", carImages[0], true));
        parkingSlotsDataArrayList.add(new ParkingSlotsData("A3", carImages[0], false));
        parkingSlotsDataArrayList.add(new ParkingSlotsData("A4", carImages[0], true));
        parkingSlotsDataArrayList.add(new ParkingSlotsData("A5", carImages[0], false));
        parkingSlotsDataArrayList.add(new ParkingSlotsData("A6", carImages[0], true));
        parkingSlotsDataArrayList.add(new ParkingSlotsData("A7", carImages[0], true));
        parkingSlotsDataArrayList.add(new ParkingSlotsData("A8", carImages[0], false));
        parkingSlotsDataArrayList.add(new ParkingSlotsData("A9", carImages[0], false));
        parkingSlotsDataArrayList.add(new ParkingSlotsData("A10", carImages[0], true));
        parkingSlotsDataArrayList.add(new ParkingSlotsData("A11", carImages[0], true));

        parkingSlotAdapter = new ParkingSlotAdapter(parkingSlotsDataArrayList, this, this);
        int spanCount = parkingSlotsDataArrayList.size() / 3;
        layoutManager = new GridLayoutManager(this, spanCount);
        layoutManager.canScrollHorizontally();
        parkingSlotsRecycler.setLayoutManager(layoutManager);
        parkingSlotsRecycler.setAdapter(parkingSlotAdapter);

        confirm_slot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(slotAmount==0){
                    Toast.makeText(ParkingSlots.this, "No Slots found", Toast.LENGTH_SHORT).show();
                }else{
                    displayConfirmationAlert();
                }

            }
        });

    }

    private void displayConfirmationAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.slot_payment_confirmation, null);
        Button ok = view.findViewById(R.id.ok);
        Button cancel = view.findViewById(R.id.cancel);
        TextView totalAmount = view.findViewById(R.id.totalslotamount);
        LinearLayout slotConfirmationAlert = view.findViewById(R.id.dynamictv);
        builder.setView(view);

        final int N = slotList.size();
        slotConfirmationAlert.setGravity(Gravity.CENTER);
        final TextView[] myTextViews = new TextView[N];

        for (int i = 0; i < N; i++) {
            final TextView rowTextView = new TextView(this);
            rowTextView.setTextSize(16);
            rowTextView.setText(i + 1 + "." + slotList.get(i));
            slotConfirmationAlert.addView(rowTextView);
            myTextViews[i] = rowTextView;
        }
        totalAmount.setText("Total Amount :"+slotAmount);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TastyToast.makeText(getApplicationContext(), "Payment Successful !!", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

                finish();
//                Toast.makeText(ParkingSlots.this, "Payment SuccessFull", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }

    @Override
    public void moveSlotNumber(ArrayList<String> sNumber) {

        confirm_slot.setVisibility(View.VISIBLE);
        bookingLayout.setVisibility(View.VISIBLE);
        if(sNumber.isEmpty())
        {
            slotAmount=0;
            totalAmount.setText("Rs.0/-");
        }
        StringBuilder builder = new StringBuilder();
        for (String slot : sNumber) {
            int totalSlotAllocated=sNumber.size();
            slotAmount=totalSlotAllocated*50;

                totalAmount.setText("Rs."+slotAmount);

            builder.append(slot).append(",");
        }
        slotList=sNumber;
        listofslots.setText(builder);
    }

    @Override
    public void showOutOfSlotBookingMessage() {
        Toast.makeText(this, "More than 3 Slots are not allowed", Toast.LENGTH_LONG).show();
    }
}
