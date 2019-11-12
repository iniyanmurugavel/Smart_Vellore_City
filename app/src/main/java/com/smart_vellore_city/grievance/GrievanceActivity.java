package com.smart_vellore_city.grievance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.smart_vellore_city.R;

import java.util.Objects;

public class GrievanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grievances);


        Toolbar toolbar = (Toolbar) findViewById(R.id.griev_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Grievance Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void submitGrievance(View v) {
        Toast.makeText(this, "Grievance Submitted Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}
