package com.smart_vellore_city.school;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.smart_vellore_city.R;
import com.smart_vellore_city.school.adapter.ReportAdapter;
import com.smart_vellore_city.school.pojo.ReportList;

import java.util.ArrayList;

public class TeacherReports extends AppCompatActivity {


    RecyclerView reportRecycler;
    ReportAdapter reportAdapter;
    ArrayList<ReportList> reportListArrayList;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_reports);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Reports");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        reportRecycler=findViewById(R.id.teacherreport);
        reportListArrayList=new ArrayList<>();

        reportListArrayList.add(new ReportList("Complaint","Iniyan Arul","12-02-2018","Very naught boy in the class"));
        reportListArrayList.add(new ReportList("Announcement","Ashok Sennan","14-02-2018","Tomorrow will be a holiday due to heavy rain"));
        reportListArrayList.add(new ReportList("Report","Sairam","15-02-2018","Your Son report card has been kindly"));
        reportListArrayList.add(new ReportList("Complaint","ParthaSarathy","17-02-2018","hi"));
        reportListArrayList.add(new ReportList("Complaint","Iniyan Arul","28-02-2018","hi"));

        layoutManager=new LinearLayoutManager(this);
        reportAdapter=new ReportAdapter(reportListArrayList,getApplicationContext());
        reportRecycler.setLayoutManager(layoutManager);
        reportRecycler.setAdapter(reportAdapter);

    }
}
