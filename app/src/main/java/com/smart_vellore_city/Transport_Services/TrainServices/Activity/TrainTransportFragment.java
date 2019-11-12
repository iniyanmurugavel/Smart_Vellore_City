package com.smart_vellore_city.Transport_Services.TrainServices.Activity;

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
import com.smart_vellore_city.Transport_Services.TrainServices.Adapter.TrainServiceAdapter;
import com.smart_vellore_city.Transport_Services.TrainServices.Model.TrainServicesModel;

import java.util.ArrayList;
import java.util.List;

public class TrainTransportFragment extends Fragment {
    RecyclerView recyclerView;
    List<TrainServicesModel> itemsList = new ArrayList<>();

    String[] name = {"Chalukya Exp","Tirupati Rameswaram Ex","Pdy Howrah Exp","Puducherry Exp","Rameswaram Tirupati Exp","Chalukya Exp","Chalukya Exp"};
    String[] destination = {"Kadur","Rameswaram","Vijayawada","Puduchery","Tirukoilur","Pakala","Chittor"};
    String[] source={"Vellore","Vellore","Vellore","Vellore","Vellore","Vellore","Vellore"};
    String[] fare={"Rs.150","Rs.200","Rs.100","Rs.300","Rs.400","Rs.300","Rs.250"};
    String[] time={"8:30","9:00","10:00","9:30","14:00","17:00","19:00"};
    String[] duration={"8 hrs","7 hrs","6 hrs","10 hrs","5 hrs","8 hrs","6 hrs"};
    String[] images={"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyDTdBoSocZ4YOqn0vkpiFRF3hEheeLV-mJj_mfIhUFehoYWwpWw",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyDTdBoSocZ4YOqn0vkpiFRF3hEheeLV-mJj_mfIhUFehoYWwpWw",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyDTdBoSocZ4YOqn0vkpiFRF3hEheeLV-mJj_mfIhUFehoYWwpWw",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyDTdBoSocZ4YOqn0vkpiFRF3hEheeLV-mJj_mfIhUFehoYWwpWw",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyDTdBoSocZ4YOqn0vkpiFRF3hEheeLV-mJj_mfIhUFehoYWwpWw",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyDTdBoSocZ4YOqn0vkpiFRF3hEheeLV-mJj_mfIhUFehoYWwpWw",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyDTdBoSocZ4YOqn0vkpiFRF3hEheeLV-mJj_mfIhUFehoYWwpWw"};

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
        recyclerView.setAdapter(new TrainServiceAdapter(getActivity(), getItemList()));

    }
    public List<TrainServicesModel> getItemList(){
        itemsList.clear();
     for(int i=0;i<7;i++){
         itemsList.add(new TrainServicesModel(name[i],source[i],destination[i],time[i],duration[i],fare[i],images[i]));
     }
        return itemsList;
    }
}