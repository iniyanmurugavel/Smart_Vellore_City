package com.smart_vellore_city.Rental.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Rental.model.RentalPojo;
import com.smart_vellore_city.Rental.viewholder.RentalViewHolder;
import com.smart_vellore_city.Tourism.interfaces.RecyclerClickListener;

import java.util.ArrayList;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class RentalAdapter extends RecyclerView.Adapter {

    private ArrayList<RentalPojo> arrayList = new ArrayList<>();
    private Context context;
    int type = 0;
    RecyclerClickListener listener;

    public RentalAdapter(ArrayList<RentalPojo> arrayList, Context context, int type,RecyclerClickListener listener) {
        this.arrayList = arrayList;
        this.type = type;
        this.context = context;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        v = inflater.inflate(R.layout.adapter_car_rental_items, parent, false);

        return new RentalViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (type == 0) {

            RentalViewHolder holder1 = (RentalViewHolder) holder;

            holder1.ll_properties.setVisibility(View.VISIBLE);
            holder1.rental_name.setText(arrayList.get(position).getName());
            holder1.rental_type.setText(arrayList.get(position).getType());
            holder1.rental_amount.setText(arrayList.get(position).getRent());
            holder1.rental_extra_amt.setText(arrayList.get(position).getExtraCharge());
            holder1.rental_seats.setText(arrayList.get(position).getSeats());
            holder1.rental_gearType.setText(arrayList.get(position).getGearType());
            holder1.rental_diesel_petrol.setText(arrayList.get(position).getDiesalOrPetrol());
            holder1.rental_mileage.setText(arrayList.get(position).getMileage());
            Glide.with(context)
                    .applyDefaultRequestOptions(new RequestOptions()
                            .placeholder(R.drawable.ic_default_image)
                            .error(R.drawable.ic_default_image))
                    .load(arrayList.get(position).getImg()).into(holder1.img);


            holder1.rental_btn_rent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick();
                }
            });

        }
        if (type == 1) {

            RentalViewHolder holder1 = (RentalViewHolder) holder;
            holder1.ll_properties.setVisibility(View.INVISIBLE);
            holder1.rental_name.setText(arrayList.get(position).getName());
            holder1.rental_type.setText(arrayList.get(position).getType());
            holder1.rental_amount.setText(arrayList.get(position).getRent());
            holder1.rental_extra_amt.setText(arrayList.get(position).getExtraCharge());
            holder1.rental_seats.setText(arrayList.get(position).getSeats());
            holder1.rental_gearType.setText(arrayList.get(position).getGearType());
            holder1.rental_diesel_petrol.setText(arrayList.get(position).getDiesalOrPetrol());
            holder1.rental_mileage.setText(arrayList.get(position).getMileage());
            Glide.with(context)
                    .applyDefaultRequestOptions(new RequestOptions()
                            .placeholder(R.drawable.ic_default_image)
                            .error(R.drawable.ic_default_image))
                    .load(arrayList.get(position).getImg()).into(holder1.img);
            holder1.rental_btn_rent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick();
                }
            });

        }
        if (type == 2) {

            RentalViewHolder holder1 = (RentalViewHolder) holder;
            holder1.ll_properties.setVisibility(View.INVISIBLE);
            holder1.rental_name.setText(arrayList.get(position).getName());
            holder1.rental_type.setText(arrayList.get(position).getType());
            holder1.rental_amount.setText(arrayList.get(position).getRent());
            holder1.rental_extra_amt.setText(arrayList.get(position).getExtraCharge());
            holder1.rental_seats.setText(arrayList.get(position).getSeats());
            holder1.rental_gearType.setText(arrayList.get(position).getGearType());
            holder1.rental_diesel_petrol.setText(arrayList.get(position).getDiesalOrPetrol());
            holder1.rental_mileage.setText(arrayList.get(position).getMileage());
            Glide.with(context)
                    .applyDefaultRequestOptions(new RequestOptions()
                            .placeholder(R.drawable.ic_default_image)
                            .error(R.drawable.ic_default_image))
                    .load(arrayList.get(position).getImg()).into(holder1.img);
            holder1.rental_btn_rent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick();
                }
            });

        }

    }

    @Override
    public int getItemViewType(int position) {
        if (type == 0) {
            return 0;
        } else if (type == 1) {
            return 1;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();

    }

}
