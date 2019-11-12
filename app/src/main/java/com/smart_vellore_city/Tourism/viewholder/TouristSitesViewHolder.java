package com.smart_vellore_city.Tourism.viewholder;

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

public class TouristSitesViewHolder extends RecyclerView.ViewHolder {

    public TextView name, subTitle, desc, rating, explore;
    public ImageView iv;
    public RatingBar ratingBar;

    public TouristSitesViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        subTitle = (TextView) itemView.findViewById(R.id.subTitle);
        desc = (TextView) itemView.findViewById(R.id.desc);
        rating = (TextView) itemView.findViewById(R.id.rating);
        explore = (TextView) itemView.findViewById(R.id.explore);

        iv = (ImageView) itemView.findViewById(R.id.iv);

        ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);

    }
}