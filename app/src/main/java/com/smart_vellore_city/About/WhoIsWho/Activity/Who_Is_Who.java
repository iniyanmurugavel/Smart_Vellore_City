package com.smart_vellore_city.About.WhoIsWho.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.smart_vellore_city.About.WhoIsWho.Adapter.WhoisWhoAdapter;
import com.smart_vellore_city.About.WhoIsWho.Model.WhoisWhoModel;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Who_Is_Who extends AppCompatActivity {

    WhoisWhoAdapter adapter;
    private List<WhoisWhoModel> itemsList = new ArrayList<>() ;
    private String[] names = {"Thiru. S.A.Raman, I.A.S.,","Thiru. J. Partheeban B.Sc.,B.Ed.,","Thiru. Pravesh Kumar, I.P.S.,",
                        "Thiru. C.Vijayakumar","Thiru. P. Murugesan"};
    private String[] designation={"District Collector","District Revenue Officer","Superintendent of Police","Corporation Commissioner",
                            "P.A.(General) to Collector"};
    private String[] phone={"0416-2252345","0416-2253502","0416-2256802","0416-2220578","0416-2253034"};
    private String[] email={"collrvel@nic.in","dro.tnvlr@nic.in","spvellore@gmail.com","commr.vellore@tn.gov.in",
                        "pag.tnvlr@nic.in"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whoiswho);

        Toolbar toolbar = findViewById(R.id.htab_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapse = (CollapsingToolbarLayout)findViewById(R.id.htab_collapse_toolbar);
        collapse.setTitle("Who is Who");
        collapse.setExpandedTitleTextAppearance(R.style.collapse);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WhoisWhoAdapter(getItemList(),0);
        recyclerView.setAdapter(adapter);
    }

    public List<WhoisWhoModel> getItemList(){
        itemsList.clear();
       for(int i=0;i<names.length;i++){
           itemsList.add(new WhoisWhoModel(names[i],designation[i],phone[i],email[i]));
       }
        return itemsList;
    }
}
