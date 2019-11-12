package com.smart_vellore_city.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smart_vellore_city.Home_Services.Model.DataModel;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<DataModel> dataModels;

    private ItemListener mListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public TextView textView;

            public ImageView imageView;

            public RelativeLayout relativeLayout;

            DataModel model;

            public MyViewHolder(View view) {
                super(view);

                view.setOnClickListener(this);
                imageView = view.findViewById(R.id.imageView);
                textView = view.findViewById(R.id.textView);
                relativeLayout = view.findViewById(R.id.relativeLayout);

            }


        @Override
        public void onClick(View view) {
            if (mListener != null){
                mListener.onItemClick(model);
            }
        }

        public void setData(DataModel dataModel) {

                this.model = dataModel;
        }
    }

        public RecyclerViewAdapter(Context context, ArrayList dataModels, ItemListener itemListener) {
            this.dataModels = dataModels;
            mListener=itemListener;

        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_view_item, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            DataModel balance = dataModels.get(position);
            holder.imageView.setImageResource(balance.getDrawable());
            holder.textView.setText(balance.getText());
            holder.relativeLayout.setBackgroundColor(Color.parseColor(balance.getColor()));

            holder.setData(dataModels.get(position));
        }

        @Override
        public int getItemCount() {
            return dataModels.size();
        }

    public interface ItemListener {
        void onItemClick(DataModel item);
    }
}
