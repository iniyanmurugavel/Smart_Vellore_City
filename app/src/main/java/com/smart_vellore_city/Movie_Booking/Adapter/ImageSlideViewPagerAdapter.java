package com.smart_vellore_city.Movie_Booking.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smart_vellore_city.R;

/**
 * Created by admin on 09-06-2017.
 */

public class ImageSlideViewPagerAdapter extends PagerAdapter {
    private Context context;
    LayoutInflater layoutInflater;
    private String images[] = {
            "https://1.bp.blogspot.com/-9Pc93hnpP4E/Wlrwky7HKwI/AAAAAAAAAmo/8xc9mcEanzID5l3gcCNugTLR3Z7HrwCrgCLcBGAs/s1600/Samson-movie.jpg",
            "https://in.bmscdn.com/iedb/movies/images/website/poster/large/taxiwala-et00070814-12-02-2018-11-11-47.jpg",
            "https://www.filmibeat.com/img/220x100x275/popcorn/movie_posters/sarkar-20181025150339-16499.jpg",
            "https://i.ytimg.com/vi/DDWPxs8zTzg/maxresdefault.jpg"
    };



    public ImageSlideViewPagerAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_image_slider,null);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageSlider);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
         Glide.with(context).load(images[position]).thumbnail(0.5f)
                .into(imageView);
        ViewPager vp = (ViewPager)container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager)container;
        View view = (View)object;
        vp.removeView(view);
    }
}
