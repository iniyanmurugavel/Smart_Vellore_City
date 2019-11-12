package com.smart_vellore_city.wifi;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smart_vellore_city.R;

import java.util.List;



public class Adapter_WifiScan  extends RecyclerView.Adapter{
    private List<Model_Device> wifiList;
    private Context context;


    public Adapter_WifiScan(List<Model_Device> wifiList, Context context) {
        this.wifiList = wifiList;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.itemview_wifilist, viewGroup, false);

        VideoViewHolder holder = new VideoViewHolder(itemView);
        itemView.setTag(holder);

        return holder;

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        int position = holder.getAdapterPosition();

        Model_Device device=wifiList.get(position);
        final String name=device.getName();

        ((VideoViewHolder) holder).vName.setText(name);


        ((VideoViewHolder) holder).vImage.setImageResource(R.drawable.ic_network_wifi_black_24dp);
        ((VideoViewHolder) holder).context = context;
        ((VideoViewHolder) holder).position = position;

        ((VideoViewHolder) holder).vName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog(name);
            }
        });
    }
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public int getItemCount() {

          return wifiList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView vImage;
        TextView vName;
        Context context;
        int position;


        VideoViewHolder(View v) {
            super(v);
            vName =  v.findViewById(R.id.ssid_name);
            vImage =  v.findViewById(R.id.wifiLogo);
        }
    }

    private void connectToWifi(String ssid,String passkey){
        WifiConfiguration wifiConfig = new WifiConfiguration();
        wifiConfig.SSID = String.format("\"%s\"", ssid);
        wifiConfig.preSharedKey = String.format("\"%s\"", passkey);

        WifiManager wifiManager = (WifiManager)context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        //remember id
        int netId = wifiManager.addNetwork(wifiConfig);
        wifiManager.disconnect();
        wifiManager.enableNetwork(netId, true);
        wifiManager.reconnect();

    }

    private void showAlertDialog(final String ssid){
        LinearLayout parent = new LinearLayout(context);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_connectwifi,parent,false);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(view);
        final AlertDialog dialog = alertDialogBuilder.create();

        final AppCompatEditText passkey_et = view.findViewById(R.id.passkey_et);
        final TextView ssidName = view.findViewById(R.id.ssidName);
        Button connect_btn = view.findViewById(R.id.connect_btn);
        Button cancel_btn = view.findViewById(R.id.cancel_btn);
        ssidName.setText(ssid);
        connect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(passkey_et.getText())) {
                    passkey_et.setError("Enter Password");
                }else {
                    connectToWifi(ssid, passkey_et.getText().toString().trim());
                    dialog.dismiss();
                }
            }
        });
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}
