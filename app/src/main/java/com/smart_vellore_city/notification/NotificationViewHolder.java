package com.smart_vellore_city.notification;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.smart_vellore_city.R;


/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class NotificationViewHolder extends RecyclerView.ViewHolder {

    public TextView nTitle,nMessage,nTime;


    public NotificationViewHolder(@NonNull View itemView) {
        super(itemView);
        nTitle = (TextView) itemView.findViewById(R.id.nTitle);
        nMessage = (TextView) itemView.findViewById(R.id.nMessage);
        nTime = (TextView) itemView.findViewById(R.id.nTime);



    }
}