package com.smart_vellore_city.Directory.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart_vellore_city.Directory.Model.Hospital;
import com.smart_vellore_city.R;

import java.util.List;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.MyViewHolder> {

    private List<Hospital> hospitals;

    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvHospitalName, tvLandline,tvPincode, tvEmail;

        public MyViewHolder(View view) {
            super(view);
            tvHospitalName = view.findViewById(R.id.tv_hospital_name);
            tvLandline = view.findViewById(R.id.tv_landline);
            tvEmail = view.findViewById(R.id.tv_email);
            tvPincode = view.findViewById(R.id.tv_pincode);
        }
    }

    public HospitalAdapter(Context context, List<Hospital> hospitals) {
        this.hospitals = hospitals;
        this.mContext = context;
    }

    @Override
    public HospitalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hospital, parent, false);

        return new HospitalAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HospitalAdapter.MyViewHolder holder, int position) {
        Hospital item = hospitals.get(position);
        holder.tvHospitalName.setText(item.getHospitalName());
        holder.tvLandline.setText(Html.fromHtml("<b>Landline : </b>" +item.getPhNo()));
        holder.tvEmail.setText(Html.fromHtml("<b>Email : </b>" +item.getEmail()));
        holder.tvPincode.setText(Html.fromHtml("<b>Pincode : </b>" +item.getPinCode()));
    }

    @Override
    public int getItemCount() {
        return hospitals.size();
    }
}

