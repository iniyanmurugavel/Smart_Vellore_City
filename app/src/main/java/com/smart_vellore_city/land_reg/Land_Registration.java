package com.smart_vellore_city.land_reg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;
import com.smart_vellore_city.R;

import java.util.Objects;

public class Land_Registration extends AppCompatActivity {
   TextView tv_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land__registration);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Land Registration");

        tv_add = findViewById(R.id.tv_add);
        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TastyToast.makeText(Land_Registration.this,"Our branch Officers contact you as soon as posible!",TastyToast.LENGTH_SHORT,TastyToast.SUCCESS);
                finish();
            }
        });
    }
}
