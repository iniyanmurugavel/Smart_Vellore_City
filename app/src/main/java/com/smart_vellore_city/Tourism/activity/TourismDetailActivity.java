package com.smart_vellore_city.Tourism.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.smart_vellore_city.R;
import com.smart_vellore_city.Tourism.adapter.TourismPagerAdapter;
import com.smart_vellore_city.Tourism.model.TourismSitesPojo;

import java.util.Objects;

/**
 * Created by Priyadharshini on 15-11-2018.
 */

public class TourismDetailActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private TextView tv_name, tv_subTitle, tv_reviews, tv_address, tv_review_summary, tv_desc;
    private RatingBar ratingBar;
    private FloatingActionButton fab_direction;
    private LinearLayout slider_dots;
    private Toolbar toolbar;
    private int dotcounts;
    private ImageView[] dots;
    private TourismPagerAdapter pagerAdapter;
    private String sName, sSubTitle, sDescription, sAddress, sRatings, sReview, sReviewSummary;
    private String Image1, Image2, Image3, Image4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourism_details);


        pagerAdapter = new TourismPagerAdapter(this);

        initializeToolbarAndViews();
        indicator();
        getAllPojoValues();
    }


    /**
     * ss
     * Initializing Toolbar and all views
     */
    private void initializeToolbarAndViews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewpager = (ViewPager) findViewById(R.id.viewpager);

        tv_name = (TextView) findViewById(R.id.name);
        tv_subTitle = (TextView) findViewById(R.id.subTitle);
        tv_reviews = (TextView) findViewById(R.id.reviews);
        tv_address = (TextView) findViewById(R.id.address);
        tv_review_summary = (TextView) findViewById(R.id.review_summary);
        tv_desc = (TextView) findViewById(R.id.desc);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        fab_direction = (FloatingActionButton) findViewById(R.id.fab_direction);

        slider_dots = (LinearLayout) findViewById(R.id.slider_dots);


        viewpager.setAdapter(pagerAdapter);

        dotcounts = pagerAdapter.getCount();


        fab_direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TourismDetailActivity.this, TourismMapsActivity.class);
                i.putExtra("title", sName);
                startActivity(i);
            }
        });


    }


    public void indicator() {
        dots = new ImageView[dotcounts];

        for (int i = 0; i < dotcounts; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dots));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            slider_dots.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dots));

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotcounts; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dots));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dots));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void getAllPojoValues() {
        //collect our intent
        Intent intent = getIntent();
        TourismSitesPojo pojo = intent.getParcelableExtra("TourismSitesPojo");

        //now collect all values
        sName = pojo.getName();
        sSubTitle = pojo.getSubTitle();
        sDescription = pojo.getDescription();
        sAddress = pojo.getAddress();
        sRatings = pojo.getRatings();
        Image1 = pojo.getImage1();
        Image2 = pojo.getImage2();
        Image3 = pojo.getImage3();
        Image4 = pojo.getImage4();
        sReview = pojo.getReview();
        sReviewSummary = pojo.getReviewSummary();


        toolbar.setTitle(sName);
        tv_name.setText(sName);
        tv_subTitle.setText(sSubTitle);
        tv_desc.setText(sDescription);
        tv_address.setText("Address : " + sAddress);
        tv_reviews.setText(sReview + " reviews");
        tv_review_summary.setText(sReviewSummary);
        ratingBar.setRating(Float.parseFloat(sRatings));


    }


}
