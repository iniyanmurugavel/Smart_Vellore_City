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
import android.widget.EditText;
import android.widget.LinearLayout;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.sdsmdg.tastytoast.TastyToast;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.Objects;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class WaterBill extends AppCompatActivity {

    BottomSheetBehavior addFutureUse;

    FloatingActionButton add_future_use,fabDone;

    ArrayList<FutureListBean> futureListBean;

    public EditText etBotWaterProvider, etBotConsumerId;

    MaterialEditText etWaterProvider,etConsumerId;

    FutureUseAdapterWater futureUseAdapterWater;

    private RecyclerView rv_add;

    private LinearLayout amountLayout;

    private SpinnerDialog spinnerDialogWaterProvider;
    private SpinnerDialog spinnerDialogBotWaterProvider;

    private ArrayList<String> waterProviderList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_bill);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Water Bill");


        etBotWaterProvider = findViewById(R.id.rv_eb_board);
        etBotConsumerId= findViewById(R.id.rv_consumer_id);

        amountLayout = findViewById(R.id.amountLayout);

        etConsumerId = findViewById(R.id.et_consumer_id);
        etWaterProvider = findViewById(R.id.et_eboard);

        futureListBean = new ArrayList<FutureListBean>();

        View addFut = findViewById(R.id.addFutureDetail);
        addFutureUse = BottomSheetBehavior.from(addFut);
        addFutureUse.setHideable(true);
        addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);

        rv_add = findViewById(R.id.rv_future_use);
        rv_add.setHasFixedSize(true);
        rv_add.setLayoutManager(new LinearLayoutManager(WaterBill.this));
        rv_add.setItemAnimator(new DefaultItemAnimator());

        add_future_use= findViewById(R.id.add_future_use);
        fabDone= findViewById(R.id.done);

        add_future_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
                addFutureUse.setState(BottomSheetBehavior.STATE_EXPANDED);
                addFutureUse.setHideable(false);
            }
        });

        add_future_use_details("Initial");

        getWaterProviders();

        FloatingActionButton add_fab= (FloatingActionButton) findViewById(R.id.add_fab);

        fabDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TastyToast.makeText(getApplicationContext(), "Payment Successful !!", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

                finish();
            }
        });

        add_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hideSoftKeyboard();
                add_future_use_details("");
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
                addFutureUse.setHideable(true);

            }
        });

        spinnerDialogWaterProvider = new SpinnerDialog(WaterBill.this, waterProviderList, "Select or Search Electricity Boards", "Close");// With No Animation
        spinnerDialogBotWaterProvider = new SpinnerDialog(WaterBill.this, waterProviderList, "Select or Search Electricity Boards", "Close");// With No Animation

        spinnerDialogWaterProvider.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int i) {

                etWaterProvider.setText(item);

            }
        });

        spinnerDialogBotWaterProvider.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int i) {

                etBotWaterProvider.setText(item);

            }
        });

        etWaterProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinnerDialogWaterProvider.showSpinerDialog();

            }
        });

        etBotWaterProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinnerDialogBotWaterProvider.showSpinerDialog();

            }
        });

        etConsumerId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length()>=10){

                    add_future_use.setVisibility(View.GONE);
                    amountLayout.setVisibility(View.VISIBLE);
                    fabDone.setVisibility(View.VISIBLE);
                }else {

                    add_future_use.setVisibility(View.VISIBLE);
                    amountLayout.setVisibility(View.GONE);
                    fabDone.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length()>=10){

                    add_future_use.setVisibility(View.GONE);
                    amountLayout.setVisibility(View.VISIBLE);
                    fabDone.setVisibility(View.VISIBLE);

                }else {
                    add_future_use.setVisibility(View.VISIBLE);
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

    public void getWaterProviders(){

        waterProviderList.add("Bangalore Water Supply and Sewerage Board (BWSSB)");
        waterProviderList.add("Bhopal Municipal Corporation - Water");
        waterProviderList.add("Delhi Jal Board (DJB)");
        waterProviderList.add("Gwalior Municipal Corporation - Water");
        waterProviderList.add("Hyderabad Metropolitan Water Supply and Sewerage Board (HMWSSB)");
        waterProviderList.add("Indore Municipal Corporation - Water");
        waterProviderList.add("Jabalpur Municipal Corporation - Water");
        waterProviderList.add("Municipal Corporation Jalandhar- Water");
        waterProviderList.add("Municipal Corporation of Faridabad -Water");
        waterProviderList.add("Surat Municipal Corporation - Water");
        waterProviderList.add("Tumkur City Corporation-Water and UGD");
        waterProviderList.add("Uttarakhand Jal Sansthan");

    }

    public void add_future_use_details(String type){

        waterProviderList.clear();
        if (type.equalsIgnoreCase("Initial")){

            futureListBean.add(new FutureListBean("2","4132245632145",
                    "Indraprastha Gas Limited","gas"));

            futureUseAdapterWater = new FutureUseAdapterWater(WaterBill.this,futureListBean);
            rv_add.setAdapter(futureUseAdapterWater);
            futureUseAdapterWater.notifyDataSetChanged();

        }else {

            futureListBean.add(new FutureListBean("2","41323151635143",
                    "Indraprastha Gas Limited","gas"));

            futureListBean.add(new FutureListBean("2",etBotConsumerId.getText().toString(),
                    etBotWaterProvider.getText().toString(),"gas"));

            futureUseAdapterWater = new FutureUseAdapterWater(WaterBill.this,futureListBean);
            rv_add.setAdapter(futureUseAdapterWater);
            futureUseAdapterWater.notifyDataSetChanged();
        }

    }

    public void cancel(View view){
        addFutureUse.setHideable(true);
        addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
        etBotWaterProvider.setText("");
        etBotConsumerId.setText("");
    }
}