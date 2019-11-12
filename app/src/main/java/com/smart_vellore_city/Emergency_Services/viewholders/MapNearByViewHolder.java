package com.smart_vellore_city.Emergency_Services.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.smart_vellore_city.R;


public class MapNearByViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_itemName,tv_item_rating,tv_itemAddress;
    public RatingBar rt_b_item;
    public ImageView img_item;
    public LinearLayout li_list_item;
    public MapNearByViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_itemName = (TextView)itemView.findViewById(R.id.tv_itemName);
        tv_item_rating = (TextView) itemView.findViewById(R.id.tv_item_rating);
        tv_itemAddress = (TextView)itemView.findViewById(R.id.tv_itemAddress);
        rt_b_item = (RatingBar) itemView.findViewById(R.id.rt_b_item);
        img_item = (ImageView) itemView.findViewById(R.id.img_item);
        li_list_item = (LinearLayout) itemView.findViewById(R.id.li_list_item);
    }
}
