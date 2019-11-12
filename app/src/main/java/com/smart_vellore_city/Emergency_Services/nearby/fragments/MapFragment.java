package com.smart_vellore_city.Emergency_Services.nearby.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.smart_vellore_city.Emergency_Services.nearby.activities.NearBy;
import com.smart_vellore_city.Emergency_Services.nearby.adapters.MapNearByAdapter;
import com.smart_vellore_city.Emergency_Services.nearby.beans.MapNearByBean;
import com.smart_vellore_city.Emergency_Services.nearby.contracts.MapFragmentContract;
import com.smart_vellore_city.Emergency_Services.nearby.presenters.MapFragmentPresenter;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MapFragment extends Fragment implements OnMapReadyCallback,MapFragmentContract.view,MapNearByAdapter.NearByCallBack {
    //id initializations
    BottomSheetBehavior sheetBehavior;
    @BindView(R.id.bottom_sheet)
    LinearLayout layoutBottomSheet;

    @BindView(R.id.img_close)
    ImageView bootSheetClose;

    @BindView(R.id.fab_nearby_list)
    FloatingActionButton fab_nearby_list;

    @BindView(R.id.rv_nearby)
    RecyclerView rv_nearby;

    //adapters
    MapNearByAdapter mapNearByAdapter;

    //objects from other classes

    MapFragmentPresenter mapFragmentPresenter;

    List<MapNearByBean> currentList = new ArrayList<>();



    private GoogleMap mMap;
    private static final String TAG = "MapFragment";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;
    private Boolean mLocationPermissionGranted = false;
    private FusedLocationProviderClient mFusedLocationProvider;
    private String mType;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps,container,false);
        getLocationPermission();
        ButterKnife.bind(this,view);
        //Retrieve the value
        mType = getArguments().getString("type");
        initBottomSheet();
        clickFunctions();
        initRecyclerView();
        mapFragmentPresenter = new MapFragmentPresenter(this);
        mapFragmentPresenter.loadNearByRecentDatas(mType);
        return view;
    }

    private void clickFunctions() {
        bootSheetClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheetBehavior.setHideable(true);
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });
        fab_nearby_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab_nearby_list.hide();
                setAdapterFunction();
                if(sheetBehavior.getState()!=BottomSheetBehavior.STATE_EXPANDED){
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else{
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });
    }
    public void initRecyclerView(){
        rv_nearby.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (mLocationPermissionGranted) {
            getDeviceLocation();
        }
        if(mType.equalsIgnoreCase("Hospital")){
            ((NearBy) getActivity()).getSupportActionBar().setTitle("Nearby "+mType+"s");
        }else{
            ((NearBy) getActivity()).getSupportActionBar().setTitle("Nearby "+mType);
        }

        if(currentList.size()>0){
            mMap.clear();
            float iconActual = 0;
            switch(mType){
                case "Hospital":
                    iconActual = BitmapDescriptorFactory.HUE_RED;
                    break;
                case "Medicals":
                    iconActual = BitmapDescriptorFactory.HUE_GREEN;
                    break;
                case "Ambulance":
                    iconActual = BitmapDescriptorFactory.HUE_BLUE;
                    break;
                case "Blood Banks":
                    iconActual = BitmapDescriptorFactory.HUE_ORANGE;
                    break;
                case "Police Stations":
                    iconActual = BitmapDescriptorFactory.HUE_VIOLET;
                    break;
                case "Atms":
                    iconActual = BitmapDescriptorFactory.HUE_AZURE;
                    break;
                case "Banks":
                    iconActual = BitmapDescriptorFactory.HUE_ROSE;
                    break;
                case "Toilets":
                    iconActual = BitmapDescriptorFactory.HUE_MAGENTA;
                    break;
            }
            LatLngBounds.Builder builder = new LatLngBounds.Builder();

            for(int i=0;i<currentList.size();i++){
                MarkerOptions markerOptions = new MarkerOptions();
                Marker marker = mMap.addMarker(markerOptions
                        .position(new LatLng(currentList.get(i).getmLatitude(),currentList.get(i).getmLongitude()))
                        .icon(BitmapDescriptorFactory.defaultMarker(iconActual))
                        .title(currentList.get(i).getmItemName()));
                builder.include(markerOptions.getPosition());
            }

            //set zoom level
            LatLngBounds bounds = builder.build();

            //the include method will calculate the min and max bound.
            int width = getResources().getDisplayMetrics().widthPixels;
            int height = getResources().getDisplayMetrics().heightPixels;
            int padding = (int) (width * 0.10); // offset from edges of the map 10% of screen

            CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);

            mMap.animateCamera(cu);
        }
    }
    public void setMarkerOnLocations(List<MapNearByBean> MarkersList,String type){
        float icon = 0;
        if(MarkersList.size()>0){
            mMap.clear();
            switch(type){
                case "Hospital":
                    icon = BitmapDescriptorFactory.HUE_RED;
                    break;
                case "Medicals":
                    icon = BitmapDescriptorFactory.HUE_GREEN;
                    break;
                case "Ambulance":
                    icon = BitmapDescriptorFactory.HUE_BLUE;
                    break;
                case "Blood Banks":
                    icon = BitmapDescriptorFactory.HUE_ORANGE;
                    break;
                case "Police Stations":
                    icon = BitmapDescriptorFactory.HUE_VIOLET;
                    break;
                case "Atms":
                    icon = BitmapDescriptorFactory.HUE_AZURE;
                    break;
                case "Banks":
                    icon = BitmapDescriptorFactory.HUE_ROSE;
                    break;
                case "Toilets":
                    icon = BitmapDescriptorFactory.HUE_MAGENTA;
                    break;
            }
            for(int i=0;i<MarkersList.size();i++){
                MarkerOptions markerOptions = new MarkerOptions();
                Marker marker = mMap.addMarker(markerOptions
                        .position(new LatLng(MarkersList.get(i).getmLatitude(),MarkersList.get(i).getmLongitude()))
                        .icon(BitmapDescriptorFactory.defaultMarker(icon)));
            }
        }
    }
    public void getLocationPermission() {
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionGranted = true;
                initMap();
            } else {
                ActivityCompat.requestPermissions(getActivity(), permissions, LOCATION_PERMISSION_REQUEST_CODE);
            }
        } else {
            ActivityCompat.requestPermissions(getActivity(), permissions, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    public void getDeviceLocation() {
        Log.d(TAG, "get device location: getting the device current location");
        mFusedLocationProvider = LocationServices.getFusedLocationProviderClient(getActivity());
        try {
            if (mLocationPermissionGranted) {
                Task location = mFusedLocationProvider.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "On complete: found location!");
                            if(task.getResult()!=null){
                                Location currentLocation = (Location) task.getResult();
                                mMap.setMyLocationEnabled(true);
//                                moveToCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), DEFAULT_ZOOM);
                            }
                        } else {
                            Log.d(TAG, "On complete: current location is null");
                            Toast.makeText(getActivity(), "unable to get the current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        } catch (SecurityException e) {
            Log.e(TAG, "get Device location : Security Exception: " + e.getMessage());
        }
    }

    private void moveToCamera(LatLng latlng, float zoom) {
        Log.d(TAG, "move camara to : lat:" + latlng.latitude + " lng:" + latlng.longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, zoom));
    }

    public void initMap() {
        SupportMapFragment mapFragment = ((SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map));

        mapFragment.getMapAsync(this);

    }

    private void initBottomSheet() {
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setHideable(true);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        fab_nearby_list.show();
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_HIDDEN:
                        fab_nearby_list.show();
                        break;

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
               if(slideOffset == 0.0){
                   fab_nearby_list.show();
               }
            }
        });



        bootSheetClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheetBehavior.setHideable(true);
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                fab_nearby_list.show();
            }
        });

    }

    @Override
    public void setRecentNearBySearch(List<MapNearByBean> mapNearByBeanList) {
        currentList.clear();
        currentList = mapNearByBeanList;
        mapNearByAdapter = new MapNearByAdapter(mapNearByBeanList,getActivity(),this);
        rv_nearby.setAdapter(mapNearByAdapter);
    }


    public void setAdapterFunction(){
        mapNearByAdapter = new MapNearByAdapter(currentList,getActivity(),this);
        rv_nearby.setAdapter(mapNearByAdapter);
    }
    @Override
    public void clickItem(final MapNearByBean mapNearByBean) {
        if(sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
            sheetBehavior.setHideable(true);
            sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            fab_nearby_list.show();
        }
        final List<MapNearByBean> updateList = new ArrayList<>();
        updateList.addAll(currentList);
        updateList.remove(mapNearByBean);
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            public void onMapLoaded() {
                setMarkerOnLocations(updateList,mType);
                if(mType.equalsIgnoreCase("Hospital")){
                    LatLng latLng = new LatLng(mapNearByBean.getmLatitude(),mapNearByBean.getmLongitude());
                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                            .title(mapNearByBean.getmItemName()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
                    marker.showInfoWindow();
                }
                if(mType.equalsIgnoreCase("Medicals")){
                    LatLng latLng = new LatLng(mapNearByBean.getmLatitude(),mapNearByBean.getmLongitude());
                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                            .title(mapNearByBean.getmItemName()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
                    marker.showInfoWindow();
                }
                if(mType.equalsIgnoreCase("Ambulance")){
                    LatLng latLng = new LatLng(mapNearByBean.getmLatitude(),mapNearByBean.getmLongitude());
                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                            .title(mapNearByBean.getmItemName()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
                    marker.showInfoWindow();
                }
                if(mType.equalsIgnoreCase("Blood Banks")){
                    LatLng latLng = new LatLng(mapNearByBean.getmLatitude(),mapNearByBean.getmLongitude());
                   Marker marker =  mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                            .title(mapNearByBean.getmItemName()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
                    marker.showInfoWindow();
                }
                if(mType.equalsIgnoreCase("Police Stations")){
                    LatLng latLng = new LatLng(mapNearByBean.getmLatitude(),mapNearByBean.getmLongitude());
                    Marker marker =  mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
                            .title(mapNearByBean.getmItemName()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
                    marker.showInfoWindow();
                }
                if(mType.equalsIgnoreCase("Atms")){
                    LatLng latLng = new LatLng(mapNearByBean.getmLatitude(),mapNearByBean.getmLongitude());
                    Marker marker =  mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                            .title(mapNearByBean.getmItemName()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
                    marker.showInfoWindow();
                }
                if(mType.equalsIgnoreCase("Banks")){
                    LatLng latLng = new LatLng(mapNearByBean.getmLatitude(),mapNearByBean.getmLongitude());
                    Marker marker =  mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
                            .title(mapNearByBean.getmItemName()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
                    marker.showInfoWindow();
                }
                if(mType.equalsIgnoreCase("Toilets")){
                    LatLng latLng = new LatLng(mapNearByBean.getmLatitude(),mapNearByBean.getmLongitude());
                    Marker marker =  mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
                            .title(mapNearByBean.getmItemName()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
                    marker.showInfoWindow();
                }
            }
        });
    }
}
