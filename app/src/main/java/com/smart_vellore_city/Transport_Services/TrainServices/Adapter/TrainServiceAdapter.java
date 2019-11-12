package com.smart_vellore_city.Transport_Services.TrainServices.Adapter;

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
import com.smart_vellore_city.Transport_Services.TrainServices.Activity.BookTrain;
import com.smart_vellore_city.Transport_Services.TrainServices.Model.TrainServicesModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TrainServiceAdapter extends RecyclerView.Adapter<TrainServiceAdapter.Transport_ViewHolder> {
    private Context context;
    private List<TrainServicesModel> itemList;

    public TrainServiceAdapter(Context context, List<TrainServicesModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public Transport_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transport_itemview,viewGroup,false);
        return new Transport_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Transport_ViewHolder viewHolder, int i) {
        TrainServicesModel item =  itemList.get(i);
            viewHolder.name.setText(item.getName());
            viewHolder.source.setText(item.getSource());
            viewHolder.destination.setText(item.getDestination());
            viewHolder.duration.setText(item.getDuration());
            viewHolder.fare.setText(item.getFare());
            viewHolder.startTime.setText(item.getTime());
            Glide.with(context).load(item.getImageId()).thumbnail(0.5f).into(viewHolder.imageView);
            viewHolder.book.setText("Book");
            viewHolder.book.setVisibility(View.VISIBLE);
            viewHolder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,BookTrain.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class Transport_ViewHolder extends RecyclerView.ViewHolder{
        TextView name,source,destination,duration,fare,startTime;
        Button book;
        CircleImageView imageView;
        Transport_ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.eventName_tv);
            name.setVisibility(View.VISIBLE);
            source = itemView.findViewById(R.id.eventSource);
            destination = itemView.findViewById(R.id.eventDestination);
            duration = itemView.findViewById(R.id.eventDuration);
            fare = itemView.findViewById(R.id.eventFare);
            startTime = itemView.findViewById(R.id.eventDate);
            book = itemView.findViewById(R.id.call_btn);
            book.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
            imageView = itemView.findViewById(R.id.event_img);
        }
    }
}
