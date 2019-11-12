package com.smart_vellore_city.Directory.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart_vellore_city.Directory.Model.BloodBanks;
import com.smart_vellore_city.R;

import java.util.List;

public class BloodBanksAdapter extends RecyclerView.Adapter<BloodBanksAdapter.MyViewHolder> {

    private List<BloodBanks> bloodBanks;

    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvLandline,tvPincode, tvEmail, tvAddress;

        public MyViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            tvLandline = view.findViewById(R.id.tv_landline);
            tvEmail = view.findViewById(R.id.tv_email);
            tvAddress = view.findViewById(R.id.tv_address);
            tvPincode = view.findViewById(R.id.tv_pincode);
        }
    }

    public BloodBanksAdapter(Context context, List<BloodBanks> bloodBanks) {
        this.bloodBanks = bloodBanks;
        this.mContext = context;
    }

    @Override
    public BloodBanksAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_blood_bank, parent, false);

        return new BloodBanksAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BloodBanksAdapter.MyViewHolder holder, int position) {
        BloodBanks item = bloodBanks.get(position);
        holder.tvName.setText(item.getName());
        holder.tvLandline.setText(Html.fromHtml("<b>Phone : </b>" +item.getNumber()));
        holder.tvEmail.setText(Html.fromHtml("<b>Email : </b>" +item.getEmail()));
        holder.tvPincode.setText(Html.fromHtml("<b>Pincode : </b>" +item.getPincode()));
        holder.tvAddress.setText(item.getAddress());
    }

    @Override
    public int getItemCount() {
        return bloodBanks.size();
    }
}


