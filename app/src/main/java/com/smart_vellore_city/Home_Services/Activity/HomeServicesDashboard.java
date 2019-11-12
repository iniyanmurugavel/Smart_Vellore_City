package com.smart_vellore_city.Home_Services.Activity;

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

public class HomeServicesDashboard extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeservicesdashboard);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        arrayList = new ArrayList();
        arrayList.add(new DataModel("Plumber", R.drawable.ic_plumber, "#09A9FF"));
        arrayList.add(new DataModel("Electrician", R.drawable.ic_electrician, "#3E51B1"));
        arrayList.add(new DataModel("Driver", R.drawable.ic_driver, "#673BB7"));
        arrayList.add(new DataModel("Carpenter", R.drawable.ic_carpenter, "#4BAA50"));
        arrayList.add(new DataModel("Gardener", R.drawable.ic_gardener, "#F94336"));
        arrayList.add(new DataModel("Air Conditioner", R.drawable.ic_ac, "#0A9B88"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void onItemClick(DataModel item) {

        Intent i = new Intent(getApplicationContext(),HomeServices.class);
        i.putExtra("Type",item.text);
        startActivity(i);
    }
}
