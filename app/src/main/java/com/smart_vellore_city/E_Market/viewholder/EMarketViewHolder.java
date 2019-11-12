package com.smart_vellore_city.E_Market.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.smart_vellore_city.R;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class EMarketViewHolder extends RecyclerView.ViewHolder {

    public TextView name, address, mobile, locate,rating,buy;
    public RatingBar ratingBar;


    public EMarketViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        address = (TextView) itemView.findViewById(R.id.address);
        mobile = (TextView) itemView.findViewById(R.id.mobile);
        locate = (TextView) itemView.findViewById(R.id.locate);
        rating = (TextView) itemView.findViewById(R.id.rating);
        ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
        buy = (TextView) itemView.findViewById(R.id.buy);


    }
}