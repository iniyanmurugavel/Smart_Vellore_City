package com.smart_vellore_city.Registration.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.smart_vellore_city.R;
import com.smart_vellore_city.Registration.fragments.Registration;
import com.smart_vellore_city.Utils.Common;
import com.smart_vellore_city.dashboard.NewDashBoard;


public class RegistrationLoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_login);
        SharedPreferences sharedPreferences = getSharedPreferences(Common.USER_PREF_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences!=null){
            if(sharedPreferences.getString("userName",null)!=null && sharedPreferences.getString("userMobileNo",null)!=null){
                Intent moveToHomeActivity = new Intent(RegistrationLoginActivity.this,NewDashBoard.class);
                startActivity(moveToHomeActivity);
                finish();
            }else{
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container,new Registration())
                        .commit();
            }
        }

    }
}
