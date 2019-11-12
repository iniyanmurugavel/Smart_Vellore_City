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

public class GasBill extends AppCompatActivity {

    BottomSheetBehavior addFutureUse;

    FloatingActionButton add_future_use,fabDone;

    ArrayList<FutureListBean> futureListBean;

    public EditText etBotGasProvider, etBotConsumerId;

    MaterialEditText etGasProvider,etConsumerId;

    FutureUseAdapterGas futureUseAdapterGas;

    private RecyclerView rv_add;

    private LinearLayout amountLayout;

    private SpinnerDialog spinnerDialogGasProvider;
    private SpinnerDialog spinnerDialogBotGasProvider;

    private ArrayList<String> gasProviderList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_bill);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Gas Bill");


        etBotGasProvider = findViewById(R.id.rv_eb_board);
        etBotConsumerId= findViewById(R.id.rv_consumer_id);

        amountLayout = findViewById(R.id.amountLayout);

        etConsumerId = findViewById(R.id.et_consumer_id);
        etGasProvider = findViewById(R.id.et_eboard);

        futureListBean = new ArrayList<FutureListBean>();

        View addFut = findViewById(R.id.addFutureDetail);
        addFutureUse = BottomSheetBehavior.from(addFut);
        addFutureUse.setHideable(true);
        addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);

        rv_add = findViewById(R.id.rv_future_use);
        rv_add.setHasFixedSize(true);
        rv_add.setLayoutManager(new LinearLayoutManager(GasBill.this));
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

        getGasProviders();

        FloatingActionButton add_fab= findViewById(R.id.add_fab);

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

        spinnerDialogGasProvider = new SpinnerDialog(GasBill.this, gasProviderList, "Select or Search Electricity Boards", "Close");// With No Animation
        spinnerDialogBotGasProvider = new SpinnerDialog(GasBill.this, gasProviderList, "Select or Search Electricity Boards", "Close");// With No Animation

        spinnerDialogGasProvider.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int i) {

                etGasProvider.setText(item);

            }
        });

        spinnerDialogBotGasProvider.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int i) {

                etBotGasProvider.setText(item);

            }
        });

        etGasProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinnerDialogGasProvider.showSpinerDialog();

            }
        });

        etBotGasProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinnerDialogBotGasProvider.showSpinerDialog();

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

    public void getGasProviders(){

        gasProviderList.add("Aavantika Gas Ltd");
        gasProviderList.add("Adani Gas Limited");
        gasProviderList.add("Charotar Gas Sahakari Mandali Ltd");
        gasProviderList.add("Gujarat Gas Limited");
        gasProviderList.add("Indraprastha Gas Limited");
        gasProviderList.add("Mahanagar Gas- Mumbai");
        gasProviderList.add("Sabarmati Gas Limited (SGL)");
        gasProviderList.add("Siti Energy Ltd");
        gasProviderList.add("Tripura Natural Gas");
        gasProviderList.add("Vadodara Gas Limited (VGL)");

    }

    public void add_future_use_details(String type){

        gasProviderList.clear();
        if (type.equalsIgnoreCase("Initial")){

            futureListBean.add(new FutureListBean("2","4132245632145",
                    "Indraprastha Gas Limited","gas"));

            futureUseAdapterGas = new FutureUseAdapterGas(GasBill.this,futureListBean);
            rv_add.setAdapter(futureUseAdapterGas);
            futureUseAdapterGas.notifyDataSetChanged();

        }else {

            futureListBean.add(new FutureListBean("2","41323151635143",
                    "Indraprastha Gas Limited","gas"));

            futureListBean.add(new FutureListBean("2",etBotConsumerId.getText().toString(),
                    etBotGasProvider.getText().toString(),"gas"));

            futureUseAdapterGas = new FutureUseAdapterGas(GasBill.this,futureListBean);
            rv_add.setAdapter(futureUseAdapterGas);
            futureUseAdapterGas.notifyDataSetChanged();
        }

    }

    public void cancel(View view){
        addFutureUse.setHideable(true);
        addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
        etBotGasProvider.setText("");
        etBotConsumerId.setText("");
    }
}