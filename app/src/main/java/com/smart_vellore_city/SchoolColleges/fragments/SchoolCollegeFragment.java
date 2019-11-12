package com.smart_vellore_city.SchoolColleges.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.smart_vellore_city.R;
import com.smart_vellore_city.SchoolColleges.adapter.SchoolCollegeAdapter;
import com.smart_vellore_city.SchoolColleges.beans.SchoolCollegeBean;
import com.smart_vellore_city.SchoolColleges.contracts.SchoolCollegeContract;
import com.smart_vellore_city.SchoolColleges.presenters.SchoolCollegePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchoolCollegeFragment extends Fragment implements SchoolCollegeContract.view {
    @BindView(R.id.li_school_college_list)LinearLayout li_school_college_list;
    @BindView(R.id.rv_school_college_list)RecyclerView rv_school_college_list;
    int page;
    SchoolCollegePresenter schoolCollegePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schoolcolleges,container,false);
        ButterKnife.bind(this,view);
        page = getArguments().getInt("currentPage");
        schoolCollegePresenter = new SchoolCollegePresenter(this);
        initRecyclerView();
        if(page == 1){
            schoolCollegePresenter.loadSchools();
        }else{
            schoolCollegePresenter.loadColleges();
        }


        return view;
    }

    private void initRecyclerView() {
        rv_school_college_list.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void getDatas(List<SchoolCollegeBean> schoolCollegeBeans) {
        SchoolCollegeAdapter schoolCollegeAdapter = new SchoolCollegeAdapter(getActivity(),schoolCollegeBeans);
        rv_school_college_list.setAdapter(schoolCollegeAdapter);
    }
}
