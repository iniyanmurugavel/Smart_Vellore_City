package com.smart_vellore_city.Tourism.plan_trip;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Tourism.interfaces.RecyclerClickListener;

import java.util.ArrayList;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class HotelBookingAdapter extends RecyclerView.Adapter {

    private ArrayList<HotelListPojo> arrayList = new ArrayList<>();
    private Context context;
    private int type = 0;
    private HotelRecyclerItemClickListener listener;

    public HotelBookingAdapter(ArrayList<HotelListPojo> arrayList, Context context, int type,
                               HotelRecyclerItemClickListener listener) {
        this.arrayList = arrayList;
        this.type = type;
        this.context = context;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        if (type == 0) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            v = inflater.inflate(R.layout.adapter_hotel_home_items, parent, false);

            return new HotelViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (type == 0) {

            HotelViewHolder holder1 = (HotelViewHolder) holder;

            /*textview*/
            holder1.tv_hotel_star.setText(arrayList.get(position).getStar());
            holder1.hotelname.setText(arrayList.get(position).getName());
            holder1.hotel_address.setText(arrayList.get(position).getAddress());
            holder1.hoteldesc.setText(arrayList.get(position).getDesc());
            holder1.hotelrating.setText(arrayList.get(position).getRating());

            /*ratingbar*/
            holder1.hotelratingBar.setRating(Float.parseFloat(arrayList.get(position).getRating()));

            /*imageview*/

            Glide.with(context)
                    .applyDefaultRequestOptions(new RequestOptions()
                            .placeholder(R.drawable.ic_default_image)
                            .error(R.drawable.ic_default_image))
                    .load(arrayList.get(position).getImage()).into(holder1.iv);

            if (arrayList.get(position).getRoomService().equalsIgnoreCase("Y")) {
                holder1.iv_room_service.setVisibility(View.VISIBLE);
            } else {
                holder1.iv_room_service.setVisibility(View.GONE);
            }
            if (arrayList.get(position).getRestaurant().equalsIgnoreCase("Y")) {
                holder1.iv_restaurant.setVisibility(View.VISIBLE);
            } else {
                holder1.iv_restaurant.setVisibility(View.GONE);
            }
            if (arrayList.get(position).getParking().equalsIgnoreCase("Y")) {
                holder1.iv_parking.setVisibility(View.VISIBLE);
            } else {
                holder1.iv_parking.setVisibility(View.GONE);
            }
            if (arrayList.get(position).getSwimming().equalsIgnoreCase("Y")) {
                holder1.iv_swimming.setVisibility(View.VISIBLE);
            } else {
                holder1.iv_swimming.setVisibility(View.GONE);
            }
            if (arrayList.get(position).getAc().equalsIgnoreCase("Y")) {
                holder1.iv_ac.setVisibility(View.VISIBLE);
            } else {
                holder1.iv_ac.setVisibility(View.GONE);
            }


            holder1.cd_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(arrayList.get(position));

                }
            });


        }

    }

    @Override
    public int getItemViewType(int position) {
        if (type == 0) {
            return 0;
        }
        return 0;
    }

    @Override
    public int getItemCount() {

        if (type == 0) {
            return arrayList.size();
        }
        return 0;
    }

}
