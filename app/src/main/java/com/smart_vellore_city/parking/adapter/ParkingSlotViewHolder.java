package com.smart_vellore_city.parking.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smart_vellore_city.R;

public class ParkingSlotViewHolder extends RecyclerView.ViewHolder {
    TextView slotNumber;
    ImageView slotImage;
    public ParkingSlotViewHolder(@NonNull View itemView) {
        super(itemView);
        slotNumber=itemView.findViewById(R.id.slotnumber);
        slotImage=itemView.findViewById(R.id.setcar);

    }
}
