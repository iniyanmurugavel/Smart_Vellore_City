package com.smart_vellore_city.notification;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.R;
import com.smart_vellore_city.Tourism.plan_trip.HotelViewHolder;

import java.util.ArrayList;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class NotificationAdapter extends RecyclerView.Adapter {

    private ArrayList<NotificationPojo> arrayList = new ArrayList<>();
    private Context context;

    public NotificationAdapter(ArrayList<NotificationPojo> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        v = inflater.inflate(R.layout.adapter_notification_item, parent, false);

        return new NotificationViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {


        NotificationViewHolder holder1 = (NotificationViewHolder) holder;

        /*textview*/
        holder1.nTitle.setText(arrayList.get(position).getTitle());
        holder1.nMessage.setText(arrayList.get(position).getMessage());
        holder1.nTime.setText(arrayList.get(position).getTime());


    }


    @Override
    public int getItemCount() {
        return arrayList.size();

    }

}
