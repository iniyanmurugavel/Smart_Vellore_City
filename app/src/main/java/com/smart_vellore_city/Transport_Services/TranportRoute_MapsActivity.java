package com.smart_vellore_city.Transport_Services;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.smart_vellore_city.R;

public class TranportRoute_MapsActivity extends FragmentActivity implements OnMapReadyCallback ,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private TextView tv_title;
    private String[] title;
    private double[] lat;
    private double[] lng;
    private double[] distance;
    private int[] speed;
    private String[] route;
    String[] address;
    String[] phone;
    double velloreLat = 12.9165;
    double velloreLng = 79.1325;
    String from;
    SupportMapFragment mapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
         mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        initializeToolbarAndViews();
        try {
            MapsInitializer.initialize(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if(from.equalsIgnoreCase("train")){
            showTrains();
        }else if(from.equalsIgnoreCase("bus")) {showBuses();}
        else if(from.equalsIgnoreCase("taxi")){
          showTaxi();
        }
    }

    private void initializeToolbarAndViews() {

        tv_title = findViewById(R.id.tv_title);
        ImageView iv_back_arrow = findViewById(R.id.iv_back_arrow);

        Intent i = getIntent();
        from = i.getStringExtra("from");
        title = i.getStringArrayExtra("title");
        lat = i.getDoubleArrayExtra("lat");
        lng = i.getDoubleArrayExtra("lng");
        if (from.equalsIgnoreCase("bus") || from.equalsIgnoreCase("train")){
            distance = i.getDoubleArrayExtra("distance");
            speed = i.getIntArrayExtra("speed");
            route = i.getStringArrayExtra("route");
       }else if(from.equalsIgnoreCase("taxi")){
            address = i.getStringArrayExtra("address");
            phone = i.getStringArrayExtra("phone");
       }

        iv_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranportRoute_MapsActivity.this.finish();
            }
        });

        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if(marker!=null ) {
            String posTag = marker.getTag().toString();
           if(!posTag.equals("")) {
            final Dialog dialog = new Dialog(TranportRoute_MapsActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            dialog.setContentView(R.layout.map_infowindow);
            TextView title_tv = dialog.findViewById(R.id.titleInfo);
            TextView route_tv = dialog.findViewById(R.id.routeInfo);
            TextView distance_tv = dialog.findViewById(R.id.disInfo);
            TextView speed_tv =  dialog.findViewById(R.id.speedInfo);



                    int position = Integer.parseInt(posTag);
                    title_tv.setText(title[position]);

                    if (from.equalsIgnoreCase("train") || from.equalsIgnoreCase("bus")) {
                        route_tv.setText("Route : " + route[position]);
                        distance_tv.setText("Distance : " + String.valueOf(distance[position]) + " Km");
                        speed_tv.setText("Speed : " + String.valueOf(speed[position]) + " Kmps");
                        speed_tv.setVisibility(View.VISIBLE);

                    } else if (from.equalsIgnoreCase("taxi")) {
                        route_tv.setText("Address : " + address[position]);
                        distance_tv.setText("Phone : " + String.valueOf(phone[position]));
                        speed_tv.setVisibility(View.GONE);
                    }
                    dialog.show();
                }

        }

        return true;

    }



    private void showBuses(){

        tv_title.setText("Bus Services");
        double katpadiLat = 12.9718; double katpadiLng=79.1384;
        double velloreLat = 12.9165; double velloreLng=79.1325;

        int iconId = R.drawable.ic_mtcbus;
        for(int i=0;i<title.length;i++){
            Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(lat[i], lng[i])));
            if(title[i].contains("TNSTC")){
                iconId= R.drawable.ic_bus;
            }else if(title[i].contains("MTC")){
                iconId= R.drawable.ic_mtcbus;
            }else if(title[i].contains("SETC")){
                iconId= R.drawable.ic_setcbus;
            }
            marker.setIcon(bitmapDescriptorFromVector(TranportRoute_MapsActivity.this,iconId));
            marker.setTag(String.valueOf(i));

        }

        Marker velloreMarker = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(velloreLat, velloreLng)));
        velloreMarker.setIcon(bitmapDescriptorFromVector(TranportRoute_MapsActivity.this,R.drawable.ic_bus_stop));
        velloreMarker.setTitle("Vellore Bus Station");
        velloreMarker.setTag("");

        Marker katpadiMarker = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(katpadiLat, katpadiLng)));
        katpadiMarker.setIcon(bitmapDescriptorFromVector(TranportRoute_MapsActivity.this,R.drawable.ic_bus_stop));
        katpadiMarker.setTitle("Katpadi Bus Station");
        katpadiMarker.setTag("");

        mMap.setOnMarkerClickListener(this);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(velloreLat, velloreLng), 12));
    }

    private void showTrains(){
        tv_title.setText("Train Services");
        double katpadiLat = 12.9718; double katpadiLng=79.1384;
        double velloreLat = 12.9165; double velloreLng=79.1325;
        int iconId = R.drawable.ic_train_on_railroad;
        for(int i=0;i<title.length;i++){
            Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(lat[i], lng[i])));
            if(title[i].contains("Express")){
                iconId= R.drawable.ic_train_express;
            }else if(title[i].contains("SuperFast")){
                iconId = R.drawable.ic_train_on_railroad;
            }
            marker.setIcon(bitmapDescriptorFromVector(TranportRoute_MapsActivity.this,iconId));
            marker.setTag(String.valueOf(i));

        }

        Marker velloreMarker = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(velloreLat, velloreLng)));
        velloreMarker.setIcon(bitmapDescriptorFromVector(TranportRoute_MapsActivity.this,R.drawable.ic_railwaystation));
        velloreMarker.setTitle("Vellore Railway Station");
        velloreMarker.setTag("");

        Marker katpadiMarker = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(katpadiLat, katpadiLng)));
        katpadiMarker.setIcon(bitmapDescriptorFromVector(TranportRoute_MapsActivity.this,R.drawable.ic_railwaystation));
        katpadiMarker.setTitle("Katpadi Jn Railway Station");
        katpadiMarker.setTag("");

        mMap.setOnMarkerClickListener(this);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(velloreLat, velloreLng), 12));
    }

    private void showTaxi(){
        tv_title.setText("Auto/Taxi Services");

        for(int i=0;i<title.length;i++){
            Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(lat[i], lng[i])));

            marker.setIcon(bitmapDescriptorFromVector(TranportRoute_MapsActivity.this,R.drawable.ic_frontal_taxi_cab));
            marker.setTag(String.valueOf(i));

        }
        mMap.setOnMarkerClickListener(this);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(velloreLat, velloreLng), 12));
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

}
