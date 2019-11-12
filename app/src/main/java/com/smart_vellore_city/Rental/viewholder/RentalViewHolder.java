package com.smart_vellore_city.Rental.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smart_vellore_city.R;


/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class RentalViewHolder extends RecyclerView.ViewHolder {

    public TextView rental_name, rental_type, rental_amount, rental_extra_amt,
            rental_seats, rental_gearType, rental_mileage, rental_diesel_petrol;
    public ImageView img;
    public LinearLayout ll_properties;
    public Button rental_btn_rent;

    public RentalViewHolder(@NonNull View itemView) {
        super(itemView);
        rental_name = (TextView) itemView.findViewById(R.id.rental_name);
        rental_type = (TextView) itemView.findViewById(R.id.rental_type);
        rental_amount = (TextView) itemView.findViewById(R.id.rental_amount);
        rental_extra_amt = (TextView) itemView.findViewById(R.id.rental_extra_amt);
        rental_seats = (TextView) itemView.findViewById(R.id.rental_seats);
        rental_gearType = (TextView) itemView.findViewById(R.id.rental_gearType);
        rental_mileage = (TextView) itemView.findViewById(R.id.rental_mileage);
        rental_diesel_petrol = (TextView) itemView.findViewById(R.id.rental_diesel_petrol);
        img = (ImageView) itemView.findViewById(R.id.img);
        ll_properties = (LinearLayout) itemView.findViewById(R.id.ll_properties);
        rental_btn_rent = (Button) itemView.findViewById(R.id.rental_btn_rent);

    }
}