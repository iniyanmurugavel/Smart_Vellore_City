package com.smart_vellore_city.Movie_Booking.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart_vellore_city.Movie_Booking.Bean.MovieReviewBean;
import com.smart_vellore_city.R;

import java.util.List;

/**
 * Created by admin on 12-06-2017.
 */

public class MovieReviewAdapter extends RecyclerView.Adapter<MovieReviewAdapter.ViewHolder> {
    private List<MovieReviewBean> beanList;

    public MovieReviewAdapter(List<MovieReviewBean> beanList){
        this.beanList = beanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_list,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MovieReviewBean bean = beanList.get(position);
        holder.name.setText(bean.getName());
        holder.review.setText(bean.getReview());
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,review;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            review = (TextView)itemView.findViewById(R.id.review);
        }
    }
}
