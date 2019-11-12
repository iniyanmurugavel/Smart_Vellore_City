package com.smart_vellore_city.Digilocker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.andrognito.patternlockview.utils.ResourceUtils;
import com.smart_vellore_city.R;

import java.util.List;

public class PatternLock extends AppCompatActivity {

    private PatternLockView mPatternLockView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Draw Pattern");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPatternLockView = (PatternLockView) findViewById(R.id.pattern_lock_view);
        mPatternLockView.addPatternLockListener(mPatternLockViewListener);

    }

    private PatternLockViewListener mPatternLockViewListener = new PatternLockViewListener() {
        @Override
        public void onStarted() {
            Log.d(getClass().getName(), "Pattern drawing started");
        }

        @Override
        public void onProgress(List<PatternLockView.Dot> progressPattern) {
            Log.d(getClass().getName(), "Pattern progress: " +
                    PatternLockUtils.patternToString(mPatternLockView, progressPattern));
        }

        @Override
        public void onComplete(List<PatternLockView.Dot> pattern) {

//            if (PatternLockUtils.patternToString(mPatternLockView, pattern).equals(147)){
                mPatternLockView.setCorrectStateColor(ResourceUtils.getColor(getApplicationContext(), R.color.green));
                Intent i = new Intent(getApplicationContext(),DigiLocker.class);
                startActivity(i);
//            }else {
//                mPatternLockView.setWrongStateColor(ResourceUtils.getColor(getApplicationContext(), R.color.pomegranate));
//                Toast.makeText(getApplicationContext(),"Incorrect Pattern",Toast.LENGTH_SHORT).show();
//            }


            Log.d(getClass().getName(), "Pattern complete: " +
                    PatternLockUtils.patternToString(mPatternLockView, pattern));
        }

        @Override
        public void onCleared() {
            Log.d(getClass().getName(), "Pattern has been cleared");
        }
    };
}
