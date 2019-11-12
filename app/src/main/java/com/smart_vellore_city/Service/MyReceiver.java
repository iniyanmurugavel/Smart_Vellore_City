package com.smart_vellore_city.Service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.smart_vellore_city.Utils.Common;

/**
 * Created by Prematix on 11/30/2017.
 */

public class MyReceiver extends BroadcastReceiver {
    static int countPowerOff = 0;
    private Service activity = null;

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.v("onReceive", "Power button is pressed.");

        System.out.println("started broadcast");

        switch (intent.getAction()) {
            case Intent.ACTION_SCREEN_OFF:
                countPowerOff++;

                if (countPowerOff == 3) {

                    if (Common.ISCALLPERMISSIONENABLED) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        callIntent.setData(Uri.parse("tel:8667651572"));
                        context.startActivity(callIntent);

                        countPowerOff = 0;
                    } else {
//                    getLocationPermission();
                    }

                }
                if (countPowerOff >= 5) {

                    countPowerOff = 0;

                    Log.v("onReceive", "Power button is pressed." + countPowerOff);

                }
                break;
            case Intent.ACTION_SCREEN_ON:
                countPowerOff++;
//            Toast.makeText(context, "power  clicked"+countPowerOff, Toast.LENGTH_LONG)
//                    .show();
//            System.out.println("started broadcast"+countPowerOff);


                if (countPowerOff == 3) {

                    if (Common.ISCALLPERMISSIONENABLED) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        callIntent.setData(Uri.parse("tel:8667651572"));
                        context.startActivity(callIntent);

                        countPowerOff = 0;

                    } else {
//                    getLocationPermission();
                    }
                }

                if (countPowerOff >= 5) {

                    countPowerOff = 0;

                    Log.v("onReceive", "Power button is pressed." + countPowerOff);
//
//                    Toast.makeText(context, "power button clicked", Toast.LENGTH_LONG)
//                            .show();

                }
                break;
            case Intent.ACTION_USER_PRESENT:
                countPowerOff++;

                Log.e("count", "---" + countPowerOff);

                if (countPowerOff == 3) {

                    if (Common.ISCALLPERMISSIONENABLED) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        callIntent.setData(Uri.parse("tel:8667651572"));
                        context.startActivity(callIntent);

                        countPowerOff = 0;

                    } else {
//                    getLocationPermission();
                    }
                }

                if (countPowerOff >= 5) {

                    countPowerOff = 0;

                    Log.v("onReceive", "Power button is pressed." + countPowerOff);

                }
                break;
        }

    }

}
