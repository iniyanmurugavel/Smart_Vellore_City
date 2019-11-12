package com.smart_vellore_city.Movie_Booking.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.smart_vellore_city.R;

/**
 * Created by admin on 06-06-2017.
 */

public class LanguageSelect extends AppCompatActivity implements View.OnClickListener {
    Button btnTamil,btnEnglish,btnTelugu,btnKannada,btnHindi;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_select);

        pref  = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Select Languages");
        btnTamil = (Button)findViewById(R.id.tamil);
        btnEnglish = (Button)findViewById(R.id.english);
        btnTelugu = (Button)findViewById(R.id.telugu);
        btnHindi = (Button)findViewById(R.id.hindi);
        btnKannada = (Button)findViewById(R.id.kannada);

        btnTamil.setOnClickListener(this);
        btnHindi.setOnClickListener(this);
        btnEnglish.setOnClickListener(this);
        btnTelugu.setOnClickListener(this);
        btnKannada.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = pref.edit();
        Intent intent;
        if(v.getId() == R.id.tamil){

            editor.putString(Shared.LANGUAGE,"Tamil");
            Toast.makeText(this,"Tamil",Toast.LENGTH_LONG).show();
        }else if (v.getId() == R.id.english){
            editor.putString(Shared.LANGUAGE,"English");
            Toast.makeText(this,"English",Toast.LENGTH_LONG).show();
        }else if (v.getId() == R.id.telugu){
            editor.putString(Shared.LANGUAGE,"Telugu");
            Toast.makeText(this,"Telugu",Toast.LENGTH_LONG).show();
        }else if (v.getId() == R.id.kannada){
            editor.putString(Shared.LANGUAGE,"Kannada");
            Toast.makeText(this,"Kannada",Toast.LENGTH_LONG).show();
        }else if (v.getId() == R.id.hindi){
            editor.putString(Shared.LANGUAGE,"Hindi");
            Toast.makeText(this,"Hindi",Toast.LENGTH_LONG).show();
        }
        intent = new Intent(this,Home.class);
        startActivity(intent);
        editor.commit();
    }
}
