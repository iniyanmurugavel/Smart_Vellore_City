package com.smart_vellore_city.wifi;


import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.smart_vellore_city.R;
import java.util.Objects;

public class Activity_Wifi extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    SwitchCompat switchCompat;
    TextView toggleText;
    Fragment fragmentWifi;
    WifiManager wifiManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("NEARBY WIFI");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        switchCompat = findViewById(R.id.wifiSwitch);
        toggleText = findViewById(R.id.toggleText);
        switchCompat.setOnCheckedChangeListener(this);
        wifiManager = (WifiManager)getApplicationContext(). getSystemService(Context.WIFI_SERVICE);

       if(wifiManager.isWifiEnabled()){
           switchCompat.setChecked(true);
           EnableWiFi();

       }else{
           switchCompat.setChecked(false);
       }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
          if(isChecked){
              EnableWiFi();
          }else{
              DisableWiFi();
          }
    }

    public void EnableWiFi(){
        toggleText.setText("WIFI ON");
        wifiManager.setWifiEnabled(true);
        fragmentWifi = Fragment_Wifi.getInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.containerWifi,fragmentWifi);
        ft.commit();
    }

    public void DisableWiFi(){
        toggleText.setText("WIFI OFF");
        wifiManager.setWifiEnabled(false);
        finish();
    }

}
