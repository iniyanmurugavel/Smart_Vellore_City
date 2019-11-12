package com.smart_vellore_city.Emergency_Services.nearby.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.Emergency_Services.nearby.beans.MapNearByBean;
import com.smart_vellore_city.Emergency_Services.viewholders.MapNearByViewHolder;
import com.smart_vellore_city.R;

import java.util.List;

public class MapNearByAdapter extends RecyclerView.Adapter<MapNearByViewHolder> {
    List<MapNearByBean> mapNearByBeanList;
    Context context;
    NearByCallBack nearByCallBack;
    public MapNearByAdapter(List<MapNearByBean> mapNearByBeanList, Context context,NearByCallBack nearByCallBack) {
        this.mapNearByBeanList = mapNearByBeanList;
        this.context = context;
        this.nearByCallBack = nearByCallBack;
    }

    @NonNull
    @Override
    public MapNearByViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.map_items_recent_nearby_list,viewGroup,false);
        return new MapNearByViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MapNearByViewHolder mapNearByViewHolder, final int i) {
        mapNearByViewHolder.tv_itemName.setText(mapNearByBeanList.get(i).getmItemName());
        mapNearByViewHolder.tv_itemAddress.setText(mapNearByBeanList.get(i).getmItemAddress());
        mapNearByViewHolder.tv_item_rating.setText(mapNearByBeanList.get(i).getmItemRating());
        mapNearByViewHolder.rt_b_item.setRating(Float.parseFloat(mapNearByBeanList.get(i).getmItemRating()));
        switch(mapNearByBeanList.get(i).getmItemType()){
            case 1:
                mapNearByViewHolder.img_item.setImageResource(R.drawable.ic_hospital_buildings_in_list);
                break;
            case 2:
                mapNearByViewHolder.img_item.setImageResource(R.drawable.ic_medical);
                break;
            case 3:
                mapNearByViewHolder.img_item.setImageResource(R.drawable.ic_ambulance_icon);
                break;
            case 4:
                mapNearByViewHolder.img_item.setImageResource(R.drawable.ic_blood_bank_icon);
                break;
            case 5:
                mapNearByViewHolder.img_item.setImageResource(R.drawable.ic_police_station_grey);
                break;
            case 6:
                mapNearByViewHolder.img_item.setImageResource(R.drawable.ic_atm_machine);
                break;
            case 7:
                mapNearByViewHolder.img_item.setImageResource(R.drawable.ic_bank_in_list);
                break;
            case 8:
                mapNearByViewHolder.img_item.setImageResource(R.drawable.ic_public_toilet_list);
                break;
        }
        mapNearByViewHolder.li_list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nearByCallBack.clickItem(mapNearByBeanList.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mapNearByBeanList.size();
    }

    public interface NearByCallBack{
        void clickItem(MapNearByBean mapNearByBean);
    }
}
