package com.smart_vellore_city.Movie_Booking.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.smart_vellore_city.Movie_Booking.Adapter.HomeMoviesAdapter;
import com.smart_vellore_city.Movie_Booking.Adapter.ImageSlideViewPagerAdapter;
import com.smart_vellore_city.Movie_Booking.Bean.HomeBean;
import com.smart_vellore_city.Movie_Booking.MovieFragment.EnglishMovieFragment;
import com.smart_vellore_city.Movie_Booking.MovieFragment.TamilMovieFragment;
import com.smart_vellore_city.Movie_Booking.MovieFragment.TeluguMovieFragment;
import com.smart_vellore_city.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by admin on 06-06-2017.
 */

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    List<HomeBean> beanList;
    HomeMoviesAdapter adapter;

    ViewPager viewPager;
    LinearLayout dotLayout;
    private int dotcount;
    private ImageView[] dots;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Movies");
        viewPager = (ViewPager)findViewById(R.id.viewPage);

        ImageSlideViewPagerAdapter imageAdapter = new ImageSlideViewPagerAdapter(this);
        viewPager.setAdapter(imageAdapter);
        Timer timer = new Timer();
        timer.schedule(new MyTime(),1000,2000);

        dotLayout = (LinearLayout)findViewById(R.id.dots);
        dotcount = imageAdapter.getCount();
        dots = new ImageView[dotcount];

        for (int i=0;i<dotcount;i++){
            dots[i] = new ImageView(this);
            dots[i].setImageResource(R.drawable.non_active_dot);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            params.setMargins(8,10,8,8);
            dotLayout.addView(dots[i],params);
        }

        dots[0].setImageResource(R.drawable.active_dot);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<dotcount;i++){
                    dots[i].setImageResource(R.drawable.non_active_dot);
                }

                dots[position].setImageResource(R.drawable.active_dot);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.my_recycler);
        recyclerView.setNestedScrollingEnabled(false);
        if (recyclerView != null){
            recyclerView.setHasFixedSize(true);
        }

        manager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(manager);

        beanList = new ArrayList<>();

        for (int i = 0; i< TamilMovieFragment.names.length; i++){
            HomeBean bean = new HomeBean(TamilMovieFragment.images[i],TamilMovieFragment.names[i],"Tamil");
            beanList.add(bean);
            if (EnglishMovieFragment.images.length > i){
                HomeBean bean1 = new HomeBean(EnglishMovieFragment.images[i],EnglishMovieFragment.title[i],"English");
                beanList.add(bean1);
            }
            if (TeluguMovieFragment.images.length > i){
                HomeBean bean2 = new HomeBean(TeluguMovieFragment.images[i],TeluguMovieFragment.title[i],"Telugu");
                beanList.add(bean2);
            }
        }

        adapter = new HomeMoviesAdapter(beanList,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.addOnItemTouchListener(new RecyclerClickListener(this, new RecyclerClickListener.OnItemTouchListener() {
            @Override
            public void OnItemCLikc(View view, int position) {
                Intent intent = new Intent(Home.this,MovieShow.class);
                startActivity(intent);
            }
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_movie,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify transport_filter parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.movies) {
            Intent i = new Intent(this,Movies.class);
            startActivity(i);
        }
        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    public class MyTime extends TimerTask {

        @Override
        public void run() {
            Home.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    }else if (viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }else if (viewPager.getCurrentItem() == 2){
                        viewPager.setCurrentItem(3);
                    }else if (viewPager.getCurrentItem() == 3){
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

    public JSONObject JSONTest(){
        JSONObject jsonObject = new JSONObject();
        try {
            JSONObject job = new JSONObject();
            job.put("Title","One");
            job.put("URL","imageURl");
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(job);
            jsonObject.put("Movies",jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
