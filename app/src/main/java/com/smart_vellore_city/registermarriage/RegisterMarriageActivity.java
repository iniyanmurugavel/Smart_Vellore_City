package com.smart_vellore_city.registermarriage;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;
import com.smart_vellore_city.R;

import java.util.Calendar;
import java.util.Objects;

public class RegisterMarriageActivity extends AppCompatActivity {
    EditText et_frm_Date,et_to_date,et_hus_name,et_hus_dob,et_wife_name,et_wife_dob;
    TextView tv_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_marriage);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Registered Marriage");

        et_frm_Date = findViewById(R.id.et_frm_Date);
        et_to_date = findViewById(R.id.et_to_date);
        et_hus_name = findViewById(R.id.et_hus_name);
        et_hus_dob = findViewById(R.id.et_hus_dob);
        et_wife_name = findViewById(R.id.et_wife_name);
        et_wife_dob = findViewById(R.id.et_wife_dob);
        tv_search = findViewById(R.id.tv_search);

        onClicks();

    }

    private void onClicks() {
        et_frm_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate(et_frm_Date);
            }
        });
        et_to_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate(et_to_date);
            }
        });
        et_hus_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate(et_hus_dob);
            }
        });
        et_wife_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate(et_wife_dob);
            }
        });
        tv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TastyToast.makeText(getBaseContext(),"Your Marriage Details Found!",TastyToast.LENGTH_SHORT,TastyToast.SUCCESS);
                finish();
            }
        });



    }

    public void selectDate(final EditText editText) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterMarriageActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        editText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();

    }
}
