package com.smart_vellore_city.agri.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.smart_vellore_city.E_Market.model.EMarketPojo;
import com.smart_vellore_city.E_Market.viewholder.EMarketViewHolder;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Tourism.activity.TourismMapsActivity;
import com.smart_vellore_city.Tourism.interfaces.RecyclerClickListener;
import com.smart_vellore_city.Tourism.plan_trip.TourAgentPojo;
import com.smart_vellore_city.Tourism.plan_trip.TripPlanViewHolder;
import com.smart_vellore_city.agri.ViewHolder.AgriViewHolder;
import com.smart_vellore_city.agri.model.AgriPojo;

import java.util.ArrayList;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class AgriAdapter extends RecyclerView.Adapter {

    private ArrayList<AgriPojo> arrayList = new ArrayList<>();
    private ArrayList<EMarketPojo> eMarketArrayList = new ArrayList<>();
    private ArrayList<TourAgentPojo> tourAgentArrayList = new ArrayList<>();
    private Context context;
    private int type = 0;
    private RecyclerClickListener listener;

    public AgriAdapter(ArrayList<AgriPojo> arrayList, int type, Context context) {
        this.arrayList = arrayList;
        this.type = type;
        this.context = context;
    }

    public AgriAdapter(ArrayList<EMarketPojo> arrayList, Context context, int type,RecyclerClickListener listener) {
        this.eMarketArrayList = arrayList;
        this.context = context;
        this.type = type;
        this.listener = listener;
    }

    public AgriAdapter(ArrayList<TourAgentPojo> arrayList, Context context, int type, String empty) {
        this.tourAgentArrayList = arrayList;
        this.context = context;
        this.type = type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;

        if (type == 0) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            v = inflater.inflate(R.layout.adapter_agri, parent, false);

            return new AgriViewHolder(v);
        } else if (type == 1) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            v = inflater.inflate(R.layout.adapter_emarket_items, parent, false);

            return new EMarketViewHolder(v);
        } else if (type == 2) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            v = inflater.inflate(R.layout.adapter_tourist_guide_items, parent, false);

            return new TripPlanViewHolder(v);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (type == 0) {

            AgriViewHolder holder1 = (AgriViewHolder) holder;

            holder1.name.setText(arrayList.get(position).getName());
            holder1.quantity.setText(arrayList.get(position).getQuantity());
            holder1.price.setText(arrayList.get(position).getPrice());

            Glide.with(context)
                    .applyDefaultRequestOptions(new RequestOptions()
                            .placeholder(R.drawable.ic_default_image)
                            .error(R.drawable.ic_default_image))
                    .load(arrayList.get(position).getImg()).into(holder1.img);

        } else if (type == 1) {
            final EMarketViewHolder holder1 = (EMarketViewHolder) holder;

            holder1.name.setText(eMarketArrayList.get(position).getName());
            holder1.address.setText(eMarketArrayList.get(position).getAddress());
            holder1.mobile.setText(eMarketArrayList.get(position).getMobile());
            holder1.rating.setText(eMarketArrayList.get(position).getRating());
            holder1.ratingBar.setRating(Float.parseFloat(eMarketArrayList.get(position).getRating()));
            holder1.buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick();
                }
            });


            holder1.locate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, TourismMapsActivity.class);
                    i.putExtra("title", eMarketArrayList.get(position).getName());
                    context.startActivity(i);
                }
            });
        } else if (type == 2) {
            final TripPlanViewHolder holder1 = (TripPlanViewHolder) holder;

            holder1.name.setText(tourAgentArrayList.get(position).getName());
            holder1.booking_num.setText(tourAgentArrayList.get(position).getBooking_num());
            holder1.desc.setText(tourAgentArrayList.get(position).getDesc());
            holder1.languages_known.setText(tourAgentArrayList.get(position).getLanguage_known());

            holder1.call_now.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_CALL);
                    String mobileNo = "tel:" + tourAgentArrayList.get(position).getMobileNo();
                    i.setData(Uri.parse(mobileNo));
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    context.startActivity(i);
                }
            });

            if (tourAgentArrayList.get(position).getLicensedOrNot().equalsIgnoreCase("Licensed")) {
                holder1.license.setText(tourAgentArrayList.get(position).getLicensedOrNot());
                holder1.license.setVisibility(View.VISIBLE);
            } else {
                holder1.license.setVisibility(View.GONE);
            }

            holder1.rating.setText(tourAgentArrayList.get(position).getRating());
            holder1.ratingBar.setRating(Float.parseFloat(tourAgentArrayList.get(position).getRating()));

            Glide.with(context)
                    .applyDefaultRequestOptions(new RequestOptions()
                            .placeholder(R.drawable.ic_default_image)
                            .error(R.drawable.ic_default_image))
                    .load(tourAgentArrayList.get(position).getImg()).into(holder1.img);



           /* holder1.locate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, TourismMapsActivity.class);
                    i.putExtra("title", tourAgentArrayList.get(position).getName());
                    context.startActivity(i);
                }
            });*/
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (type == 0) {
            return 0;
        } else if (type == 1) {
            return 1;
        } else if (type == 2) {
            return 2;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        if (type == 0) {
            return arrayList.size();
        } else if (type == 1) {
            return eMarketArrayList.size();
        } else if (type == 2) {
            return tourAgentArrayList.size();
        }
        return 0;
    }
}
