package com.smart_vellore_city.parking.ViewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.smart_vellore_city.R;


public class ParkingAvailableViewHolder extends RecyclerView.ViewHolder {
   public  TextView title, kms, parkingtype, available, book;
    public  CardView card;

    public ParkingAvailableViewHolder(View itemView) {
        super(itemView);

        card = (CardView) itemView.findViewById(R.id.card);
        title = (TextView) itemView.findViewById(R.id.name);
        kms = (TextView) itemView.findViewById(R.id.kms);
        parkingtype = (TextView) itemView.findViewById(R.id.parkingtype);
        available = (TextView) itemView.findViewById(R.id.available);
        book = (TextView) itemView.findViewById(R.id.book);


    }
}
