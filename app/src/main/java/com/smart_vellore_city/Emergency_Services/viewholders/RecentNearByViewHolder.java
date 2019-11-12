package com.smart_vellore_city.Emergency_Services.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.smart_vellore_city.R;


public class RecentNearByViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_item_name,tv_item_distance,tv_item_description;
    public RecentNearByViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_item_name = (TextView)itemView.findViewById(R.id.tv_item_name);
        tv_item_distance = (TextView)itemView.findViewById(R.id.tv_item_distance);
        tv_item_description = (TextView)itemView.findViewById(R.id.tv_item_description);
    }
}
