package com.smart_vellore_city.certificates;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.smart_vellore_city.Adapter.RecyclerViewAdapter;
import com.smart_vellore_city.Home_Services.Model.DataModel;
import com.smart_vellore_city.R;
import com.smart_vellore_city.grievance.GrievanceActivity;

import java.util.ArrayList;

public class Dashboard_Certificates extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList arrayList;

    FrameLayout li_nearby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("City Irrigation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView =  findViewById(R.id.recyclerView);

        li_nearby = findViewById(R.id.li_nearby);
        li_nearby.setVisibility(View.GONE);

        arrayList = new ArrayList();
        arrayList.add(new DataModel("Income Certificate", R.drawable.ic_income, "#09A9FF"));
        arrayList.add(new DataModel("Nativity Certificate", R.drawable.ic_certificate, "#3E51B1"));
        arrayList.add(new DataModel("Community Certificate", R.drawable.ic_community_certificate, "#673BB7"));
        arrayList.add(new DataModel("Birth Certificate", R.drawable.ic_birth_certificate, "#4BAA50"));
        arrayList.add(new DataModel("Death Certificate", R.drawable.ic_death_certificate, "#F94336"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    public void onItemClick(DataModel item) {


        if (item.text.equalsIgnoreCase("Income Certificate")) {

            Intent i = new Intent(getApplicationContext(), Activity_IncomeCertificate.class);
            startActivity(i);
        } else if (item.text.equalsIgnoreCase("Nativity Certificate")) {

            Intent i = new Intent(getApplicationContext(), Activity_NativityCertificate.class);
            startActivity(i);
        }else if (item.text.equalsIgnoreCase("Community Certificate")) {

            Intent i = new Intent(getApplicationContext(), Activity_CommunityCertificate.class);
            startActivity(i);
        }else if (item.text.equalsIgnoreCase("Birth Certificate")) {

            Intent i = new Intent(getApplicationContext(), Activity_BirthCertificate.class);
            startActivity(i);
        }else if (item.text.equalsIgnoreCase("Death Certificate")) {

            Intent i = new Intent(getApplicationContext(), Activity_DeathCertificate.class);
            startActivity(i);
        }else if (item.text.equalsIgnoreCase("Grievances")) {

            Intent i = new Intent(getApplicationContext(), GrievanceActivity.class);
            startActivity(i);
        }


    }
}