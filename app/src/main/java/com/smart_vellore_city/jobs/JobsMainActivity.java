package com.smart_vellore_city.jobs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.smart_vellore_city.R;
import com.smart_vellore_city.jobs.adapter.JobsAdapter;
import com.smart_vellore_city.jobs.pojo.JobsModel;

import java.util.ArrayList;

public class JobsMainActivity extends AppCompatActivity {

    JobsAdapter jobsAdapter;
    ArrayList<JobsModel> jobsModelArrayList=new ArrayList<>();
    int[] images={R.drawable.pre,R.drawable.pre,R.drawable.pre,R.drawable.pre,R.drawable.pre,R.drawable.pre,R.drawable.pre};
    String[] companyNames={"Prematix Software","Intuit","Zoho","Verizon","Google","CGI","Infosys"};
    String[] designations={"Android Developer","System Admin","UI Designer","Tech Staff","Senior Engineer","Developer","Network engineer"};
    String[] experience={"1-2 Years","3-4 Years","freshers","8-10 Years","10-15 Years","2-4 Years","5-8 Years"};
    String[] location={"Bangalore","Bangalore","Chennai","London","Hyderabad","Bangalore","Bangalore"};
    String[] datePosted={"12/11/2018","21/12/2018","13/11/2018","17/12/2018","15/11/2018","11/12/2018","24/11/2018"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jobs_main);
        RecyclerView recyclerView=findViewById(R.id.jobs_recycler);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Jobs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        for(int i=0;i<images.length;i++)
        {
            JobsModel jobsModel=new JobsModel(companyNames[i],designations[i],location[i],experience[i],datePosted[i]);
            jobsModelArrayList.add(jobsModel);
            jobsAdapter=new JobsAdapter(jobsModelArrayList,this);
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(jobsAdapter);


    }
}
