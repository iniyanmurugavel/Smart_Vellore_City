package com.smart_vellore_city.Event_Booking.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.Event_Booking.Adapter.EventListAdapter;
import com.smart_vellore_city.Event_Booking.Model.EventListModel;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.List;

public class EventFragment extends Fragment {

    RecyclerView recyclerView;
    List<EventListModel> itemsList = new ArrayList<>();
    public String[] names={"graVITas'18","HackerTech","ESAAP'18","Civi-o-Fest-17","ICMDCS 2017",
            "Indian Space \n Conclave 2017","NUS-VIT 2017"};
    public String[] location={"Vellore","Vellore","Vellore","Vellore","Vellore","Vellore","Vellore"};
    public String[] date={"16 Nov 2018","20 Nov 2018","21 Nov 2018","28 Nov 2018","2 Dec 2018","8 Dec 2018","10 Dec 2018"};
    public String[] comments={"3","5","2","10","5","4","6"};
    public String[] participants={"10","25","20","30","15","14","26"};
    public Integer[] imageId={R.drawable.gravitas,R.drawable.hackertech,R.drawable.esaap,R.drawable.civiofest,
                               R.drawable.icmdcs,R.drawable.indianspace,R.drawable.nusvit};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eventfragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new EventListAdapter(getActivity(), getItemList()));
    }

    public List<EventListModel> getItemList(){
        itemsList.clear();
        for(int i=0;i<names.length;i++){
            itemsList.add(new EventListModel(names[i],location[i],
                    date[i],comments[i],participants[i],imageId[i]));
        }
        return itemsList;
   }

}
