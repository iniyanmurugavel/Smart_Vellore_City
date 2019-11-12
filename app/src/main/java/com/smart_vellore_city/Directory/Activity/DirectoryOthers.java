package com.smart_vellore_city.Directory.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.smart_vellore_city.Directory.Adapter.ContactsAdapter;
import com.smart_vellore_city.Directory.Model.ContactsModel;
import com.smart_vellore_city.R;

import java.util.ArrayList;

public class DirectoryOthers extends AppCompatActivity {

    RecyclerView recyclerViewContacts;
    ArrayList arrayListContacts;

    LinearLayout llContact,llDisasterMgmt,llHelpline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory_others);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewContacts = (RecyclerView) findViewById(R.id.recyclerView);

        llContact = (LinearLayout) findViewById(R.id.ll_contact);
        llDisasterMgmt = (LinearLayout) findViewById(R.id.ll_disaster_mgmt);
        llHelpline = (LinearLayout) findViewById(R.id.ll_helpline);

        arrayListContacts = new ArrayList();

        Intent i = getIntent();

        String type = i.getStringExtra("Type");

        if (type.equalsIgnoreCase("Contact Directory")){

            llContact.setVisibility(View.VISIBLE);
            llDisasterMgmt.setVisibility(View.GONE);
            llHelpline.setVisibility(View.GONE);

            getSupportActionBar().setTitle("Contact Directory");


            arrayListContacts.add(new ContactsModel("DISTRICT COLLECTOR","9444135000","0416-2252345","collrvel@nic.in"));
            arrayListContacts.add(new ContactsModel("District Revenue Officer","9445000904","0416-2253502","dro.tnvlr@nic.in"));
            arrayListContacts.add(new ContactsModel("Superintendent of Police","9444384633","0416-2256802","spvellore@gmail.com"));
            arrayListContacts.add(new ContactsModel("Sub-Collector, Tirupattur","9445000418","04179-220088","subcollector.tpt@gmail.com"));
            arrayListContacts.add(new ContactsModel("Sub-Collector, Vellore","9445000417","0416-2252395",""));
            arrayListContacts.add(new ContactsModel("Project Director, D.R.D.A","7373704205","0416-2253177","drdavel@nic.in"));
            arrayListContacts.add(new ContactsModel("Corporation Commissioner","7397389320","0416-2220578","commr.vellore@tn.gov.in"));
            arrayListContacts.add(new ContactsModel("P.A.(General) to Collector","9445008159","0416-2253034","pag.tnvlr@nic.in"));
            arrayListContacts.add(new ContactsModel("R.D.O Ranipet","9445000416","04172-272720","rodrpt.tnvlr@nic.in"));

            ContactsAdapter contactsAdapter = new ContactsAdapter(this, arrayListContacts);
            recyclerViewContacts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerViewContacts.setAdapter(contactsAdapter);

        }else if (type.equalsIgnoreCase("Disaster Management")){

            llContact.setVisibility(View.GONE);
            llDisasterMgmt.setVisibility(View.VISIBLE);
            llHelpline.setVisibility(View.GONE);

            getSupportActionBar().setTitle("Disaster Management");

        }else {
            llContact.setVisibility(View.GONE);
            llDisasterMgmt.setVisibility(View.GONE);
            llHelpline.setVisibility(View.VISIBLE);

            getSupportActionBar().setTitle("Helpline");


        }

    }
}
