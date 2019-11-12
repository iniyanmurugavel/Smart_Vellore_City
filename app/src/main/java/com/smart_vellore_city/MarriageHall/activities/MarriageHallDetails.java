package com.smart_vellore_city.MarriageHall.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.smart_vellore_city.MarriageHall.beans.MhallBean;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Utils.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarriageHallDetails extends AppCompatActivity {
@BindView(R.id.anim_toolbar)Toolbar anim_toolbar;
@BindView(R.id.header)ImageView header;
@BindView(R.id.tv_hallname)TextView tv_hallname;
@BindView(R.id.tv_address)TextView tv_address;
@BindView(R.id.tv_rating)TextView tv_rating;
@BindView(R.id.tv_package)TextView tv_package;
@BindView(R.id.tv_booknow)TextView tv_booknow;
@BindView(R.id.fab_locate_me)FloatingActionButton fab_locate_me;
MhallBean mhallBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_for_marriage);
        ButterKnife.bind(this);
        anim_toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        anim_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        Intent i = getIntent();
        mhallBean = (MhallBean)i.getSerializableExtra("MhallBean");
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(mhallBean.getmItemName());
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });
        setValues();
        clickFunctions();
    }

    private void clickFunctions() {
        fab_locate_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHall = new Intent(MarriageHallDetails.this,MarriageHappMapActivity.class);
                moveToHall.putExtra("MhallBean",mhallBean);
                startActivity(moveToHall);
            }
        });
        tv_booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHall = new Intent(MarriageHallDetails.this,MarriageHallBookingActivity.class);
                moveToHall.putExtra("MhallBean",mhallBean);
                startActivity(moveToHall);
            }
        });
    }

    private void setValues(){
        GlideApp
                .with(this)
                .load(mhallBean.getmImgUrl())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.ic_school)
                        .fitCenter())
                .into(header);
        tv_hallname.setText(mhallBean.getmItemName());
        tv_rating.setText(mhallBean.getmItemRating()+" / 5.0");
        tv_address.setText(mhallBean.getmAddress());
        tv_package.setText("₹ "+mhallBean.getmItemBaseRate()+" / Per Day");

    }
}
