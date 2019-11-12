package com.smart_vellore_city.Emergency_Services.appoinments.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smart_vellore_city.R;

public class DoctorsListViewHolder extends RecyclerView.ViewHolder {
    public ImageView img_doc;
    public TextView tv_doc_name,tv_doc_specialist;

    public LinearLayout doc_lay;
    public DoctorsListViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_doc_name = (TextView)itemView.findViewById(R.id.tv_doc_name);
        img_doc = (ImageView) itemView.findViewById(R.id.img_doc);
        tv_doc_specialist = (TextView)itemView.findViewById(R.id.tv_doc_specialist);
        doc_lay = (LinearLayout)itemView.findViewById(R.id.doc_lay);
    }
}
