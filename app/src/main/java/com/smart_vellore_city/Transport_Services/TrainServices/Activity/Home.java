package com.smart_vellore_city.Transport_Services.TrainServices.Activity;

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
import android.widget.EditText;
import android.widget.ImageView;

import com.smart_vellore_city.R;
import com.smart_vellore_city.Transport_Services.TranportRoute_MapsActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class Home extends AppCompatActivity implements View.OnClickListener {

    TabLayout tabLayout;
    Fragment localTransportFragment;
    ImageView calendar,filter,close,htab_header;
    DatePickerDialog datePickerDialog;
    BottomSheetBehavior behavior;
    CardView bottomSheet;
    SpinnerDialog spinnerDialog;
    TextInputEditText source_et,destination_et;
    ArrayList<String> source = new ArrayList<>();
    Button searchBus_bn;
    EditText date_et;

    double[] lat = {12.8965,12.8674,12.7409,12.8915,12.9796};
    double[] lng = {79.1069,79.0899,77.8253,79.1238,79.1375};
    String[] title = {"Pamani Express","Karagpur SuperFast","Pucuchery Express","Rameswaram SuperFast","Howrah SuperFast"};
    int[]  speed ={120,300,150,330,120};
    double[] distance = {8.7,637.3,173.8,472.5,206.7};
    String[] route = {"Katpadi-Vellore","Karagpur-Vellore","Vellore-Puduchery","Rameswaram-Vellore","Vellore-Howrah"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transport_home);

        Toolbar toolbar = findViewById(R.id.htab_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Train Services");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        setupTabLayout();
        calendar = findViewById(R.id.calendar_img);
        calendar.setOnClickListener(this);
        filter = findViewById(R.id.filter_img);
        filter.setOnClickListener(this);
        close =findViewById(R.id.close_img);
        close.setOnClickListener(this);
        htab_header = findViewById(R.id.htab_header);
        htab_header.setImageResource(R.drawable.train);
        source_et = findViewById(R.id.source_et);
        source_et.setText("Vellore");
        source_et.setOnClickListener(this);
        date_et = findViewById(R.id.date_et);
        date_et.setText(formatter.format(date));
        date_et.setOnClickListener(this);
        destination_et = findViewById(R.id.destination_et);
        destination_et.setText("Chennai");
        destination_et.setOnClickListener(this);
        searchBus_bn = findViewById(R.id.searchBus);
        searchBus_bn.setText(getString(R.string.searchTrains));
        searchBus_bn.setOnClickListener(this);

        source.add("Kadur");
        source.add("Rameswaram");
        source.add("Vijayawada");
        source.add("Puduchery");
        source.add("Tirukoilur");
        source.add("Pakala");
        setFilter();
    }

    private void setupTabLayout() {
        localTransportFragment = new TrainTransportFragment();
        replaceFragment(localTransportFragment);
        tabLayout = findViewById(R.id.htab_tabs);
        tabLayout.addTab(tabLayout.newTab(),false);

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

            } else {
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

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

          case R.id.date_et:
              Calendar calendar1 = Calendar.getInstance(TimeZone.getDefault());
              int year1 = calendar1.get(Calendar.YEAR);
              int month1 = calendar1.get(Calendar.MONTH);
              int date1 = calendar1.get(Calendar.DATE);

              datePickerDialog = new DatePickerDialog(Home.this, new DatePickerDialog.OnDateSetListener() {
                  @Override
                  public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                      date_et.setText(dayOfMonth+"/"+month+"/"+year);
                  }
              },year1,month1,date1);
              datePickerDialog.show();
              datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

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
                intent.putExtra("from","train");
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
