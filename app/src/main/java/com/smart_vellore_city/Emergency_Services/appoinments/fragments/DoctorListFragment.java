package com.smart_vellore_city.Emergency_Services.appoinments.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.Emergency_Services.appoinments.adapters.DoctorsAdapter;
import com.smart_vellore_city.Emergency_Services.appoinments.contracts.IDoctorListContract;
import com.smart_vellore_city.Emergency_Services.appoinments.models.DocBean;
import com.smart_vellore_city.Emergency_Services.appoinments.presenters.DoctorListPresenter;
import com.smart_vellore_city.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class DoctorListFragment extends Fragment implements IDoctorListContract.view {
@BindView(R.id.rv_doctors_list)RecyclerView rv_doctors_list;
DoctorListPresenter doctorListPresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_doctor_list,container,false);
        ButterKnife.bind(this,view);
        initRecyclerView();
        doctorListPresenter = new DoctorListPresenter(this);
        doctorListPresenter.loadDatas();
        int page = getArguments().getInt("currentPage");

       return view;
    }

    private void initRecyclerView() {
        rv_doctors_list.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void getDatas(List<DocBean> docBeanList) {
        Log.d(TAG, "getDatas: "+docBeanList.size());
        DoctorsAdapter doctorsAdapter = new DoctorsAdapter(getActivity(),docBeanList);
        rv_doctors_list.setAdapter(doctorsAdapter);
    }
}
