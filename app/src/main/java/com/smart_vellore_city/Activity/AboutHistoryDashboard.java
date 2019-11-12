package com.smart_vellore_city.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.smart_vellore_city.About.Collectors.Activity.CollectorsList;
import com.smart_vellore_city.About.ElectedRepresentatives.Activity.ElectedRepresentativesList;
import com.smart_vellore_city.About.History.History;
import com.smart_vellore_city.About.WhoIsWho.Activity.Who_Is_Who;
import com.smart_vellore_city.Adapter.RecyclerViewAdapter;
import com.smart_vellore_city.Home_Services.Model.DataModel;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.Objects;

public class AboutHistoryDashboard extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("About History");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        FrameLayout li_nearby = findViewById(R.id.li_nearby);

        li_nearby.setVisibility(View.GONE);

        ArrayList<DataModel> arrayList = new ArrayList<>();
        arrayList.add(new DataModel("Collectors", R.drawable.ic_speaking, "#09A9FF"));
        arrayList.add(new DataModel("Elected Representatives", R.drawable.ic_politician, "#3E51B1"));
        arrayList.add(new DataModel("History", R.drawable.ic_world, "#673BB7"));
        arrayList.add(new DataModel("Who Is Who", R.drawable.ic_search_for_staff, "#4BAA50"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    public void onItemClick(DataModel item) {

        if (item.text.equalsIgnoreCase("Collectors")){

            Intent i = new Intent(getApplicationContext(),CollectorsList.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("Elected Representatives")){

            Intent i = new Intent(getApplicationContext(),ElectedRepresentativesList.class);
            startActivity(i);

        }else if (item.text.equalsIgnoreCase("History")){

            Intent i = new Intent(getApplicationContext(),History.class);
            startActivity(i);

        }else {

            Intent i = new Intent(getApplicationContext(),Who_Is_Who.class);
            startActivity(i);

        }

    }
}

