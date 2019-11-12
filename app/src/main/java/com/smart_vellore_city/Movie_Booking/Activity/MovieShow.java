package com.smart_vellore_city.Movie_Booking.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.smart_vellore_city.Movie_Booking.Adapter.MovieReviewAdapter;
import com.smart_vellore_city.Movie_Booking.Adapter.RelatedMoviesAdapter;
import com.smart_vellore_city.Movie_Booking.Bean.MovieReviewBean;
import com.smart_vellore_city.Movie_Booking.Bean.RelatedMoviesBean;
import com.smart_vellore_city.Movie_Booking.MovieFragment.EnglishMovieFragment;
import com.smart_vellore_city.Movie_Booking.MovieFragment.TamilMovieFragment;
import com.smart_vellore_city.Movie_Booking.MovieFragment.TeluguMovieFragment;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10-06-2017.
 */

public class MovieShow extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    Animation rotateOpen,rotateClose,fabOpen,fabClose,fabHide;
    FloatingActionButton fabSwing,fab3D,fab2D,fab4DX,fabIMAX,fabChat;
    boolean isOpen = false;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    List<RelatedMoviesBean> beanList;
    RelatedMoviesAdapter adapter;

    RecyclerView reviewRecycler;
    List<MovieReviewBean> beanListReview;
    MovieReviewAdapter reviewAdapter;
    RecyclerView.LayoutManager reviewManager;
    Button bookNow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movieshow);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapse = (CollapsingToolbarLayout)findViewById(R.id.collapse);
        collapse.setTitle("Sarkar");
        collapse.setExpandedTitleTextAppearance(R.style.collapse);
        AppBarLayout appbar = (AppBarLayout)findViewById(R.id.appbar);
        bookNow = (Button)findViewById(R.id.bookNow_btn);
        bookNow.setOnClickListener(this);
        rotateOpen = AnimationUtils.loadAnimation(this,R.anim.rotate_open);
        rotateClose = AnimationUtils.loadAnimation(this,R.anim.rotate_close);
        fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close);
        fabHide = AnimationUtils.loadAnimation(this,R.anim.fab_hide);

        fab2D = (FloatingActionButton)findViewById(R.id.twod);
        fab3D = (FloatingActionButton)findViewById(R.id.threed);
        fab4DX = (FloatingActionButton)findViewById(R.id.fourdx);
        fabIMAX = (FloatingActionButton)findViewById(R.id.imax3d);
        fabChat = (FloatingActionButton)findViewById(R.id.chat);

        fabSwing = (FloatingActionButton)findViewById(R.id.swing);
        fabSwing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen){
                    fabSwing.startAnimation(rotateClose);
                    fab2D.startAnimation(fabClose);
                    fab3D.startAnimation(fabClose);
                    fab4DX.startAnimation(fabClose);
                    fabIMAX.startAnimation(fabClose);
                    fabChat.startAnimation(fabClose);

                    isOpen = false;
                }else{
                    fabSwing.startAnimation(rotateOpen);
                    fab2D.startAnimation(fabOpen);
                    fab3D.startAnimation(fabOpen);
                    fab4DX.startAnimation(fabOpen);
                    fabIMAX.startAnimation(fabOpen);
                    fabChat.startAnimation(fabOpen);

                    isOpen = true;
                }
            }
        });

        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                fab2D.startAnimation(fabHide);
                fab3D.startAnimation(fabHide);
                fab4DX.startAnimation(fabHide);
                fabIMAX.startAnimation(fabHide);
                fabChat.startAnimation(fabHide);
                isOpen = false;
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.related_movies);
        if (recyclerView != null){
            recyclerView.setHasFixedSize(true);
        }

        manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(manager);

        beanList = new ArrayList<>();

        for (int i = 0; i< TamilMovieFragment.names.length; i++){
            RelatedMoviesBean bean = new RelatedMoviesBean(TamilMovieFragment.names[i],TamilMovieFragment.images[i],"Tamil");
            beanList.add(bean);
            if (EnglishMovieFragment.images.length > i){
                RelatedMoviesBean bean1 = new RelatedMoviesBean(EnglishMovieFragment.title[i],EnglishMovieFragment.images[i],"English");
                beanList.add(bean1);
            }
            if (TeluguMovieFragment.images.length > i){
                RelatedMoviesBean bean2 = new RelatedMoviesBean(TeluguMovieFragment.title[i],TeluguMovieFragment.images[i],"Telugu");
                beanList.add(bean2);
            }
        }

        adapter = new RelatedMoviesAdapter(beanList,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setNestedScrollingEnabled(false);

        reviewRecycler = (RecyclerView)findViewById(R.id.reviews);
        if (reviewRecycler != null){
            reviewRecycler.setHasFixedSize(true);
        }

        reviewManager = new LinearLayoutManager(this);
        reviewRecycler.setLayoutManager(reviewManager);
        beanListReview = new ArrayList<>();
        String names[] = {"Ashok","Priya","Revathi","Arjun","Iniyan"};
        for (int i=0;i<5;i++){
            MovieReviewBean bean = new MovieReviewBean(names[i],getResources().getString(R.string.review));
            beanListReview.add(bean);
        }

        reviewAdapter = new MovieReviewAdapter(beanListReview);
        reviewRecycler.setAdapter(reviewAdapter);
        reviewAdapter.notifyDataSetChanged();
        reviewRecycler.setNestedScrollingEnabled(false);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bookNow_btn){
            Intent intent = new Intent(MovieShow.this,SeatSelect.class);
            startActivity(intent);
        }
    }
}
