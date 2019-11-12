package com.smart_vellore_city.notification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.smart_vellore_city.R;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<NotificationPojo> notificationPojo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        initViews();
    }


    public void initViews() {
        recyclerView = findViewById(R.id.notification_rv);

        Toolbar toolbar = findViewById(R.id.noti_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadData();
    }


    public void loadData() {
        notificationPojo.add(new NotificationPojo("Request Money",
                "Dear Customer, Pay Rs. 1000 and get Rs. 1500. Pay using wallet ", "Dec 12, 06:42 PM"));
        notificationPojo.add(new NotificationPojo("EB Bill",
                "Dear Customer, Your EB bill has been Generated of Rs. 560. Pay using wallet ", "Dec 12, 07:42 PM"));


        NotificationAdapter adapter = new NotificationAdapter(notificationPojo, this);
        recyclerView.setAdapter(adapter);
    }

}
