package com.smart_vellore_city.Transport_Services.BusServices.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Transport_Services.BusServices.Activity.BookBus;
import com.smart_vellore_city.Transport_Services.BusServices.Model.BusServicesModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BusServiceAdapter extends RecyclerView.Adapter<BusServiceAdapter.Transport_ViewHolder> {
    Context context;
    List<BusServicesModel> itemList;
    String tag;

    public BusServiceAdapter(Context context, List<BusServicesModel> itemList,String tag) {
        this.context = context;
        this.itemList = itemList;
        this.tag = tag;
    }

    @NonNull
    @Override
    public Transport_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transport_itemview,viewGroup,false);
        return new Transport_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Transport_ViewHolder viewHolder, int i) {
        BusServicesModel item =  itemList.get(i);
            viewHolder.source.setText(item.getSource());
            viewHolder.destination.setText(item.getDestination());
            viewHolder.duration.setText(item.getDuration());
            viewHolder.fare.setText(item.getFare());
            viewHolder.startTime.setText(item.getTime());
            Glide.with(context).load(item.getImageId()).thumbnail(0.5f)
                    .into(viewHolder.imageView);
            if(tag.equalsIgnoreCase("TNSTC")) {
                viewHolder.btnBook.setVisibility(View.VISIBLE);
            }
            viewHolder.btnBook.setText("Book");
            viewHolder.btnBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context,BookBus.class));
                }
            });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class Transport_ViewHolder extends RecyclerView.ViewHolder{
        TextView source,destination,duration,fare,startTime;
        Button btnBook;
        CircleImageView imageView;
        public Transport_ViewHolder(@NonNull View itemView) {
            super(itemView);
            source = itemView.findViewById(R.id.eventSource);
            destination = itemView.findViewById(R.id.eventDestination);
            duration = itemView.findViewById(R.id.eventDuration);
            fare = itemView.findViewById(R.id.eventFare);
            startTime = itemView.findViewById(R.id.eventDate);
            imageView =itemView.findViewById(R.id.event_img);
            btnBook = itemView.findViewById(R.id.call_btn);
            btnBook.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
        }
    }
}
