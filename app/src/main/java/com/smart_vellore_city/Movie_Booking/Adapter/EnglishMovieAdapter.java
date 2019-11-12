package com.smart_vellore_city.Movie_Booking.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smart_vellore_city.Movie_Booking.Bean.EnglishMovieBean;
import com.smart_vellore_city.R;

import java.util.List;

/**
 * Created by admin on 21-06-2017.
 */

public class EnglishMovieAdapter extends RecyclerView.Adapter<EnglishMovieAdapter.ViewHolder> {
    List<EnglishMovieBean> beanList;
    Context context;
    public EnglishMovieAdapter(List<EnglishMovieBean> bean, Context context) {
        this.context = context;
        beanList = bean;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            image = (ImageView)itemView.findViewById(R.id.image);
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
        EnglishMovieBean bean = beanList.get(position);
        holder.title.setText(bean.getTitle());
        Glide.with(context).load(bean.getUrl()).thumbnail(0.5f).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
}
