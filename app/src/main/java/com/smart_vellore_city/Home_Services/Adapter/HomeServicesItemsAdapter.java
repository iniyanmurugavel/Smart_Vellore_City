package com.smart_vellore_city.Home_Services.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart_vellore_city.Home_Services.Model.ItemModel;
import com.smart_vellore_city.R;

import java.util.List;

public class HomeServicesItemsAdapter extends RecyclerView.Adapter<HomeServicesItemsAdapter.MyViewHolder> {

    private List<ItemModel> itemModels;

    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvItemName, tvPrice, balance;

        public MyViewHolder(View view) {
            super(view);
            tvItemName = view.findViewById(R.id.tvitem_name);
            tvPrice = view.findViewById(R.id.tv_price);
        }
    }


    public HomeServicesItemsAdapter(Context context,List<ItemModel> itemModels) {
        this.itemModels = itemModels;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemModel item = itemModels.get(position);
        holder.tvItemName.setText(item.getItem());
        holder.tvPrice.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }
}
