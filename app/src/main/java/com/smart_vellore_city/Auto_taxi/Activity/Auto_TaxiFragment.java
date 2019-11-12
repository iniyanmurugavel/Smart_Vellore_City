package com.smart_vellore_city.Auto_taxi.Activity;

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

import com.smart_vellore_city.Auto_taxi.Adapter.Auto_TaxiAdapter;
import com.smart_vellore_city.Auto_taxi.Model.Auto_TaxiModel;
import com.smart_vellore_city.R;

import java.util.List;

@SuppressLint("ValidFragment")
public class Auto_TaxiFragment extends Fragment {
    List<Auto_TaxiModel> listItems;
    RecyclerView recyclerView;

    public Auto_TaxiFragment(List<Auto_TaxiModel> listItems) {
        this.listItems = listItems;
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
        recyclerView.setAdapter(new Auto_TaxiAdapter(getActivity(), listItems));
    }

}
