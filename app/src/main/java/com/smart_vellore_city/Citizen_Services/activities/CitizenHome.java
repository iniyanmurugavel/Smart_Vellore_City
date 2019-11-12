package com.smart_vellore_city.Citizen_Services.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.smart_vellore_city.Activity.GetSchemeDetails;
import com.smart_vellore_city.Adapter.RecyclerViewAdapter;
import com.smart_vellore_city.Directory.Activity.Directory;
import com.smart_vellore_city.Directory.Activity.PublicUtilitiesDashboard;
import com.smart_vellore_city.Home_Services.Model.DataModel;
import com.smart_vellore_city.R;
import com.smart_vellore_city.grievance.GrievanceActivity;
import com.smart_vellore_city.land_reg.Land_Registration;
import com.smart_vellore_city.registermarriage.RegisterMarriageActivity;

import java.util.ArrayList;
import java.util.Objects;

public class CitizenHome extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Citizen Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);

        FrameLayout li_nearby = findViewById(R.id.li_nearby);
        li_nearby.setVisibility(View.GONE);

        arrayList = new ArrayList();
        arrayList.add(new DataModel("Directory", R.drawable.ic_directory_new, "#09A9FF"));
        arrayList.add(new DataModel("Grievances", R.drawable.ic_questionary, "#3E51B1"));
        arrayList.add(new DataModel("Marriage Registration", R.drawable.ic_marriage_regis, "#673BB7"));
        arrayList.add(new DataModel("Land Registration", R.drawable.ic_land_regis, "#4BAA50"));
        arrayList.add(new DataModel("Distress Service", R.drawable.ic_distress, "#F94336"));
        arrayList.add(new DataModel("Public Utilities", R.drawable.ic_contact, "#0A9B88"));
        arrayList.add(new DataModel("Pension", R.drawable.ic_retirement, "#D5C23A"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    public void onItemClick(DataModel item) {

        if(item.text.equalsIgnoreCase("Directory")){

            Intent i = new Intent(getApplicationContext(),Directory.class);
            startActivity(i);
        }else if (item.text.equalsIgnoreCase("Grievances")) {

            Intent i = new Intent(getApplicationContext(), GrievanceActivity.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Public Utilities")){

            Intent i = new Intent(getApplicationContext(),PublicUtilitiesDashboard.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Pension")){

            Intent i = new Intent(getApplicationContext(),GetSchemeDetails.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Marriage Registration")){

            Intent i = new Intent(getApplicationContext(),RegisterMarriageActivity.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Land Registration")){

            Intent i = new Intent(getApplicationContext(),Land_Registration.class);
            startActivity(i);
        }

    }
}
