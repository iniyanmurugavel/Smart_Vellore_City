package com.smart_vellore_city.MarriageHall.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.smart_vellore_city.MarriageHall.adapters.MhallAdapter;
import com.smart_vellore_city.MarriageHall.beans.MhallBean;
import com.smart_vellore_city.MarriageHall.contracts.IMhallContract;
import com.smart_vellore_city.MarriageHall.presenters.MhallPresenter;
import com.smart_vellore_city.R;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarriageHallActivity extends AppCompatActivity implements IMhallContract.view,MhallAdapter.CallBackFromMhallAdapter,Serializable {
@BindView(R.id.rv_mhall)RecyclerView rv_mhall;
//presenter
  MhallPresenter mhallPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marriage_hall);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Marriage Hall");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mhallPresenter = new MhallPresenter(this);
        initRecyclerView();
        mhallPresenter.loadDatas();
    }

    private void initRecyclerView() {
        rv_mhall.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void getDatas(List<MhallBean> mhallBeanList) {
        MhallAdapter mhallAdapter = new MhallAdapter(this,mhallBeanList,this);
        rv_mhall.setAdapter(mhallAdapter);
    }

    @Override
    public void itemClicked(MhallBean mhallBean) {
        Intent moveToHall = new Intent(MarriageHallActivity.this,MarriageHallDetails.class);
        moveToHall.putExtra("MhallBean",mhallBean);
        startActivity(moveToHall);
    }
}
