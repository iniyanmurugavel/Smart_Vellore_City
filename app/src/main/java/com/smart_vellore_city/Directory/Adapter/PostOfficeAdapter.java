package com.smart_vellore_city.Directory.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart_vellore_city.Directory.Model.PostOffice;
import com.smart_vellore_city.R;

import java.util.List;

public class PostOfficeAdapter extends RecyclerView.Adapter<PostOfficeAdapter.MyViewHolder> {

    private List<PostOffice> postOffices;

    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvLandline,tvPincode, tvEmail, tvAddress,tvType;

        public MyViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            tvLandline = view.findViewById(R.id.tv_landline);
            tvAddress = view.findViewById(R.id.tv_address);
            tvPincode = view.findViewById(R.id.tv_pincode);
        }
    }

    public PostOfficeAdapter(Context context, List<PostOffice> postOffices) {
        this.postOffices = postOffices;
        this.mContext = context;
    }

    @Override
    public PostOfficeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post_office, parent, false);

        return new PostOfficeAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostOfficeAdapter.MyViewHolder holder, int position) {
        PostOffice item = postOffices.get(position);
        holder.tvName.setText(item.getName());
        holder.tvLandline.setText(Html.fromHtml("<b>Phone : </b>" +item.getNumber()));
        holder.tvPincode.setText(Html.fromHtml("<b>Pincode : </b>" +item.getPincode()));
        holder.tvAddress.setText(item.getAddress());
    }

    @Override
    public int getItemCount() {
        return postOffices.size();
    }
}



