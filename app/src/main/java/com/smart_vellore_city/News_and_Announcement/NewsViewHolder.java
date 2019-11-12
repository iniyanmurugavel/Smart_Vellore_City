package com.smart_vellore_city.News_and_Announcement;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smart_vellore_city.R;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class NewsViewHolder extends RecyclerView.ViewHolder {

    public TextView title, desc, time;
    public ImageView iv;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        desc = (TextView) itemView.findViewById(R.id.desc);
        time = (TextView) itemView.findViewById(R.id.time);

        iv = (ImageView) itemView.findViewById(R.id.iv);

    }
}