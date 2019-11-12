package com.smart_vellore_city.parking.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.R;
import com.smart_vellore_city.parking.Pojo.ParkingSlotsData;
import com.smart_vellore_city.parking.activities.ParkingSlots;
import com.smart_vellore_city.parking.callback.AnimInterface;
import com.smart_vellore_city.parking.callback.GetSlots;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParkingSlotAdapter extends RecyclerView.Adapter<ParkingSlotViewHolder> implements AnimInterface {

    private ArrayList<ParkingSlotsData> parkingSlotsDataArrayList;
    private Context context;
    private GetSlots getSlots;


    private ArrayList<String> listOfSlotsUsersSelected = new ArrayList<>();

    public ParkingSlotAdapter(ArrayList<ParkingSlotsData> parkingSlotsDataArrayList, Context context, GetSlots getSlots) {
        this.parkingSlotsDataArrayList = parkingSlotsDataArrayList;
        this.context = context;
        this.getSlots = getSlots;
    }

    @NonNull
    @Override
    public ParkingSlotViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.parking_slot_adapter, null, false);
        return new ParkingSlotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ParkingSlotViewHolder viewHolder, final int position) {

        viewHolder.slotNumber.setVisibility(View.GONE);
        final ParkingSlotsData parkingSlotsData = parkingSlotsDataArrayList.get(position);

        if (parkingSlotsData.getShowcars()) {
            viewHolder.slotImage.setVisibility(View.VISIBLE);
            viewHolder.slotImage.setImageResource(parkingSlotsDataArrayList.get(position).getCarImage());
            viewHolder.slotNumber.setVisibility(View.GONE);
        } else {
            viewHolder.slotImage.setVisibility(View.GONE);
            viewHolder.slotNumber.setVisibility(View.VISIBLE);
            viewHolder.slotNumber.setText(parkingSlotsDataArrayList.get(position).getSlotNumber());

            viewHolder.slotNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!listOfSlotsUsersSelected.isEmpty()) {
                        if (listOfSlotsUsersSelected.contains(parkingSlotsDataArrayList.get(position).getSlotNumber())) {
                            viewHolder.slotNumber.setTextColor(Color.GRAY);
                            listOfSlotsUsersSelected.remove(parkingSlotsDataArrayList.get(position).getSlotNumber());
                        } else {
//                            hashSet.addAll(listOfSlotsUsersSelected);
//                            listOfSlotsUsersSelected.clear();
//                            listOfSlotsUsersSelected.addAll(hashSet);
                            listOfSlotsUsersSelected.add(parkingSlotsDataArrayList.get(position).getSlotNumber());
                            viewHolder.slotNumber.setTextColor(Color.BLUE);
                            for (int i = 0; i < listOfSlotsUsersSelected.size(); i++) {
                                Log.e("DUPPP", "onClick: " + listOfSlotsUsersSelected.get(i));

                            }
                        }
                        Log.d("tag", listOfSlotsUsersSelected.toString());
                        getSlots.moveSlotNumber(listOfSlotsUsersSelected);
                    } else {
                        listOfSlotsUsersSelected.add(parkingSlotsDataArrayList.get(position).getSlotNumber());
                        viewHolder.slotNumber.setTextColor(Color.BLUE);
                        getSlots.moveSlotNumber(listOfSlotsUsersSelected);
                    }
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return parkingSlotsDataArrayList.size();
    }

    @Override
    public void startDown() {
    }
}
