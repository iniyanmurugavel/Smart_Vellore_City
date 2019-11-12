package com.smart_vellore_city.agri.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smart_vellore_city.R;


/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class AgriViewHolder extends RecyclerView.ViewHolder {

    public TextView name,quantity,price;
    public ImageView img;

    public AgriViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        quantity = (TextView) itemView.findViewById(R.id.quantity);
        price = (TextView) itemView.findViewById(R.id.price);
        img = (ImageView) itemView.findViewById(R.id.img);


    }
}