package com.smart_vellore_city.Tourism.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Tourism.interfaces.RecyclerItemClickListener;
import com.smart_vellore_city.Tourism.model.TourismSitesPojo;
import com.smart_vellore_city.Tourism.viewholder.TouristSitesViewHolder;

import java.util.ArrayList;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class TourismSitesAdapter extends RecyclerView.Adapter<TouristSitesViewHolder> {

    private ArrayList<TourismSitesPojo> arrayList;
    private RecyclerItemClickListener recyclerItemClickListener;
    private Context context;

    public TourismSitesAdapter(ArrayList<TourismSitesPojo> arrayList,
                               RecyclerItemClickListener recyclerItemClickListener,Context context) {
        this.arrayList = arrayList;
        this.recyclerItemClickListener = recyclerItemClickListener;
        this.context  = context;
    }

    @NonNull
    @Override
    public TouristSitesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.adapter_tourism_home_items, viewGroup, false);
        return new TouristSitesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TouristSitesViewHolder touristSitesViewHolder, final int i) {
        touristSitesViewHolder.name.setText(arrayList.get(i).getName());
        touristSitesViewHolder.subTitle.setText(arrayList.get(i).getSubTitle());
        touristSitesViewHolder.desc.setText(arrayList.get(i).getDescription());
        touristSitesViewHolder.rating.setText(arrayList.get(i).getRatings());
        touristSitesViewHolder.ratingBar.setRating(Float.parseFloat(arrayList.get(i).getRatings()));
        Glide.with(context)
                .applyDefaultRequestOptions(new RequestOptions()
                        .placeholder(R.drawable.ic_default_image)
                        .error(R.drawable.ic_default_image))
                .load(arrayList.get(i).getImage1()).into(touristSitesViewHolder.iv);

        touristSitesViewHolder.explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(arrayList.get(i));
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
