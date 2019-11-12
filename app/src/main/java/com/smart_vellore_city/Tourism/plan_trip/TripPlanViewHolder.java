package com.smart_vellore_city.Tourism.plan_trip;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.smart_vellore_city.R;


/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class TripPlanViewHolder extends RecyclerView.ViewHolder {

    public TextView name, booking_num, desc, languages_known, rating, license, call_now;
    public ImageView img;
    public RatingBar ratingBar;

    public TripPlanViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        booking_num = (TextView) itemView.findViewById(R.id.booking_num);
        desc = (TextView) itemView.findViewById(R.id.desc);
        languages_known = (TextView) itemView.findViewById(R.id.languages_known);
        rating = (TextView) itemView.findViewById(R.id.rating);
        license = (TextView) itemView.findViewById(R.id.license);
        call_now = (TextView) itemView.findViewById(R.id.call_now);
        ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
        img = (ImageView) itemView.findViewById(R.id.img);


    }
}