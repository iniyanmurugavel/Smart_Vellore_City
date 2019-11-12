package com.smart_vellore_city.Auto_taxi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.smart_vellore_city.Auto_taxi.Model.Auto_TaxiModel;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Transport_Services.TranportRoute_MapsActivity;

import java.util.ArrayList;
import java.util.List;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class Home extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView,calendar,filter,close ;
    Fragment taxiFragment,autoFragment;
    TabLayout tabLayout;
    TextInputEditText source_et,destination_et;
    Button searchBus_bn;
    BottomSheetBehavior behavior;
    CardView bottomSheet;
    SpinnerDialog spinnerDialog;
    List<Auto_TaxiModel> autoList = new ArrayList<>();
    List<Auto_TaxiModel> taxiList = new ArrayList<>();
    ArrayList<String> places= new ArrayList<>();

    String[] names = {"OLA","UBER","Cool Cab","Yellow Taxi","Yatrik","Easy Cabs","Mega Cabs"};
    String[] source = {"Vellore","Vellore","Vellore","Vellore","Vellore","Vellore","Vellore"};
    String[] destination = {"Modur","Poigai","Palavansathu","Virupatchipuram","Adukkamparai","Vanjur","Perumugai"};
    String[] fare = {"Rs.250","Rs.500","Rs.300","Rs.450","Rs.650","Rs.350","Rs.400"};
    String[] mobile={"9876567849","9876567849","9876567849","9876567849","9876567849","9876567849","9876567849"};

    String autoImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSQsdv0KnHugXyLmpmQiyWDIQv33caggh9-9cYZBPQws2jeIYh";
    String[] autoImages = {autoImage,autoImage,autoImage,autoImage,autoImage,autoImage,autoImage};

    String taxiImage="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXx-mHB-gke8-9_42wpMrXynSBSfl3SijmtCp3egyeF7a00WlO\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXx-mHB-gke8-9_42wpMrXynSBSfl3SijmtCp3egyeF7a00WlO";
    String[] taxiImages = {taxiImage,taxiImage,taxiImage,taxiImage,taxiImage,taxiImage,taxiImage};

    double[] lat = {12.8965,12.8674,12.7409,12.8915,12.9796};
    double[] lng = {79.1069,79.0899,77.8253,79.1238,79.1375};
    String[] title = {"Fastrack Call Taxi","Wings Taxi&Cab Services","SAI Call Taxi","Vellore Cabs","Maya Call Taxi"};
    String[]  address ={"No 246 A, 12th Cross",
                         "Sankaranpalayam, Vellore","35/4, Otthavadai Street, Kaspa",
                          "139, Long Bazzar, Sripuram","Natteri Krishnamachari Rd"};
    String[] phone = {"0416 288 8999","091591 99599","0416 420 1777","094433 55362","0416 222 4455"};
    String[] route = {"Katpadi-Vellore","Karagpur-Vellore","Vellore-Puduchery","Rameswaram-Vellore","Vellore-Howrah"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transport_home);
        Toolbar toolbar = (Toolbar)findViewById(R.id.htab_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Auto&Taxi Services");

        imageView = (ImageView)findViewById(R.id.htab_header);
        imageView.setImageResource(R.drawable.car_auto);
        calendar = (ImageView)findViewById(R.id.calendar_img);
        calendar.setVisibility(View.INVISIBLE);

        filter = (ImageView)findViewById(R.id.filter_img);
        filter.setOnClickListener(this);
        close = (ImageView)findViewById(R.id.close_img);
        close.setOnClickListener(this);
        source_et = (TextInputEditText)findViewById(R.id.source_et);
        source_et.setOnClickListener(this);
        destination_et = (TextInputEditText)findViewById(R.id.destination_et);
        destination_et.setOnClickListener(this);
        searchBus_bn = (Button)findViewById(R.id.searchBus);
        searchBus_bn.setText("SEARCH TAXI");
        searchBus_bn.setOnClickListener(this);
        setupTabLayout();

        places.add("Vellore");
        places.add("Modur");
        places.add("Poigai");
        places.add("Palavansathu");
        places.add("Virupatchipuram");
        places.add("Adukkamparai");
        places.add("Vanjur");
        setFilter();
    }
    public void setupTabLayout(){
        taxiFragment = new Auto_TaxiFragment(getTaxiList());
        autoFragment = new Auto_TaxiFragment(getAutoList());
        replaceFragment(taxiFragment);
        tabLayout = (TabLayout) findViewById(R.id.htab_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Taxi"),true);
        tabLayout.addTab(tabLayout.newTab().setText("Auto"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        });
    }

    private void setCurrentTabFragment(int tabPosition)
    {
        switch (tabPosition)
        {
            case 0 :
                searchBus_bn.setText("SEARCH TAXI");
                replaceFragment(taxiFragment);
                break;
            case 1 :
                searchBus_bn.setText("SEARCH AUTO");
                replaceFragment(autoFragment);
                break;

        }
    }
    public void replaceFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
 public List<Auto_TaxiModel> getTaxiList(){
         taxiList.clear();
         for(int i=0;i<names.length;i++){
             taxiList.add(new Auto_TaxiModel(names[i],source[i],destination[i],fare[i],taxiImages[i],mobile[i]));
         }
         return taxiList;
 }

 public List<Auto_TaxiModel> getAutoList(){
     autoList.clear();
     for(int i=0;i<names.length;i++){
         autoList.add(new Auto_TaxiModel(names[i],source[i],destination[i],fare[i],autoImages[i],mobile[i]));
     }
     return autoList;
 }
    @Override
    public void onClick(View v) {
        int id= v.getId();
        switch(id){

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
                searchableSpinner(places,"Source",v);
                break;
            case R.id.destination_et:
                searchableSpinner(places,"Destination",v);
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
                intent.putExtra("from","taxi");
                intent.putExtra("lat",lat);
                intent.putExtra("lng",lng);
                intent.putExtra("title",title);
                intent.putExtra("address",address);
                intent.putExtra("phone",phone);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
