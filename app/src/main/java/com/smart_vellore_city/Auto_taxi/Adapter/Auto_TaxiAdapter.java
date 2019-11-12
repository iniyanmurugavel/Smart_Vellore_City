package com.smart_vellore_city.Auto_taxi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smart_vellore_city.Auto_taxi.Model.Auto_TaxiModel;
import com.smart_vellore_city.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Auto_TaxiAdapter extends RecyclerView.Adapter<Auto_TaxiAdapter.AutoTaxi_ViewHolder> {
    Context context;
    List<Auto_TaxiModel> listItems;

    public Auto_TaxiAdapter(Context context, List<Auto_TaxiModel> listItems) {
        this.context = context;
        this.listItems = listItems;

    }

    @NonNull
    @Override
    public AutoTaxi_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transport_itemview,viewGroup,false);
        return new AutoTaxi_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AutoTaxi_ViewHolder viewHolder, int i) {

        final Auto_TaxiModel item =  listItems.get(i);
        viewHolder.name.setText(item.getName());
        viewHolder.name.setVisibility(View.VISIBLE);
        viewHolder.source.setText(item.getSource());
        viewHolder.destination.setText(item.getDestination());
        viewHolder.mobile_tv.setText("Mobile:");
        viewHolder.mobile.setText(item.getMobile());
        viewHolder.fare.setText(item.getFare());
        viewHolder.call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+item.getMobile()));
                context.startActivity(callIntent);
            }
        });
        Glide.with(context).load(item.getImageId()).thumbnail(0.5f).into(viewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class AutoTaxi_ViewHolder extends RecyclerView.ViewHolder{
        TextView name,source,destination,mobile,fare,startTime;
        TextView source_tv,destination_tv,mobile_tv,fare_tv,startTime_tv;
        CircleImageView imageView;
        Button call_btn;
        public AutoTaxi_ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.eventName_tv);
            source = (TextView)itemView.findViewById(R.id.eventSource);
            destination = (TextView)itemView.findViewById(R.id.eventDestination);
            mobile = (TextView)itemView.findViewById(R.id.eventDuration);
            fare = (TextView)itemView.findViewById(R.id.eventFare);
            startTime = (TextView)itemView.findViewById(R.id.eventDate);
            imageView = (CircleImageView)itemView.findViewById(R.id.event_img);
            call_btn  = (Button)itemView.findViewById(R.id.call_btn);
            call_btn.setVisibility(View.VISIBLE);

            source_tv = (TextView)itemView.findViewById(R.id.eventSource_tv);
            destination_tv = (TextView)itemView.findViewById(R.id.eventDestination_tv);
            mobile_tv = (TextView)itemView.findViewById(R.id.eventDuration_tv);
            fare_tv = (TextView)itemView.findViewById(R.id.eventFare_tv);
            startTime_tv = (TextView)itemView.findViewById(R.id.eventDate_tv);

            startTime.setVisibility(View.GONE);
            startTime_tv.setVisibility(View.GONE);
        }
    }
}
