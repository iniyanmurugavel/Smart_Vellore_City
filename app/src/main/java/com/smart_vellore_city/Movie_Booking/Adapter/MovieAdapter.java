package com.smart_vellore_city.Movie_Booking.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smart_vellore_city.Movie_Booking.Bean.MovieBean;
import com.smart_vellore_city.R;

import java.util.List;

/**
 * Created by admin on 06-06-2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    List<MovieBean> list;
    Context context;
    public MovieAdapter(List<MovieBean> list, Context context){
        this.list = list;
        this.context = context;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MovieBean movieBean = list.get(position);
        holder.title.setText(movieBean.getTitle());
        Glide.with(context).load(movieBean.getUrl()).thumbnail(0.5f).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
