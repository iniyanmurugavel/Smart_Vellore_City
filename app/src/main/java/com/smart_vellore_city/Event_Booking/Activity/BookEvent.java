package com.smart_vellore_city.Event_Booking.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.smart_vellore_city.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BookEvent extends AppCompatActivity {
    Button bookButton;
    TextView eventName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookevent);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        eventName = findViewById(R.id.eventName);
        Intent intent = getIntent();
        if(intent!=null){
            String event_name = intent.getStringExtra("name");
            eventName.setText(event_name);
        }

        bookButton = findViewById(R.id.bookButton);
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askConfirmation();
            }
        });

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
                        BookEvent.this.finish();
                    }
                });

            }
        })
         .show();
    }
}
