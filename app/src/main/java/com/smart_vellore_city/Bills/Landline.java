package com.smart_vellore_city.Bills;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.sdsmdg.tastytoast.TastyToast;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.Objects;

public class Landline extends AppCompatActivity {

    BottomSheetBehavior addFutureUse;

    FloatingActionButton fabDone;

    ArrayList<FutureListBean> futureListBean;

    MaterialEditText etOperator,etMobileNo;

    FutureUseAdapterInternet futureUseAdapterInternet;

    private RecyclerView rv_add;

    private LinearLayout amountLayout;

    LinearLayout llActBroadband,llAirtelBroadband,llAllianceBroadband,llAsianetBroadband,llBsnlBroadband,
            llComwayBroadband,llConnectBroadband,llFoxtelBroadband,llFusionetBroadband;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landline);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Landline Bill");

        llActBroadband = findViewById(R.id.ll_act_broad);
        llAirtelBroadband = findViewById(R.id.ll_airtel_broad);
        llAllianceBroadband = findViewById(R.id.ll_alliance_broad);
        llAsianetBroadband = findViewById(R.id.ll_asianet_broad);
        llBsnlBroadband = findViewById(R.id.ll_bsnl_broad);
        llComwayBroadband = findViewById(R.id.ll_comway_broad);
        llConnectBroadband = findViewById(R.id.ll_connect_broad);
        llFoxtelBroadband = findViewById(R.id.ll_foxtel_broad);
        llFusionetBroadband = findViewById(R.id.ll_fusionet_broad);

        amountLayout = findViewById(R.id.amountLayout);

        etMobileNo = findViewById(R.id.et_mobile_no);
        etOperator = findViewById(R.id.et_operator);

        futureListBean = new ArrayList<FutureListBean>();

        View addFut = findViewById(R.id.addFutureDetail);
        addFutureUse = BottomSheetBehavior.from(addFut);
        addFutureUse.setHideable(true);
        addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);

        rv_add = findViewById(R.id.rv_future_use);
        rv_add.setHasFixedSize(true);
        rv_add.setLayoutManager(new LinearLayoutManager(Landline.this));
        rv_add.setItemAnimator(new DefaultItemAnimator());

        fabDone= findViewById(R.id.done);

        add_future_use_details();

        onClicks();

        etMobileNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length()==10){

                    amountLayout.setVisibility(View.VISIBLE);
                    hideSoftKeyboard();
                    fabDone.setVisibility(View.VISIBLE);
                }else {

                    amountLayout.setVisibility(View.GONE);
                    fabDone.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length()==10){

                    amountLayout.setVisibility(View.VISIBLE);
                    hideSoftKeyboard();
                    fabDone.setVisibility(View.VISIBLE);

                }else {
                    amountLayout.setVisibility(View.GONE);
                    fabDone.setVisibility(View.GONE);
                }

            }
        });
    }

    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            Objects.requireNonNull(inputMethodManager).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void onClicks(){

        etOperator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hideSoftKeyboard();
                addFutureUse.setState(BottomSheetBehavior.STATE_EXPANDED);
                addFutureUse.setHideable(false);
            }
        });

        fabDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TastyToast.makeText(getApplicationContext(), "Payment Successful !!", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

                finish();
            }
        });

        llActBroadband.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("ACT Broadband");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llAirtelBroadband.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Airtel Broadband");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llAllianceBroadband.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Alliance Broadband");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llAsianetBroadband.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Asianet Broadband");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llBsnlBroadband.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("BSNL Broadband");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llComwayBroadband.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Comway Broadband");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llConnectBroadband.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Connect Broadband");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llFoxtelBroadband.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Foxtel Broadband");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llFusionetBroadband.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Fusionet Broadband");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

    }

    public void add_future_use_details(){

        futureListBean.add(new FutureListBean("2","044-42744624",
                "Airtel Broadband","landline"));

        futureUseAdapterInternet = new FutureUseAdapterInternet(Landline.this,futureListBean);
        rv_add.setAdapter(futureUseAdapterInternet);
        futureUseAdapterInternet.notifyDataSetChanged();

    }

    public void cancel(View view){
        addFutureUse.setHideable(true);
        addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);

    }
}