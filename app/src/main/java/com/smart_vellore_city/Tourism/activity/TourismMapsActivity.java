package com.smart_vellore_city.Tourism.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.smart_vellore_city.R;

public class TourismMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView tv_title;
    private double v, v1;
    private String title;
    private ImageView iv_back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        Marker marker = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(v, v1))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        LatLngBounds latLngBounds = new LatLngBounds(
                new LatLng(v, v1), new LatLng(v, v1));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngBounds.getCenter(), 15));

        dropPinEffect(marker);

    }

    private void initializeToolbarAndViews() {

        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_back_arrow = (ImageView) findViewById(R.id.iv_back_arrow);

        Intent i = getIntent();
        title = i.getStringExtra("title");
        tv_title.setText(title);

        if (title.equalsIgnoreCase("Sripuram - Golden Temple")) {
            v = 12.8738076;
            v1 = 79.0884481;
        } else if (title.equalsIgnoreCase("Vellore Fort")) {
            v = 12.9209702;
            v1 = 79.130071;
        } else if (title.equalsIgnoreCase("Yelagiri")) {
            v = 12.6026643;
            v1 = 78.651221;
        } else if (title.equalsIgnoreCase("Amirthi Zoological Park")) {
            v = 12.7322332;
            v1 = 79.0565819;
        } else if (title.equalsIgnoreCase("Jalagamparai Waterfalls")) {
            v = 12.543244;
            v1 = 78.6202856;
        } else {
            v = 12.9209702;
            v1 = 79.130071;
        }


        iv_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void dropPinEffect(final Marker marker) {
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        final long duration = 1500;

        final Interpolator interpolator = new BounceInterpolator();

        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                float t = Math.max(
                        1 - interpolator.getInterpolation((float) elapsed
                                / duration), 0);
                marker.setAnchor(0.5f, 1.0f + 14 * t);

                if (t > 0.0) {
                    // Post again 15ms later.
                    handler.postDelayed(this, 15);
                } else {

                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(v, v1), 15));
                    marker.setTitle(title);
                    marker.showInfoWindow();

                }
            }
        });
    }


}
