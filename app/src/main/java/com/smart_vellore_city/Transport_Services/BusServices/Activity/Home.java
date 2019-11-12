package com.smart_vellore_city.Transport_Services.BusServices.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;

import com.smart_vellore_city.R;
import com.smart_vellore_city.Transport_Services.TranportRoute_MapsActivity;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class Home extends AppCompatActivity implements TabLayout.OnTabSelectedListener,View.OnClickListener {

    TabLayout tabLayout;
    Fragment localTransportFragment,p2pTransportFragment,tnscTransportFragment;
    ImageView calendar,filter,close;
    DatePickerDialog datePickerDialog;
    BottomSheetBehavior behavior;
    CardView bottomSheet;
    SpinnerDialog spinnerDialog;
    TextInputEditText source_et,destination_et;
    ArrayList<String> source = new ArrayList<>();
    Button searchBus_bn;
    double[] lat = {12.8965,12.8674,12.7409,12.8915,12.9796};
    double[] lng = {79.1069,79.0899,77.8253,79.1238,79.1375};
    String[] title = {"TNSTC","MTC ","SETC-AC Sleeper","SETC-Non-AC Seater","SETC-Non-AC Sleeper"};
    int[]  speed ={50,55,60,60,60};
    double[] distance = {5.2,11.3,173.8,3.1,8.7};
    String[] route = {"Saduperi-Vellore","Thirumalaikodi-Vellore","Hosur-Vellore","Vellore-Thorapadi","Katpadi-Vellore"};


    String[] localImages={"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEM5Qfja-72YZ2MmBtC0HMuHH8CBb0fQv1xbysVbhO_7QFKQRLPA",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEM5Qfja-72YZ2MmBtC0HMuHH8CBb0fQv1xbysVbhO_7QFKQRLPA",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEM5Qfja-72YZ2MmBtC0HMuHH8CBb0fQv1xbysVbhO_7QFKQRLPA",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEM5Qfja-72YZ2MmBtC0HMuHH8CBb0fQv1xbysVbhO_7QFKQRLPA",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEM5Qfja-72YZ2MmBtC0HMuHH8CBb0fQv1xbysVbhO_7QFKQRLPA",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEM5Qfja-72YZ2MmBtC0HMuHH8CBb0fQv1xbysVbhO_7QFKQRLPA",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEM5Qfja-72YZ2MmBtC0HMuHH8CBb0fQv1xbysVbhO_7QFKQRLPA"};

    String[] p2pImages={"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxkza9Eb4qwgOnH3gB50RbAlWUWLEpu7Hnz1Lylw4f6qK5_eTUCQ",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxkza9Eb4qwgOnH3gB50RbAlWUWLEpu7Hnz1Lylw4f6qK5_eTUCQ",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxkza9Eb4qwgOnH3gB50RbAlWUWLEpu7Hnz1Lylw4f6qK5_eTUCQ",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxkza9Eb4qwgOnH3gB50RbAlWUWLEpu7Hnz1Lylw4f6qK5_eTUCQ",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxkza9Eb4qwgOnH3gB50RbAlWUWLEpu7Hnz1Lylw4f6qK5_eTUCQ",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxkza9Eb4qwgOnH3gB50RbAlWUWLEpu7Hnz1Lylw4f6qK5_eTUCQ",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxkza9Eb4qwgOnH3gB50RbAlWUWLEpu7Hnz1Lylw4f6qK5_eTUCQ"};

    String[] tnscImages={"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyos6e2pYkDiF4Erqc2uoZFQ3Z6ReaEGm4KoYJ50diIczY9F9q0w",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyos6e2pYkDiF4Erqc2uoZFQ3Z6ReaEGm4KoYJ50diIczY9F9q0w",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyos6e2pYkDiF4Erqc2uoZFQ3Z6ReaEGm4KoYJ50diIczY9F9q0w",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyos6e2pYkDiF4Erqc2uoZFQ3Z6ReaEGm4KoYJ50diIczY9F9q0w",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyos6e2pYkDiF4Erqc2uoZFQ3Z6ReaEGm4KoYJ50diIczY9F9q0w",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyos6e2pYkDiF4Erqc2uoZFQ3Z6ReaEGm4KoYJ50diIczY9F9q0w",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyos6e2pYkDiF4Erqc2uoZFQ3Z6ReaEGm4KoYJ50diIczY9F9q0w"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transport_home);

        Toolbar toolbar = findViewById(R.id.htab_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bus Services");

        setupTabLayout();

        calendar = findViewById(R.id.calendar_img);
        calendar.setOnClickListener(this);
        filter = findViewById(R.id.filter_img);
        filter.setOnClickListener(this);
        close = findViewById(R.id.close_img);
        close.setOnClickListener(this);
        source_et = findViewById(R.id.source_et);
        source_et.setOnClickListener(this);
        destination_et = findViewById(R.id.destination_et);
        destination_et.setOnClickListener(this);
        searchBus_bn = findViewById(R.id.searchBus);
        searchBus_bn.setOnClickListener(this);

        source.add("Vellore");
        source.add("Chennai");
        source.add("Coimbathore");
        source.add("Madurai");
        source.add("Banglore");
        source.add("Hosur");
        setFilter();
    }

    private void setupTabLayout() {
        localTransportFragment = new BusTransportFragment(localImages,"Local");
        p2pTransportFragment = new BusTransportFragment(p2pImages,"P2P");
        tnscTransportFragment = new BusTransportFragment(tnscImages,"TNSTC");

        replaceFragment(localTransportFragment);
        tabLayout = findViewById(R.id.htab_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Local"),true);
        tabLayout.addTab(tabLayout.newTab().setText("P2P"));
        tabLayout.addTab(tabLayout.newTab().setText("TNSTC"));
        tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        setCurrentTabFragment(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    private void setCurrentTabFragment(int tabPosition)
    {
        switch (tabPosition)
        {
            case 0 :
                replaceFragment(localTransportFragment);
                break;
            case 1 :
                replaceFragment(p2pTransportFragment);
                break;
            case 2 :
                replaceFragment(tnscTransportFragment);
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
      switch(id){
        case R.id.calendar_img:
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            datePickerDialog = new DatePickerDialog(Home.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                }
            },year,month,date);
            datePickerDialog.show();
            break;
          case R.id.filter_img:
            if (behavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                //bottomSheet.setText("Close sheet");
            } else {
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
               // bottomSheet.setText("Expand sheet");
            }
            break;
          case R.id.source_et:
              searchableSpinner(source,"Source",v);
              break;
          case R.id.destination_et:
              searchableSpinner(source,"Destination",v);
              break;
          case R.id.searchBus:
              behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
              break;
          case R.id.close_img:
              behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
              break;
        }
    }

    public void setFilter(){
         bottomSheet = findViewById(R.id.transportFilter_bs);
         behavior = BottomSheetBehavior.from(bottomSheet);
         behavior.setPeekHeight(0);
         behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        //bottomSheet.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                       // bottomSheet.setText("Expand Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

     public void searchableSpinner(ArrayList<String> items, String title,final View view){
         spinnerDialog=new SpinnerDialog(Home.this,items,title,"Close");// With No Animation
         spinnerDialog=new SpinnerDialog(Home.this,items,title,R.style.DialogAnimations_SmileWindow,"Close");// With 	Animation


         spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
             @Override
             public void onClick(String item, int position) {
                 /*Toast.makeText(Home.this, item + "  " + position+"", Toast.LENGTH_SHORT).show();
                 selectedItems.setText(item + " Position: " + position);*/
                 TextInputEditText EditView  = (TextInputEditText)view;
                 EditView.setText(item);
             }
         });
         spinnerDialog.showSpinerDialog();
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_mapview:
                Intent intent = new Intent(this, TranportRoute_MapsActivity.class);
                intent.putExtra("from","bus");
                intent.putExtra("lat",lat);
                intent.putExtra("lng",lng);
                intent.putExtra("title",title);
                intent.putExtra("speed",speed);
                intent.putExtra("distance",distance);
                intent.putExtra("route",route);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
