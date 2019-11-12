package com.smart_vellore_city.dashboard;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smart_vellore_city.Bills.BIllHome;
import com.smart_vellore_city.News_and_Announcement.NewsAnnouncementActivity;
import com.smart_vellore_city.R;
import com.smart_vellore_city.weather.WeatherActivity;

public class HomeSliderAdapter extends PagerAdapter {
    public static int images[] = {R.drawable.weather_banner_new,R.drawable.news_banner_new,
            R.drawable.bill_banner_new};
    public Context context;
    LayoutInflater inflater;
    public HomeSliderAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.home_slider_list,null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position==0){

                    Intent i = new Intent(context,WeatherActivity.class);
                    context.startActivity(i);

                }else if (position==1){

                    Intent i = new Intent(context,NewsAnnouncementActivity.class);
                    context.startActivity(i);

                }else {

                    Intent i = new Intent(context,BIllHome.class);
                    context.startActivity(i);
                }

            }
        });
        ImageView image = (ImageView)view.findViewById(R.id.banner);
        image.setImageResource(images[position]);
        ViewPager vp = (ViewPager)container;
        vp.addView(view,0);

        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager)container;
        View view = (View)object;
        viewPager.removeView(view);
    }
}

