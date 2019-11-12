package com.smart_vellore_city.SchoolColleges.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smart_vellore_city.R;


public class SchoolCollegeViewHolder extends RecyclerView.ViewHolder {
    public ImageView img_school;
    public TextView tv_name,tv_address,tv_phno;
    public TextView tv_locate;
    public SchoolCollegeViewHolder(@NonNull View itemView) {
        super(itemView);
        img_school = (ImageView)itemView.findViewById(R.id.img_school);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_address = (TextView) itemView.findViewById(R.id.tv_address);
        tv_phno = (TextView) itemView.findViewById(R.id.tv_phno);

        tv_locate = (TextView) itemView.findViewById(R.id.tv_locate);
    }
}
