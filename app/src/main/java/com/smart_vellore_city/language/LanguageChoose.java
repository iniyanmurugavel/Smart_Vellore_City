package com.smart_vellore_city.language;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smart_vellore_city.R;
import com.smart_vellore_city.dashboard.NewDashBoard;

public class LanguageChoose extends AppCompatActivity {
    ImageView img_english, img_tamil;
    TextView tv_english, tv_tamil, language_set, language_notnow;
    LinearLayout li_english_lay, li_tamil_lay;
    String selectedLanguages = "English";
    String mLanguageCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_choose);
        img_english = findViewById(R.id.img_english);
        img_tamil = findViewById(R.id.img_tamil);

        tv_english = findViewById(R.id.tv_english);
        tv_tamil = findViewById(R.id.tv_tamil);
        language_set = findViewById(R.id.language_set);

        li_english_lay = findViewById(R.id.li_english_lay);
        li_tamil_lay = findViewById(R.id.li_tamil_lay);
        language_notnow = findViewById(R.id.language_notnow);

        li_english_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_english.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                img_english.setImageDrawable(getResources().getDrawable(R.drawable.ic_checked));
                tv_tamil.setTextColor(getResources().getColor(R.color.black));
                img_tamil.setImageDrawable(getResources().getDrawable(R.drawable.ic_un_checked));
                selectedLanguages = "English";
            }
        });
        li_tamil_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_tamil.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                img_tamil.setImageDrawable(getResources().getDrawable(R.drawable.ic_checked));
                tv_english.setTextColor(getResources().getColor(R.color.black));
                img_english.setImageDrawable(getResources().getDrawable(R.drawable.ic_un_checked));
                selectedLanguages = "தமிழ்";
                //Change Application level locale

            }
        });
        language_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedLanguages.equalsIgnoreCase("English")) {
                    mLanguageCode = "en";
                    LocaleHelper.setLocale(LanguageChoose.this, mLanguageCode);
                } else if (selectedLanguages.equalsIgnoreCase("தமிழ்")) {
                    mLanguageCode = "ta";
                    LocaleHelper.setLocale(LanguageChoose.this, mLanguageCode);
                }

                Intent moveToHomeActivity = new Intent(LanguageChoose.this, NewDashBoard.class);
                startActivity(moveToHomeActivity);
                finish();

                Log.e("mLanguage Selected", "------ " + mLanguageCode);
            }
        });

       language_notnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mLanguageCode = "en";
                LocaleHelper.setLocale(LanguageChoose.this, mLanguageCode);

                Intent moveToHomeActivity = new Intent(LanguageChoose.this, NewDashBoard.class);
                startActivity(moveToHomeActivity);
                finish();

                Toast.makeText(LanguageChoose.this, "Default Language Set... You can set language later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
