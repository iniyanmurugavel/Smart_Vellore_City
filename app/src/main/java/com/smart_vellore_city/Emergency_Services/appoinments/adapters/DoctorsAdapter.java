package com.smart_vellore_city.Emergency_Services.appoinments.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.request.RequestOptions;
import com.smart_vellore_city.Emergency_Services.appoinments.activity.DoctorProfileActivity;
import com.smart_vellore_city.Emergency_Services.appoinments.models.DocBean;
import com.smart_vellore_city.Emergency_Services.appoinments.viewholders.DoctorsListViewHolder;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Utils.GlideApp;

import java.util.List;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsListViewHolder> {
    Context context;
    List<DocBean> docBeanList;

    public DoctorsAdapter(Context context, List<DocBean> docBeanList) {
        this.context = context;
        this.docBeanList = docBeanList;
    }

    @NonNull
    @Override
    public DoctorsListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DoctorsListViewHolder(LayoutInflater.from(context).inflate(R.layout.row_doctors,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsListViewHolder doctorsListViewHolder, final int i) {
        doctorsListViewHolder.tv_doc_name.setText(docBeanList.get(i).getDocName());
        doctorsListViewHolder.doc_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ik = new Intent(context,DoctorProfileActivity.class);
                ik.putExtra("doctor",docBeanList.get(i));
                context.startActivity(ik);
            }
        });
        doctorsListViewHolder.tv_doc_specialist.setText(docBeanList.get(i).getDocSpeciality());
        GlideApp
                .with(context)
                .load(docBeanList.get(i).getDocImgUrl())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.ic_doctor)
                        .fitCenter())
                .into(doctorsListViewHolder.img_doc);


    }

    @Override
    public int getItemCount() {
        return docBeanList.size();
    }
}
