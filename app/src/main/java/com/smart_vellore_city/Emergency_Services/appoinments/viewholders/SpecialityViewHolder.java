package com.smart_vellore_city.Emergency_Services.appoinments.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.smart_vellore_city.R;


public class SpecialityViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_itemName;

    public SpecialityViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_itemName = (TextView)itemView.findViewById(R.id.tv_itemName);
    }
}
