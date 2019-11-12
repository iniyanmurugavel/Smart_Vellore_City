package com.smart_vellore_city.Directory.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart_vellore_city.Directory.Model.CollegeUniv;
import com.smart_vellore_city.R;

import java.util.List;

public class CollegeUnivAdapter extends RecyclerView.Adapter<CollegeUnivAdapter.MyViewHolder> {

    private List<CollegeUniv> collegeUnivs;

    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvLandline,tvPincode, tvEmail, tvAddress,tvType;

        public MyViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            tvLandline = view.findViewById(R.id.tv_landline);
            tvEmail = view.findViewById(R.id.tv_email);
            tvAddress = view.findViewById(R.id.tv_address);
            tvPincode = view.findViewById(R.id.tv_pincode);
            tvType = view.findViewById(R.id.tv_type);
        }
    }

    public CollegeUnivAdapter(Context context, List<CollegeUniv> collegeUnivs) {
        this.collegeUnivs = collegeUnivs;
        this.mContext = context;
    }

    @Override
    public CollegeUnivAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_coll_univ, parent, false);

        return new CollegeUnivAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CollegeUnivAdapter.MyViewHolder holder, int position) {
        CollegeUniv item = collegeUnivs.get(position);
        holder.tvName.setText(item.getName());
        holder.tvLandline.setText(Html.fromHtml("<b>Landline : </b>" +item.getNumber()));
        holder.tvEmail.setText(Html.fromHtml("<b>Email : </b>" +item.getEmail()));
        holder.tvPincode.setText(Html.fromHtml("<b>Pincode : </b>" +item.getPincode()));
        holder.tvAddress.setText(item.getAddress());
        holder.tvType.setText(Html.fromHtml("<b>Type : </b>" +item.getType()));
    }

    @Override
    public int getItemCount() {
        return collegeUnivs.size();
    }
}



