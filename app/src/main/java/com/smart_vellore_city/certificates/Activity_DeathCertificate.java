package com.smart_vellore_city.certificates;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.smart_vellore_city.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Activity_DeathCertificate extends AppCompatActivity implements View.OnClickListener{
    MaterialEditText signature_et,date_et,dob_et;
    Button submit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_certificate);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        signature_et = findViewById(R.id.signature_met);
        dob_et = findViewById(R.id.dob_met);
        date_et = findViewById(R.id.date_met);
        submit = findViewById(R.id.submit_btn);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        date_et.setText(formatter.format(date));

        signature_et.setOnClickListener(this);
        dob_et.setOnClickListener(this);
        submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.signature_met:
                Intent intent2 = new Intent(Intent.ACTION_GET_CONTENT);
                intent2.setType("*/*");
                startActivityForResult(intent2, 0);
                break;
            case R.id.dob_met:
                Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int date = calendar.get(Calendar.DATE);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Activity_DeathCertificate.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dob_et.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },year,month,date);
                datePickerDialog.show();
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                break;
            case R.id.submit_btn:
                SweetAlertDialog sdialog =new SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE);
                sdialog.setTitleText("Success!");
                sdialog.setContentText("Request has been submitted!");
                sdialog.setConfirmText("OK");
                sdialog.setCancelClickListener(null);
                sdialog.setCancelable(false);
                sdialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        Activity_DeathCertificate.this.finish();
                    }
                });
                sdialog.show();
                break;
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub

        if (resultCode == RESULT_OK) {
            String PathHolder = data.getData().getPath();
            int i = PathHolder.lastIndexOf("/");
            String docName= PathHolder.substring(i+1,PathHolder.length()-1);
            if(requestCode==0){
                signature_et.setText(docName);
            }
        }


    }
}
