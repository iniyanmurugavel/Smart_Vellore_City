package com.smart_vellore_city.Movie_Booking.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.smart_vellore_city.Movie_Booking.Adapter.Adapter_TheatreList;
import com.smart_vellore_city.Movie_Booking.Bean.Model_ThreatreList;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String[] threatreNames = {"Alankar Cinemas","Venus Cinemas","Apsara Theatre","Thirumalai Theatre",
            "Galaxy Cinemas","Aascars Cinemas","Srinivasa Theatre"};

    public String[] theatreAddress={"Plot No 3, Infantry Road, Vellore, Tamil Nadu 632001",
             "Sasthri Nagar, Krishna Nagar, Veerasamy Nagar, Vellore, Tamil Nadu 632001","Anna Salai, Vasantapuram, Kosapet, Vellore, Tamil Nadu 632001",
             "Arts College Road, Near Muthu Rangam Arts College, Otteri, Vellore, Tamil Nadu 632002","Muthamizh Nagar, Katpadi, Vellore, Tamil Nadu 632007",
             "372 Chittoor Rd Katpadi, Vellore, Tamil Nadu 632007"," No. 1, Arcot Rd, Near Minor Jail, Sathuvachari, Vellore, Tamil Nadu 632009"};

    public String[] ratings={"3.2","4.9","4.6","4.0","3.6","4.0","3.1"};
    public Integer[] images={R.drawable.alankarcinemas,R.drawable.venuscinemas,R.drawable.apsaratheatre,R.drawable.tirumalitheatre,
                          R.drawable.galaxycinemas,R.drawable.ascarcinemas,R.drawable.srinivasatheatre};
    public Double[] lat={12.9126,12.9022,12.9110,12.8839,12.9691,12.9616,12.9318};
    public Double[] lng={79.1305,79.1306,79.1317,79.1370,79.1409,79.1370,77.6074};

   public RecyclerView recyclerView;
   public Adapter_TheatreList adapter_theatreList;
   public List<Model_ThreatreList> listItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Movie Booking");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,OrientationHelper.VERTICAL,false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                                                                                OrientationHelper.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter_theatreList = new Adapter_TheatreList(this,getListItems());
        recyclerView.setAdapter(adapter_theatreList);
    }

    public List<Model_ThreatreList> getListItems(){
        listItems.clear();
        for(int i=0;i<threatreNames.length;i++){
            listItems.add(new Model_ThreatreList(threatreNames[i],theatreAddress[i],ratings[i],images[i],lat[i],lng[i]));
        }
        return listItems;
    }
}
