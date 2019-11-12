package com.smart_vellore_city.Movie_Booking.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.smart_vellore_city.Movie_Booking.Activity.Home;
import com.smart_vellore_city.Movie_Booking.Activity.TourismMapsActivity;
import com.smart_vellore_city.Movie_Booking.Bean.Model_ThreatreList;
import com.smart_vellore_city.R;

import java.util.List;

public class Adapter_TheatreList extends RecyclerView.Adapter<Adapter_TheatreList.TheatreList_ViewHolder> {
    Context context;
    List<Model_ThreatreList> listItems;
    public Adapter_TheatreList(Context context, List<Model_ThreatreList> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public TheatreList_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movielist_temview,viewGroup,false);
        return new TheatreList_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheatreList_ViewHolder viewHolder, int i) {
        final Model_ThreatreList item = listItems.get(i);
        viewHolder.theatreImage.setImageResource(item.getImageId());
        viewHolder.theatreName.setText(item.getTheatreName());
        viewHolder.address.setText(item.getThreatreAddress());
        viewHolder.rating.setText(item.getRating());
        viewHolder.ratingBar.setRating(Float.valueOf(item.getRating()));
        viewHolder.location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,TourismMapsActivity.class);
                intent.putExtra("title",item.getTheatreName());
                intent.putExtra("lat",item.getLat());
                intent.putExtra("lng",item.getLng());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class TheatreList_ViewHolder extends RecyclerView.ViewHolder{
        TextView theatreName,address,rating,location;
        RatingBar ratingBar;
        ImageView theatreImage;
        public TheatreList_ViewHolder(@NonNull View itemView) {
            super(itemView);
            theatreName = (TextView)itemView.findViewById(R.id.theatre_name);
            theatreImage = (ImageView)itemView.findViewById(R.id.theatre_img);
            address = (TextView)itemView.findViewById(R.id.theater_address);
            rating = (TextView)itemView.findViewById(R.id.rating);
            location= (TextView)itemView.findViewById(R.id.location_tv);
            ratingBar = (RatingBar)itemView.findViewById(R.id.ratingBar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,Home.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
