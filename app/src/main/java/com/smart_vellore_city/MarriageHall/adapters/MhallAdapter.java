package com.smart_vellore_city.MarriageHall.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.request.RequestOptions;
import com.smart_vellore_city.MarriageHall.beans.MhallBean;
import com.smart_vellore_city.MarriageHall.viewholder.MhallViewHolder;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Utils.GlideApp;

import java.util.List;

public class MhallAdapter extends RecyclerView.Adapter<MhallViewHolder> {
    Context context;
    List<MhallBean> mhallBeanList;
    CallBackFromMhallAdapter callBackFromMhallAdapter;

    public MhallAdapter(Context context, List<MhallBean> mhallBeanList, CallBackFromMhallAdapter callBackFromMhallAdapter) {
        this.context = context;
        this.mhallBeanList = mhallBeanList;
        this.callBackFromMhallAdapter = callBackFromMhallAdapter;
    }

    @NonNull
    @Override
    public MhallViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MhallViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_marriagehall,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MhallViewHolder mhallViewHolder, final int i) {
        GlideApp
                .with(context)
                .load(mhallBeanList.get(i).getmImgUrl())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.ic_school)
                        .fitCenter())
                .into(mhallViewHolder.img_item);
        mhallViewHolder.tv_item_name.setText(mhallBeanList.get(i).getmItemName());
        mhallViewHolder.tv_distance.setText(mhallBeanList.get(i).getmItemDistance());
        mhallViewHolder.tv_rate.setText("₹ "+mhallBeanList.get(i).getmItemBaseRate());
        mhallViewHolder.tv_attendees.setText(mhallBeanList.get(i).getmItemAttendees());
        mhallViewHolder.tv_space.setText(mhallBeanList.get(i).getmItemSpaces());
        mhallViewHolder.tv_rooms.setText(mhallBeanList.get(i).getmItemRooms());
        mhallViewHolder.rt_b_item.setRating(Float.parseFloat(mhallBeanList.get(i).getmItemRating()));
        mhallViewHolder.tv_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBackFromMhallAdapter.itemClicked(mhallBeanList.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mhallBeanList.size();
    }

    public interface CallBackFromMhallAdapter{
        public void itemClicked(MhallBean mhallBean);
    }
}
