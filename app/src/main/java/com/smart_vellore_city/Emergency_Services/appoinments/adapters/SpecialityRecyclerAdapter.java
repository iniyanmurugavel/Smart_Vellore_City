package com.smart_vellore_city.Emergency_Services.appoinments.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.Emergency_Services.appoinments.viewholders.SpecialityViewHolder;
import com.smart_vellore_city.R;

import java.util.List;

public class SpecialityRecyclerAdapter extends RecyclerView.Adapter<SpecialityViewHolder> {
    Context context;
    List<String> specialityList;
    GetItemCallback getItemCallback;

    public SpecialityRecyclerAdapter(Context context, List<String> specialityList,GetItemCallback getItemCallback) {
        this.context = context;
        this.specialityList = specialityList;
        this.getItemCallback = getItemCallback;
    }

    @NonNull
    @Override
    public SpecialityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SpecialityViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_speciality_list,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialityViewHolder specialityViewHolder, final int i) {
        specialityViewHolder.tv_itemName.setText(specialityList.get(i));
        specialityViewHolder.tv_itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItemCallback.getItemValues(specialityList.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return specialityList.size();
    }

    public interface GetItemCallback{
        public void getItemValues(String item);
    }
}
