package com.smart_vellore_city.Movie_Booking.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smart_vellore_city.Movie_Booking.Bean.TeluguMovieBean;
import com.smart_vellore_city.R;

import java.util.List;

/**
 * Created by admin on 09-06-2017.
 */

public class TeluguMovieAdapter extends RecyclerView.Adapter<TeluguMovieAdapter.ViewHolder> {
    List<TeluguMovieBean> beanList;
    Context context;
    public TeluguMovieAdapter(List<TeluguMovieBean> beanList, Context context){
        this.beanList = beanList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.title);
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
        TeluguMovieBean bean = beanList.get(position);
        holder.textView.setText(bean.getTitle());
        //Picasso.with(context).load(bean.getUrl()).into(holder.image);
        Glide.with(context).load(bean.getUrl()).thumbnail(0.5f)
               .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
}
