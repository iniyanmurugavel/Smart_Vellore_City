package com.smart_vellore_city.About.ElectedRepresentatives.Activity;

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
import com.smart_vellore_city.About.ElectedRepresentatives.Model.ElectedRep_Model;
import com.smart_vellore_city.About.WhoIsWho.Adapter.WhoisWhoAdapter;
import com.smart_vellore_city.R;

import java.util.List;

@SuppressLint("ValidFragment")
public class MLA_Fragment extends Fragment {
    RecyclerView recyclerView;
    List<ElectedRep_Model> listItems;
    public MLA_Fragment(List<ElectedRep_Model> listItems) {
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
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new WhoisWhoAdapter(getActivity(), listItems,2,"ER"));
    }
}
