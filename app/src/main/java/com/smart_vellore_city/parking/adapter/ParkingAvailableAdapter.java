package com.smart_vellore_city.parking.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.R;
import com.smart_vellore_city.parking.Pojo.ParkingAvailable;
import com.smart_vellore_city.parking.ViewHolder.ParkingAvailableViewHolder;
import com.smart_vellore_city.parking.activities.ParkingDetails;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class ParkingAvailableAdapter extends RecyclerView.Adapter<ParkingAvailableViewHolder> {


    private Context context;
    List<ParkingAvailable> parkingAvailable;

    public ParkingAvailableAdapter(Context context, List<ParkingAvailable> parkingAvailable) {
        this.context = context;
        this.parkingAvailable = parkingAvailable;
    }


    @NonNull
    @Override
    public ParkingAvailableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_parking_shop_list, parent, false);

        return new ParkingAvailableViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingAvailableViewHolder holder, int position) {

        ParkingAvailable pos = parkingAvailable.get(position);

        holder.available.setText(pos.getAmount());

        if (pos.getBook().equalsIgnoreCase("yes")) {

            holder.book.setVisibility(View.VISIBLE);
        } else holder.book.setVisibility(View.GONE);

        holder.kms.setText(pos.getKms());
        holder.title.setText(pos.getName());

        holder.parkingtype.setText(pos.getParkingtype());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ParkingDetails.class);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return parkingAvailable.size();
    }
}
