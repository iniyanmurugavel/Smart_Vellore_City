package com.smart_vellore_city.Transport_Services.TrainServices.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.smart_vellore_city.R;

import java.util.Calendar;
import java.util.TimeZone;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BookTrain extends AppCompatActivity implements View.OnClickListener {
    Button confirm;
    RadioGroup radioGroup,radioGroup2;
    TextView journeyDate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booktrain);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        journeyDate = findViewById(R.id.jour_date_tv);
        journeyDate.setOnClickListener(this);
        confirm = findViewById(R.id.confirm);
        confirm.setOnClickListener(this);

    }
    private void askConfirmation() {
        SweetAlertDialog dialog =  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
        dialog.setTitleText("Are you sure?");
        dialog.setContentText("Do You want to pay ?");
        dialog.setConfirmText("Proceed");
        dialog.setCancelable(false);
        dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sDialog) {
                SweetAlertDialog sdialog =sDialog;
                sdialog.setTitleText("Success!");
                sdialog.setContentText("Your booking has been completed!");
                sdialog.setConfirmText("OK");
                sdialog.setCancelClickListener(null);
                sdialog.setCancelable(false);
                sdialog .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                sdialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        BookTrain.this.finish();
                    }
                });

            }
        })
                .show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.confirm){
            askConfirmation();
        }else if(v.getId()==R.id.jour_date_tv){
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

           DatePickerDialog datePickerDialog = new DatePickerDialog(BookTrain.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    journeyDate.setText(dayOfMonth+"/"+month+"/"+year);
                }
            },year,month,date);
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
            datePickerDialog.show();

        }
    }
}
