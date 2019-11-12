package com.smart_vellore_city.News_and_Announcement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.smart_vellore_city.R;

import java.util.ArrayList;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class NewsAnnouncementAdapter extends RecyclerView.Adapter {

    private ArrayList<NewsPojo> arrayList;
    private Context context;
    int type = 0;


    public NewsAnnouncementAdapter(ArrayList<NewsPojo> arrayList, int type,Context context) {
        this.arrayList = arrayList;
        this.type = type;
        this.context =context;
    }

    public NewsAnnouncementAdapter(ArrayList<NewsPojo> arrayList, Context context, int type) {
        this.arrayList = arrayList;
        this.context = context;
        this.type = type;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;

        if (viewType == 0) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            v = inflater.inflate(R.layout.adapter_news_items, parent, false);

            return new NewsViewHolder(v);

        } else if (viewType == 1) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            v = inflater.inflate(R.layout.adapter_announcement_items, parent, false);

            return new AnnouncementViewHolder(v);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (type) {

            case 0:
                NewsViewHolder holder0 = (NewsViewHolder) holder;

                holder0.title.setText(arrayList.get(position).getTitle());
                holder0.desc.setText(arrayList.get(position).getDescription());
                holder0.time.setText(arrayList.get(position).getTime());

//                holder0.iv.setImageResource(arrayList.get(position).getImage());
                Glide.with(context)
                        .applyDefaultRequestOptions(new RequestOptions()
                                .placeholder(R.drawable.ic_default_image)
                                .error(R.drawable.ic_default_image))
                        .load(arrayList.get(position).getImage()).into(holder0.iv);
                break;

            case 1:
                AnnouncementViewHolder holder1 = (AnnouncementViewHolder) holder;

                holder1.title.setText(arrayList.get(position).getTitle());
                holder1.desc.setText(arrayList.get(position).getDescription());
                holder1.time.setText(arrayList.get(position).getTime());
                holder1.date.setText(arrayList.get(position).getDate());
                break;
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (type == 0) {
            return 0;
        } else if (type == 1) {
            return 1;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
