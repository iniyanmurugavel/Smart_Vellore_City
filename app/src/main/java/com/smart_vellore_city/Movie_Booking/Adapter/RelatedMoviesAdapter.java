package com.smart_vellore_city.Movie_Booking.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smart_vellore_city.Movie_Booking.Bean.RelatedMoviesBean;
import com.smart_vellore_city.R;

import java.util.List;

/**
 * Created by admin on 12-06-2017.
 */

public class RelatedMoviesAdapter extends RecyclerView.Adapter<RelatedMoviesAdapter.ViewHolder> {
    List<RelatedMoviesBean> beanList;
    Context context;
    public RelatedMoviesAdapter(List<RelatedMoviesBean> beanList, Context context){
        this.beanList = beanList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,category;
        ImageView icon;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            category = (TextView)itemView.findViewById(R.id.language);
            icon = (ImageView)itemView.findViewById(R.id.image);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.related_movies_list,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RelatedMoviesBean bean = beanList.get(position);
        holder.title.setText(bean.getTitle());
        holder.category.setText(bean.getCategory());
        Glide.with(context).load(bean.getUrl()).thumbnail(0.5f).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
}
