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

public class EBBill extends AppCompatActivity {

    BottomSheetBehavior addFutureUse;

    FloatingActionButton add_future_use,fabDone;

    ArrayList<FutureListBean> futureListBean;

    public EditText etBotEbBoard, etBotEbConsumerId;

//    etEbBoard, etEbConsumerId;

    MaterialEditText etEBoard,etConsumerId;

    FutureUseAdapter futureUseAdapter;

    private RecyclerView rv_add;

    private LinearLayout amountLayout;

    private SpinnerDialog spinnerDialogEBoard;
    private SpinnerDialog spinnerDialogEBotBoard;

    private ArrayList<String> eBoardList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb_bill);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("EB Bill");


        etBotEbBoard = findViewById(R.id.rv_eb_board);
        etBotEbConsumerId= findViewById(R.id.rv_consumer_id);
//        etEbBoard= findViewById(R.id.eb_board);
//        etEbConsumerId= findViewById(R.id.consumer_id);

        amountLayout = findViewById(R.id.amountLayout);

        etConsumerId = findViewById(R.id.et_consumer_id);
        etEBoard = findViewById(R.id.et_eboard);

        futureListBean = new ArrayList<FutureListBean>();

        View addFut = findViewById(R.id.addFutureDetail);
        addFutureUse = BottomSheetBehavior.from(addFut);
        addFutureUse.setHideable(true);
        addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);

//        try {
//            Intent i = getIntent();
//            String eb_operator_code1 = i.getStringExtra("operator_code");
//            String eb_consumer_number = i.getStringExtra("consumer_number");
//            String eb_consumer_board = i.getStringExtra("consumer_board");
//            etEbBoard.setText(eb_consumer_board);
//            etEbConsumerId.setText(eb_consumer_number);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        rv_add = findViewById(R.id.rv_future_use);
        rv_add.setHasFixedSize(true);
        rv_add.setLayoutManager(new LinearLayoutManager(EBBill.this));
        rv_add.setItemAnimator(new DefaultItemAnimator());

        add_future_use= findViewById(R.id.add_future_use);
        fabDone= findViewById(R.id.done);

        add_future_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                alert_future_use();
                hideSoftKeyboard();
                addFutureUse.setState(BottomSheetBehavior.STATE_EXPANDED);
                addFutureUse.setHideable(false);
            }
        });

        add_future_use_details("Initial");

        getEBoards();

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

        spinnerDialogEBoard = new SpinnerDialog(EBBill.this, eBoardList, "Select or Search Electricity Boards", "Close");// With No Animation
        spinnerDialogEBotBoard = new SpinnerDialog(EBBill.this, eBoardList, "Select or Search Electricity Boards", "Close");// With No Animation

        spinnerDialogEBoard.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int i) {

                etEBoard.setText(item);

            }
        });

        spinnerDialogEBotBoard.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int i) {

                etBotEbBoard.setText(item);

            }
        });

        etEBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinnerDialogEBoard.showSpinerDialog();

            }
        });

        etBotEbBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinnerDialogEBotBoard.showSpinerDialog();

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

    public void getEBoards(){

        eBoardList.add("Andhra Pradesh Power Generation Corporation");
        eBoardList.add("Assam State Electricity Board");
        eBoardList.add("Chhattisgarh State Power Generation Company Limited");
        eBoardList.add("Delhi Vidyut Board");
        eBoardList.add("Gujarat Urja Vikas Nigam");
        eBoardList.add("Haryana Power Generation Corporation");
        eBoardList.add("Jharkhand State Electricity Board");
        eBoardList.add("Karnataka Power Corporation Limited");
        eBoardList.add("Kerala State Electricity Board");
        eBoardList.add("Maharashtra State Electricity Board");
        eBoardList.add("Rajasthan Rajya Vidyut Utpadan Nigam");
        eBoardList.add("Uttar Pradesh Rajya Vidyut Utpadan Nigam");
        eBoardList.add("West Bengal State Electricity Board");
        eBoardList.add("Odisha Power Generation Corporation");
        eBoardList.add("Tamil Nadu Electricity Board");
        eBoardList.add("Punjab State Power Corporation Limited");

    }

    public void add_future_use_details(String type){

        eBoardList.clear();
        if (type.equalsIgnoreCase("Initial")){

            futureListBean.add(new FutureListBean("2","70165463144",
                    "Tamil Nadu Electricity Board","eb"));

            futureUseAdapter = new FutureUseAdapter(EBBill.this,futureListBean);
            rv_add.setAdapter(futureUseAdapter);
            futureUseAdapter.notifyDataSetChanged();

        }else {

            futureListBean.add(new FutureListBean("2","70165463144",
                    "Tamil Nadu Electricity Board","eb"));

            futureListBean.add(new FutureListBean("2",etBotEbConsumerId.getText().toString(),
                    etBotEbBoard.getText().toString(),"eb"));

            futureUseAdapter = new FutureUseAdapter(EBBill.this,futureListBean);
            rv_add.setAdapter(futureUseAdapter);
            futureUseAdapter.notifyDataSetChanged();
        }

    }

    public void cancel(View view){
        addFutureUse.setHideable(true);
        addFutureUse.setState(BottomSheetBehavior.STATE_HIDDEN);
        etBotEbBoard.setText("");
        etBotEbConsumerId.setText("");
    }
}