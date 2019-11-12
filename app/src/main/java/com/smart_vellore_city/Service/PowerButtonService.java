package com.smart_vellore_city.Service;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.smart_vellore_city.R;

import java.util.Calendar;

public class PowerButtonService extends Service {

    Intent service;
    private Camera mServiceCamera        = null;
    private SurfaceHolder mSurfaceHolder = null;
    MediaRecorder mMediaRecorder;
    String Reason;
    boolean mRecordingStatus=false;
    public PowerButtonService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();


        LinearLayout mLinear = new LinearLayout(getApplicationContext()) {

            //            //home or recent button
            public void onCloseSystemDialogs(String reason) {
                if ("globalactions".equals(reason)) {
                    Log.i("Key", "Long press on power button");
                    Log.e("My","add any action");

                    Reason = reason;
                    Calendar cal = Calendar.getInstance();

//                    service = new Intent(getBaseContext(), CapPhoto.class);
//                    cal.add(Calendar.SECOND, 15);
//                    startService(new Intent(getApplicationContext(), CapPhoto.class));

//                boolean media=    starMediaRecording();
//
//
//                if(media){
//                    final Handler   handler = new Handler();
//
//                    final Runnable r = new Runnable() {
//                        public void run() {
//
//                            handler.postDelayed(this, 1000);
//                            stopMediaRecorder();
//                        }
//                    };
//
//                    handler.postDelayed(r, 1000);
//                }
                    // stopService(new Intent(getApplicationContext(),PowerButtonService.class));
                } else if ("homekey".equals(reason)) {
                    //home key pressed
                    Log.e("Home key","--Pressed---");

                } else if ("recentapss".equals(reason)) {
                    // recent apps button clicked
                    Log.e("Recentapp key","--Pressed---");
                }
            }

            @Override
            public boolean onKeyLongPress(int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_POWER) {
                    // Here we can detect long press of power button
                    return true;
                }
                return super.onKeyLongPress(keyCode, event);
            }
        };

        mLinear.setFocusable(true);

        View mView = LayoutInflater.from(this).inflate(R.layout.service_layout, mLinear);
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);

        //params
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                100,
                100,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_FULLSCREEN
                        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                        | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.LEFT | Gravity.CENTER_VERTICAL;
        wm.addView(mView, params);
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
