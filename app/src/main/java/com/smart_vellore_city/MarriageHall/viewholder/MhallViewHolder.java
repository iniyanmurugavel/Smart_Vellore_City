package com.smart_vellore_city.MarriageHall.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.smart_vellore_city.R;


public class MhallViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_item_name,tv_distance,tv_rate,tv_attendees,tv_space,tv_rooms,tv_view;
    public RatingBar rt_b_item;
    public ImageView img_item;
    public MhallViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_item_name = (TextView)itemView.findViewById(R.id.tv_item_name);
        tv_distance = (TextView)itemView.findViewById(R.id.tv_distance);
        tv_rate = (TextView)itemView.findViewById(R.id.tv_rate);
        tv_attendees = (TextView)itemView.findViewById(R.id.tv_attendees);
        tv_space = (TextView)itemView.findViewById(R.id.tv_space);
        tv_rooms = (TextView)itemView.findViewById(R.id.tv_rooms);
        tv_view = (TextView)itemView.findViewById(R.id.tv_view);
        rt_b_item = (RatingBar) itemView.findViewById(R.id.rt_b_item);
        img_item = (ImageView) itemView.findViewById(R.id.img_item);
    }
}
