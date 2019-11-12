package com.smart_vellore_city.Emergency_Services.nearby.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.smart_vellore_city.Emergency_Services.nearby.beans.RecentNearByBean;
import com.smart_vellore_city.Emergency_Services.viewholders.RecentNearByViewHolder;
import com.smart_vellore_city.R;

import java.util.List;

public class RecentNearByAdapter extends RecyclerView.Adapter<RecentNearByViewHolder> {
    List<RecentNearByBean> recentNearByBeanList;
    Context context;

    public RecentNearByAdapter(List<RecentNearByBean> recentNearByBeanList, Context context) {
        this.recentNearByBeanList = recentNearByBeanList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecentNearByViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recent_nearby_list,viewGroup,false);
        return new RecentNearByViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentNearByViewHolder recentNearByViewHolder, int i) {
        recentNearByViewHolder.tv_item_name.setText(recentNearByBeanList.get(i).getSearchItemName());
        recentNearByViewHolder.tv_item_description.setText(recentNearByBeanList.get(i).getSearchItemDescription());
        recentNearByViewHolder.tv_item_distance.setText(recentNearByBeanList.get(i).getSearchItemDistance());
    }

    @Override
    public int getItemCount() {
        return recentNearByBeanList.size();
    }
}
