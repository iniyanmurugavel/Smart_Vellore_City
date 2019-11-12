package com.smart_vellore_city.Emergency_Services.nearby.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.smart_vellore_city.Emergency_Services.nearby.activities.NearBy;
import com.smart_vellore_city.Emergency_Services.nearby.adapters.RecentNearByAdapter;
import com.smart_vellore_city.Emergency_Services.nearby.beans.RecentNearByBean;
import com.smart_vellore_city.Emergency_Services.nearby.contracts.NearByContract;
import com.smart_vellore_city.Emergency_Services.nearby.presenters.NearByPresenter;
import com.smart_vellore_city.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapForNearBySearchFragment extends Fragment implements NearByContract.view {
    @BindView(R.id.rv_recentSearch)RecyclerView rv_recentSearch;
    @BindView(R.id.li_nearbyHospitals) LinearLayout li_nearbyHospitals;
    @BindView(R.id.li_nearbyMedicals) LinearLayout li_nearbyMedicals;
    @BindView(R.id.li_nearbyAmbulance) LinearLayout li_nearbyAmbulance;
    @BindView(R.id.li_nearbyBloodBanks) LinearLayout li_nearbyBloodBanks;
    @BindView(R.id.li_nearbypolice) LinearLayout li_nearbypolice;
    @BindView(R.id.li_nearbyatms) LinearLayout li_nearbyatms;
    @BindView(R.id.li_nearbybanks) LinearLayout li_nearbybanks;
    @BindView(R.id.li_nearbytoilets) LinearLayout li_nearbytoilets;
    RecentNearByAdapter recentNearByAdapter;

    NearByPresenter nearByPresenter;

    private String mEntryType;

    private static final String TAG = "MapForNearBySearchFragm";
    private static final int ERROR_CODE = 1234;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapfornearbysearch,container,false);
        ButterKnife.bind(this,view);
        initRecyclerView();
        nearByPresenter = new NearByPresenter(this);
        nearByPresenter.loadNearByRecentDatas();
        ((NearBy) getActivity()).getSupportActionBar().setTitle("Search Nearby");
        if(getArguments()!=null){
            mEntryType = getArguments().getString("EntryType");
            if(mEntryType!=null){
                if(mEntryType.equalsIgnoreCase("EmergencyService")){
                    li_nearbyatms.setVisibility(View.GONE);
                    li_nearbybanks.setVisibility(View.GONE);
                    li_nearbytoilets.setVisibility(View.GONE);
                }else{
                    li_nearbyatms.setVisibility(View.VISIBLE);
                    li_nearbybanks.setVisibility(View.VISIBLE);
                    li_nearbytoilets.setVisibility(View.VISIBLE);
                }
            }
        }



        clickfunctions();
        return view;
    }

    private void clickfunctions() {
        li_nearbyHospitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceOk()){
                    Fragment fragment = new MapFragment();
                    Bundle arguments = new Bundle();
                    arguments.putString("type", "Hospital");
                    fragment.setArguments(arguments);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

            }
        });
        li_nearbyMedicals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceOk()){
                    Fragment fragment = new MapFragment();
                    Bundle arguments = new Bundle();
                    arguments.putString("type", "Medicals");
                    fragment.setArguments(arguments);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        li_nearbyAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceOk()){
                    Fragment fragment = new MapFragment();
                    Bundle arguments = new Bundle();
                    arguments.putString("type", "Ambulance");
                    fragment.setArguments(arguments);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        li_nearbyBloodBanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceOk()){
                    Fragment fragment = new MapFragment();
                    Bundle arguments = new Bundle();
                    arguments.putString("type", "Blood Banks");
                    fragment.setArguments(arguments);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        li_nearbypolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceOk()){
                    Fragment fragment = new MapFragment();
                    Bundle arguments = new Bundle();
                    arguments.putString("type", "Police Stations");
                    fragment.setArguments(arguments);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        li_nearbyatms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceOk()){
                    Fragment fragment = new MapFragment();
                    Bundle arguments = new Bundle();
                    arguments.putString("type", "Atms");
                    fragment.setArguments(arguments);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        li_nearbybanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceOk()){
                    Fragment fragment = new MapFragment();
                    Bundle arguments = new Bundle();
                    arguments.putString("type", "Banks");
                    fragment.setArguments(arguments);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        li_nearbytoilets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceOk()){
                    Fragment fragment = new MapFragment();
                    Bundle arguments = new Bundle();
                    arguments.putString("type", "Toilets");
                    fragment.setArguments(arguments);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
    }

    public void initRecyclerView(){
        rv_recentSearch.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    public boolean isServiceOk(){
        Log.d(TAG,"checking connection!");
        int availability = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getActivity());
        if(availability == ConnectionResult.SUCCESS){
            Log.e("sucess","Service working");
            return true;
        }else if(GoogleApiAvailability.getInstance().isUserResolvableError(availability)){
            Log.e("service ok","but some error occur we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(getActivity(),availability,ERROR_CODE);
            dialog.show();
        }else{
            Toast.makeText(getActivity(), "you can't make request", Toast.LENGTH_SHORT).show();
        }
        return false;

    }
    @Override
    public void setRecentNearBySearch(List<RecentNearByBean> recentNearByBeanList) {
        recentNearByAdapter = new RecentNearByAdapter(recentNearByBeanList,getActivity());
        rv_recentSearch.setAdapter(recentNearByAdapter);
    }


}
