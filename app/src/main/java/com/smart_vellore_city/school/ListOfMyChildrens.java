package com.smart_vellore_city.school;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.smart_vellore_city.R;
import com.smart_vellore_city.school.pojo.ListChildData;
import com.smart_vellore_city.school.adapter.ListChildAdapter;

import java.util.ArrayList;

public class ListOfMyChildrens extends AppCompatActivity {
    RecyclerView recyclerView;
    ListChildAdapter listChildAdapter;
    ArrayList<ListChildData> listChildDataArrayList;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_my_childrens);
        recyclerView=findViewById(R.id.mykidsrecycler);

        Toolbar toolbar =  findViewById(R.id.schooltoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listChildDataArrayList=new ArrayList<>();

        listChildDataArrayList.add(new ListChildData("Iniyan Arul","12","MVM","Hosur",R.drawable.kid));
        listChildDataArrayList.add(new ListChildData("Ashok Sennan","11","Vijay vidyalaya","Hosur",R.drawable.kid));
        listChildDataArrayList.add(new ListChildData("Sairam","15","St.Josephs","Hosur",R.drawable.kid));
        listChildDataArrayList.add(new ListChildData("ParthaSarathy","11","SVV","Hosur",R.drawable.kid));
        listChildDataArrayList.add(new ListChildData("Iniyan Arul","10","MVm","Hosur",R.drawable.kid));

        layoutManager=new LinearLayoutManager(ListOfMyChildrens.this);
       recyclerView.setLayoutManager(layoutManager);
        listChildAdapter=new ListChildAdapter(getApplicationContext(),listChildDataArrayList);

        recyclerView.setAdapter(listChildAdapter);
    }
}
