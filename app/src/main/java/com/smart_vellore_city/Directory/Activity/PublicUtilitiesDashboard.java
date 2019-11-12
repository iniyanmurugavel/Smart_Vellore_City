package com.smart_vellore_city.Directory.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.smart_vellore_city.Adapter.RecyclerViewAdapter;
import com.smart_vellore_city.Home_Services.Model.DataModel;
import com.smart_vellore_city.R;

import java.util.ArrayList;

public class PublicUtilitiesDashboard extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_utilities_dashboard);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Public Utilities");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        arrayList = new ArrayList();
        arrayList.add(new DataModel("Hospitals", R.drawable.ic_hospital, "#09A9FF"));
        arrayList.add(new DataModel("Blood Banks", R.drawable.ic_blood_donation, "#3E51B1"));
        arrayList.add(new DataModel("Municipalities", R.drawable.ic_city_hall, "#673BB7"));
        arrayList.add(new DataModel("Regional Transport Offices", R.drawable.ic_transport_office, "#4BAA50"));
        arrayList.add(new DataModel("Registrar Offices", R.drawable.ic_registrar_office, "#F94336"));
        arrayList.add(new DataModel("Colleges/Universities", R.drawable.ic_university, "#0A9B88"));
        arrayList.add(new DataModel("Post Offices", R.drawable.ic_post_office, "#D5C23A"));
        arrayList.add(new DataModel("NGOs", R.drawable.ic_ngo, "#D14C94"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    public void onItemClick(DataModel item) {

//        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(),PublicUtilities.class);
            i.putExtra("Type",item.text);
            startActivity(i);

    }
}
