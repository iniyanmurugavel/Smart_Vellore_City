package com.smart_vellore_city.News_and_Announcement;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.smart_vellore_city.R;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class AnnouncementViewHolder extends RecyclerView.ViewHolder {

    public TextView title, desc, time, date;

    public AnnouncementViewHolder(@NonNull View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        desc = (TextView) itemView.findViewById(R.id.desc);
        time = (TextView) itemView.findViewById(R.id.time);
        date = (TextView) itemView.findViewById(R.id.date);


    }
}