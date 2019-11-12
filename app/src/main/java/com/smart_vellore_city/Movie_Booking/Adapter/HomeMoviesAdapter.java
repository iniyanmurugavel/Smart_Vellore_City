package com.smart_vellore_city.Movie_Booking.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smart_vellore_city.Movie_Booking.Bean.HomeBean;
import com.smart_vellore_city.R;

import java.util.List;

/**
 * Created by admin on 10-06-2017.
 */

public class HomeMoviesAdapter extends RecyclerView.Adapter<HomeMoviesAdapter.ViewHolder> {
    private List<HomeBean> beanList;
    Context context;
    public HomeMoviesAdapter(List<HomeBean> beanList, Context context){
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_movie_list,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HomeBean bean = beanList.get(position);
        holder.title.setText(bean.getTitle());
        holder.language.setText(bean.getLanguage());
//        Glide.with(context).load(bean.getImage()).thumbnail(0.5f)
//                .diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.image);

        Glide.with(context).load(bean.getImage()).thumbnail(0.5f).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,language;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            title = (TextView)itemView.findViewById(R.id.title);
            language = (TextView)itemView.findViewById(R.id.language);
        }
    }
}
