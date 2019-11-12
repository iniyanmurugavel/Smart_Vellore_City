package com.smart_vellore_city.Tourism.plan_trip;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.smart_vellore_city.R;


/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class HotelViewHolder extends RecyclerView.ViewHolder {

    public TextView hotelname, hotel_address, hoteldesc,  explore, hotelrating, tv_hotel_star;
    public ImageView iv, iv_room_service, iv_restaurant, iv_parking, iv_swimming, iv_ac;
    public RatingBar  hotelratingBar;
    public CardView cd_parent;

    public HotelViewHolder(@NonNull View itemView) {
        super(itemView);
        hotelname = (TextView) itemView.findViewById(R.id.hotelname);
        hotel_address = (TextView) itemView.findViewById(R.id.hotel_address);
        hoteldesc = (TextView) itemView.findViewById(R.id.hoteldesc);
        tv_hotel_star = (TextView) itemView.findViewById(R.id.tv_hotel_star);
        hotelrating = (TextView) itemView.findViewById(R.id.hotelrating);

        iv = (ImageView) itemView.findViewById(R.id.hoteliv);
        iv_room_service = (ImageView) itemView.findViewById(R.id.iv_room_service);
        iv_restaurant = (ImageView) itemView.findViewById(R.id.iv_restaurant);
        iv_parking = (ImageView) itemView.findViewById(R.id.iv_parking);
        iv_swimming = (ImageView) itemView.findViewById(R.id.iv_swimming);
        iv_ac = (ImageView) itemView.findViewById(R.id.iv_ac);

        hotelratingBar = (RatingBar) itemView.findViewById(R.id.hotelratingBar);


        cd_parent = (CardView) itemView.findViewById(R.id.cd_parent);


    }
}