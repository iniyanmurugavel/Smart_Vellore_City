package com.smart_vellore_city.parking.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.smart_vellore_city.R;
import com.smart_vellore_city.parking.Pojo.Parking_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingMap extends AppCompatActivity implements OnMapReadyCallback {
    private AppCompatDelegate delegate;

    private GoogleMap mMap;
    TextView search;
    Marker marker = null;
    private TextView tv_title;
    private double v, v1;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Near By");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        search = (TextView) findViewById(R.id.search);
        search.setText("Vellore Bus Stand , Vellore District , 60601");
        search.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        search.setSingleLine(true);
        search.setMarqueeRepeatLimit(-1);
        search.setSelected(true);

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


        LatLngBounds latLngBounds = null;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        Bitmap.Config conf = Bitmap.Config.ARGB_8888;
        Bitmap bmp = Bitmap.createBitmap(80, 80, conf);
        Canvas canvas1 = new Canvas(bmp);

// paint defines the text color, stroke width and size
        Paint color = new Paint();
        color.setTextSize(35);
        color.setColor(Color.BLACK);


        List<Parking_list> list = new ArrayList<>();
        list.add(new Parking_list(12.8748076, 79.0282251));
        list.add(new Parking_list(12.8738076, 79.0864481));
        list.add(new Parking_list(12.8768076, 79.0854481));
        list.add(new Parking_list(12.8768076, 79.0844481));
        list.add(new Parking_list(12.8736376, 79.0884481));
        list.add(new Parking_list(12.8733576, 79.0824481));
        list.add(new Parking_list(12.8736676, 79.0864481));
        list.add(new Parking_list(12.8738746, 79.0821481));
        list.add(new Parking_list(12.8738636, 79.0882581));
        list.add(new Parking_list(12.8738346, 79.0882581));
        list.add(new Parking_list(12.8738676, 79.0885681));
        int count = 0;

        for (Parking_list listlatlng : list) {

            count++;
            if (count % 2 == 0) {


                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(listlatlng.getLat(), listlatlng.getLng()))
                        .title("Parking Place")
                        .snippet("Vellore")
                        .icon(bitmapDescriptorFromVector(this, R.drawable.ic_parking_blue)));


            } else {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(listlatlng.getLat(), listlatlng.getLng()))
                        .title("Parking Place")
                        .snippet("Vellore")
                        .icon(bitmapDescriptorFromVector(this, R.drawable.ic_parking_green)));

            }

        }


        marker = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(12.8738076, 79.02644681))
                .title("Parking Place")
                .snippet("Vellore")
                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_parking)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(12.8738076, 79.0864481), 15));

        dropPinEffect(marker);

    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ic_care:
                // TODO put your code here to respond to the button tap
                startActivity(new Intent(this, ParkingMap.class));
                return true;
            case R.id.ic_bike:
                // TODO put your code here to respond to the button tap
                startActivity(new Intent(this, ParkingMap.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_map_parking, menu);
        return super.onCreateOptionsMenu(menu);
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
                    handler.postDelayed(this, 20);
                } else {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(12.8738076, 79.0864481), 15));
                    marker.setTitle(title);
                    marker.showInfoWindow();

                }
            }
        });
    }




}
