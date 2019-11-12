package com.smart_vellore_city.Tourism.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.smart_vellore_city.R;
import com.smart_vellore_city.Tourism.adapter.TourismSitesAdapter;
import com.smart_vellore_city.Tourism.interfaces.ITourismHomeContract;
import com.smart_vellore_city.Tourism.interfaces.RecyclerItemClickListener;
import com.smart_vellore_city.Tourism.model.TourismSitesPojo;
import com.smart_vellore_city.Tourism.plan_trip.PlanTripActivity;
import com.smart_vellore_city.Tourism.presenters.TourismPresenter;
import com.smart_vellore_city.Tourism.presenters.TourismPresenterImp;

import java.util.ArrayList;
import java.util.Objects;

public class TourismHomeActivity extends AppCompatActivity implements ITourismHomeContract.ITourismView {

    private RecyclerView recyclerView;

    private ProgressBar progressBar;

    private ITourismHomeContract.ITourSitesPojo pojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_home);


        initializeToolbarAndRecyclerView();
        initProgressBar();

        pojo = new TourismPresenter(this, new TourismPresenterImp());
        pojo.onRequestData();

    }

    /**
     * Initializing Toolbar and RecyclerView
     */
    private void initializeToolbarAndRecyclerView() {

        Toolbar toolbar = findViewById(R.id.toolbar_);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Tourism");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.tourism_rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TourismHomeActivity.this);
        recyclerView.setLayoutManager(layoutManager);


    }


    /**
     * Initializing progressbar programmatically
     */
    private void initProgressBar() {

        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER);
        relativeLayout.addView(progressBar);

        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        progressBar.setVisibility(View.INVISIBLE);

        this.addContentView(relativeLayout, params);
    }


    private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick(TourismSitesPojo pojo) {
            Toast.makeText(TourismHomeActivity.this, "" + pojo.getName(), Toast.LENGTH_SHORT).show();

            Intent i = new Intent(TourismHomeActivity.this, TourismDetailActivity.class);
            i.putExtra("TourismSitesPojo", pojo);
            startActivity(i);
        }
    };


    @Override
    public void showProgress() {

        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(ArrayList<TourismSitesPojo> pojo) {
        TourismSitesAdapter adapter = new TourismSitesAdapter(pojo, recyclerItemClickListener,this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(TourismHomeActivity.this,
                "Error : " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tourism_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.more: {
                Intent i = new Intent(this, PlanTripActivity.class);
                startActivity(i);
                finish();
                break;
            }
            // case blocks for other MenuItems (if any)
        }
        return true;
    }

}
