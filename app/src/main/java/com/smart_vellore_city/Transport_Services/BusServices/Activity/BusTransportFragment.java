package com.smart_vellore_city.Transport_Services.BusServices.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.R;
import com.smart_vellore_city.Transport_Services.BusServices.Adapter.BusServiceAdapter;
import com.smart_vellore_city.Transport_Services.BusServices.Model.BusServicesModel;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class BusTransportFragment extends Fragment {
    RecyclerView recyclerView;
    List<BusServicesModel> itemsList = new ArrayList<>();

    String[] destination = {"Chennai","Siripuram","Banglore","Hosur","Madurai","coimbatore","Chittor"};
    String[] source={"Vellore","Vellore","Vellore","Vellore","Vellore","Vellore","Vellore"};
    String[] fare={"Rs.150","Rs.200","Rs.100","Rs.300","Rs.400","Rs.300","Rs.250"};
    String[] time={"8.30 AM","9 AM","10 AM","9.30 AM","2 PM","5 PM","7 PM"};
    String[] duration={"8 hrs","7 hrs","6 hrs","10 hrs","5 hrs","8 hrs","6 hrs"};
    String[] images;
    String tag;
    public BusTransportFragment(String[] images,String tag) {
        this.images = images;
        this.tag = tag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.eventfragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new BusServiceAdapter(getActivity(), getItemList(),tag));

    }
    public List<BusServicesModel> getItemList(){
        itemsList.clear();
     for(int i=0;i<7;i++){
         itemsList.add(new BusServicesModel(source[i],destination[i],time[i],duration[i],fare[i],images[i]));
     }
        return itemsList;
    }
}
