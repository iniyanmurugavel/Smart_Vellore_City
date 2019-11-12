package com.smart_vellore_city.Directory.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart_vellore_city.Directory.Model.ContactsModel;
import com.smart_vellore_city.R;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    private List<ContactsModel> contactsModels;

    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDesignation, tvMobile, tvLandline, tvEmail;

        public MyViewHolder(View view) {
            super(view);
            tvDesignation = view.findViewById(R.id.tv_designation);
            tvMobile = view.findViewById(R.id.tv_mobile);
            tvLandline = view.findViewById(R.id.tv_landline);
            tvEmail = view.findViewById(R.id.tv_email);
        }
    }

    public ContactsAdapter(Context context,List<ContactsModel> contactsModels) {
        this.contactsModels = contactsModels;
        this.mContext = context;
    }

    @Override
    public ContactsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.MyViewHolder holder, int position) {
        ContactsModel item = contactsModels.get(position);
        holder.tvDesignation.setText(item.getDesignation());
        holder.tvMobile.setText(item.getMobile());
        holder.tvLandline.setText(item.getLandline());
        holder.tvEmail.setText(item.getEmail());
    }

    @Override
    public int getItemCount() {
        return contactsModels.size();
    }
}

