package com.smart_vellore_city.wifi;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment_Wifi extends Fragment {

    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 125;
    List<ScanResult> wifiList;
    private WifiManager wifi;
    List<Model_Device> values = new ArrayList<>();
    int netCount=0;
    RecyclerView recyclerView;
    Adapter_WifiScan wifiScanAdapter;
    RelativeLayout rootLayout;


    public static Fragment_Wifi getInstance(){
        return new Fragment_Wifi();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wifi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootLayout = view.findViewById(R.id.rootlayout);

    }

     /*check if wifi enabled or not . If not connected enable wifi.
     *  Register the broadcast receiver
     *  get and show the list of available networks */

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        wifi = (WifiManager) getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        //Check wifi enabled or not
        if (!wifi.isWifiEnabled())
        {
            showSnackbar("Wifi is disabled enabling...");
            wifi.setWifiEnabled(true);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkandAskPermission();
        }

         getActivity().registerReceiver(new Receiver_WifiScanResults(),new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

        wifiScanAdapter=new Adapter_WifiScan(values,getContext());
        recyclerView= getActivity().findViewById(R.id.wifiRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(wifiScanAdapter);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS: {
                Map<String, Integer> perms = new HashMap<>();
                perms.put(Manifest.permission.ACCESS_COARSE_LOCATION, PackageManager.PERMISSION_GRANTED);
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                if (perms.get(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    wifi.startScan();
                } else {
                    // Permission Denied
                    showSnackbar("Some Permission is Denied");

                }
            }
        }
    }

    private void checkandAskPermission() {
        List<String> permissionsNeeded = new ArrayList<>();

        final List<String> permissionsList = new ArrayList<>();
        if (!addPermission(permissionsList))
            permissionsNeeded.add("Network");


        if (permissionsList.size() > 0) {
            if (permissionsNeeded.size() > 0) {
                StringBuilder message = new StringBuilder("You need to grant access to " + permissionsNeeded.get(0));
                for (int i = 0; i < permissionsNeeded.size(); i++)
                    message.append(", ").append(permissionsNeeded.get(i));
                showMessageOKCancel(message.toString(),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                requestPermissions(permissionsList.toArray(new String[0]),
                                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
                            }
                        });
                return;
            }
            requestPermissions(permissionsList.toArray(new String[0]),
                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
        }

    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(getActivity())
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", okListener)
                .create()
                .show();
    }

    private boolean addPermission(List<String> permissionsList) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getActivity().checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
                return shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
        }
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(new Receiver_WifiScanResults(),new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
    }

    @Override
    public void onPause() {
        super.onPause();
        try{
          getActivity().unregisterReceiver(new Receiver_WifiScanResults());
        }catch(Exception e){
            getActivity().registerReceiver(new Receiver_WifiScanResults(),new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        }
    }

    // broadcast receiver to get available wifi networks
    public class Receiver_WifiScanResults extends BroadcastReceiver{

            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {

                    wifiList = wifi.getScanResults();
                    netCount = wifiList.size();
                    wifi.startScan();
                    values.clear();
                    try {
                        netCount = netCount - 1;
                        while (netCount >= 0) {
                            Model_Device d = new Model_Device();
                            d.setName(wifiList.get(netCount).SSID);
                            if(!d.getName().equalsIgnoreCase("")) {
                                values.add(d);
                            }
                            wifiScanAdapter.notifyDataSetChanged();
                            netCount=netCount -1;
                        }
                    }
                    catch (Exception e){
                      showSnackbar(e.toString());
                    }
                    wifiScanAdapter.notifyDataSetChanged();

                }
            }
        }

        private void showSnackbar(String msg){
           Snackbar.make(rootLayout,msg,Snackbar.LENGTH_SHORT).show();
        }

}
