package com.smart_vellore_city.Directory.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.smart_vellore_city.Adapter.RecyclerViewAdapter;
import com.smart_vellore_city.Emergency_Services.nearby.activities.NearBy;
import com.smart_vellore_city.Home_Services.Model.DataModel;
import com.smart_vellore_city.R;

import java.util.ArrayList;

public class Directory extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList arrayList;

    private FrameLayout li_nearby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Directory");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);

        li_nearby = findViewById(R.id.li_nearby);

        arrayList = new ArrayList();
        arrayList.add(new DataModel("Contact Directory", R.drawable.ic_phone_book, "#09A9FF"));
        arrayList.add(new DataModel("Disaster Management", R.drawable.ic_earthquake, "#3E51B1"));
        arrayList.add(new DataModel("Helpline", R.drawable.ic_support, "#673BB7"));
//        arrayList.add(new DataModel("Public Utilities", R.drawable.ic_contact, "#4BAA50"));

        li_nearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToNearByActivity = new Intent(Directory.this,NearBy.class);
                moveToNearByActivity.putExtra("EntryType","EmergencyService");
                startActivity(moveToNearByActivity);
            }
        });

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    public void onItemClick(DataModel item) {

//        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();

        if (item.text.equalsIgnoreCase("Public Utilities")){

            Intent i = new Intent(getApplicationContext(),PublicUtilitiesDashboard.class);
            startActivity(i);
        }else{
            Intent i = new Intent(getApplicationContext(),DirectoryOthers.class);
            i.putExtra("Type",item.text);
            startActivity(i);
        }

    }
}
