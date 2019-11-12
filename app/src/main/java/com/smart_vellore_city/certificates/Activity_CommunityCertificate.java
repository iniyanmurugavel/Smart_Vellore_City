package com.smart_vellore_city.certificates;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.smart_vellore_city.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Activity_CommunityCertificate extends AppCompatActivity implements View.OnClickListener {
    MaterialEditText salary_et,rationCard_et,signature_et,date_et,schoolcert_et;
    Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_certificate);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        salary_et = findViewById(R.id.salarycert_met);
        schoolcert_et = findViewById(R.id.schoolcert_met);
        rationCard_et = findViewById(R.id.rationcard_met);
        signature_et = findViewById(R.id.signature_met);
        date_et = findViewById(R.id.date_met);
        submit = findViewById(R.id.submit_btn);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        date_et.setText(formatter.format(date));

        salary_et.setOnClickListener(this);
        schoolcert_et.setOnClickListener(this);
        rationCard_et.setOnClickListener(this);
        signature_et.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.salarycert_met:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent, 0);
                break;
            case R.id.rationcard_met:
                Intent intent1 = new Intent(Intent.ACTION_GET_CONTENT);
                intent1.setType("*/*");
                startActivityForResult(intent1, 1);
                break;
            case R.id.signature_met:
                Intent intent2 = new Intent(Intent.ACTION_GET_CONTENT);
                intent2.setType("*/*");
                startActivityForResult(intent2, 2);
                break;
            case R.id.schoolcert_met:
                Intent intent3 = new Intent(Intent.ACTION_GET_CONTENT);
                intent3.setType("*/*");
                startActivityForResult(intent3, 3);
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
                        Activity_CommunityCertificate.this.finish();
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
                salary_et.setText(docName);
            }else if(requestCode==1){
                rationCard_et.setText(docName);
            }else if(requestCode==2){
                signature_et.setText(docName);
            }else if(requestCode==3){
                schoolcert_et.setText(docName);
            }
        }


    }
}
