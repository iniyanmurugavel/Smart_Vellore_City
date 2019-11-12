package com.smart_vellore_city.About.Collectors.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.smart_vellore_city.About.Collectors.Model.CollectorsModel;
import com.smart_vellore_city.About.WhoIsWho.Adapter.WhoisWhoAdapter;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CollectorsList extends AppCompatActivity {

    WhoisWhoAdapter adapter;
    private List<CollectorsModel> itemsList = new ArrayList<>() ;
    private String[] names = {"Mr.S.A.RAMAN,I.A.S.,","Dr.R.NANDAGOPAL,I.A.S.,","Mr.RAJENDRA RATNOO,I.A.S.,",
            "Dr.R.NANDAGOPAL,I.A.S.,","Mr.K.BALARAMAN"};
    private String[] from={"31.07.2016","25.05.2016","24.04.2016","23.05.2014","21.05.2014"};
    private String[] to={"Till Date","30.07.2016","24.05.2016","23.04.2016","22.05.2014"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whoiswho);

        Toolbar toolbar = findViewById(R.id.htab_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapse = (CollapsingToolbarLayout)findViewById(R.id.htab_collapse_toolbar);
        collapse.setTitle("List of Collectors");

        collapse.setExpandedTitleTextAppearance(R.style.collapse);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WhoisWhoAdapter(this,getItemList(),1);
        recyclerView.setAdapter(adapter);
    }

    public List<CollectorsModel> getItemList(){
        itemsList.clear();
        for(int i=0;i<names.length;i++){
            itemsList.add(new CollectorsModel(names[i],from[i],to[i]));
        }
        return itemsList;
    }
}
