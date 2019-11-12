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

public class Internet extends AppCompatActivity {

    BottomSheetBehavior addFutureUse;

    FloatingActionButton fabDone;

    ArrayList<FutureListBean> futureListBean;

    MaterialEditText etOperator,etMobileNo;

    FutureUseAdapterInternet futureUseAdapterInternet;

    private RecyclerView rv_add;

    private LinearLayout amountLayout;

    LinearLayout llAirtel,llBsnl,llIdea,llJio,llMatrix,llTataDocomo,llTataIndicom,llVodafone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Internet");

        llAirtel = findViewById(R.id.ll_airtel);
        llBsnl = findViewById(R.id.ll_bsnl);
        llIdea = findViewById(R.id.ll_idea);
        llJio = findViewById(R.id.ll_jio);
        llMatrix = findViewById(R.id.ll_matrix);
        llTataDocomo = findViewById(R.id.ll_tata_docomo);
        llTataIndicom = findViewById(R.id.ll_tata_indicom);
        llVodafone = findViewById(R.id.ll_vodafone);

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
        rv_add.setLayoutManager(new LinearLayoutManager(Internet.this));
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

        llAirtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Airtel");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llVodafone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Vodafone");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llTataIndicom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Tata Indicom");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llTataDocomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Tata DOCOMO");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llMatrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Matrix Postpaid");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llBsnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("BSNL");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llIdea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Idea");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        llJio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etOperator.setText("Jio");
                addFutureUse.setHideable(true);
                addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

    }

    public void add_future_use_details(){

            futureListBean.add(new FutureListBean("2","9876543210",
                    "Vodafone","internet"));

            futureUseAdapterInternet = new FutureUseAdapterInternet(Internet.this,futureListBean);
            rv_add.setAdapter(futureUseAdapterInternet);
            futureUseAdapterInternet.notifyDataSetChanged();

    }

    public void cancel(View view){
        addFutureUse.setHideable(true);
        addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);

    }
}