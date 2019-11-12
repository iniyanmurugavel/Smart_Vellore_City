package com.smart_vellore_city.Bills;

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

public class BIllHome extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bills);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bill Payment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView =  findViewById(R.id.recyclerView);

        ArrayList arrayList = new ArrayList();
        arrayList.add(new DataModel("Electicity Bill", R.drawable.ic_electricity, "#09A9FF"));
        arrayList.add(new DataModel("Gas Bill", R.drawable.ic_gas, "#3E51B1"));
        arrayList.add(new DataModel("Water Bill", R.drawable.ic_water_bill, "#673BB7"));
        arrayList.add(new DataModel("Internet Bill", R.drawable.ic_internet_bill, "#4BAA50"));
        arrayList.add(new DataModel("Landline Bill", R.drawable.ic_phone_bill, "#F94336"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    public void onItemClick(DataModel item) {

        if (item.text.equalsIgnoreCase("Electicity Bill")){

            Intent i = new Intent(this,EBBill.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Gas Bill")){

            Intent i = new Intent(this,GasBill.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Water Bill")){

            Intent i = new Intent(this,WaterBill.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Internet Bill")){

            Intent i = new Intent(this,Internet.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Landline Bill")){

            Intent i = new Intent(this,Landline.class);
            startActivity(i);
        }

    }
}
