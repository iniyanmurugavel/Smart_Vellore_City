package com.smart_vellore_city.Directory.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart_vellore_city.Directory.Model.Municipalities;
import com.smart_vellore_city.R;

import java.util.List;

public class MunicipalityAdapter extends RecyclerView.Adapter<MunicipalityAdapter.MyViewHolder> {

    private List<Municipalities> municipalities;

    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvLandline,tvPincode, tvEmail, tvAddress,tvWebLink;

        public MyViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            tvLandline = view.findViewById(R.id.tv_landline);
            tvEmail = view.findViewById(R.id.tv_email);
            tvAddress = view.findViewById(R.id.tv_address);
            tvPincode = view.findViewById(R.id.tv_pincode);
            tvWebLink = view.findViewById(R.id.tv_weblink);
        }
    }

    public MunicipalityAdapter(Context context, List<Municipalities> municipalities) {
        this.municipalities = municipalities;
        this.mContext = context;
    }

    @Override
    public MunicipalityAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_municipality, parent, false);

        return new MunicipalityAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MunicipalityAdapter.MyViewHolder holder, int position) {
        Municipalities item = municipalities.get(position);
        holder.tvName.setText(item.getName());
        holder.tvLandline.setText(Html.fromHtml("<b>Landline : </b>" +item.getNumber()));
        holder.tvEmail.setText(Html.fromHtml("<b>Email : </b>" +item.getEmail()));
        holder.tvPincode.setText(Html.fromHtml("<b>Pincode : </b>" +item.getPincode()));
        holder.tvWebLink.setText(Html.fromHtml("<b>Link : </b>" +item.getWeblink()));
        holder.tvAddress.setText(item.getAddress());
    }

    @Override
    public int getItemCount() {
        return municipalities.size();
    }
}

