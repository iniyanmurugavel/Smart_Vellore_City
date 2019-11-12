package com.smart_vellore_city.Tourism.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.smart_vellore_city.R;

/**
 * Created by Priyadharshini on 15-11-2018.
 */

public class TourismPagerAdapter extends PagerAdapter {
    String[] mResources = {
            "http://www.sankarayatra.com/travelogue/wp-content/uploads/2016/10/Sripuram-Mahalakshmi-Golden-Temple-2.jpg",
            "http://abtakmedia.com/wp-content/uploads/2017/09/thumbs_1.jpg",
            "http://www.belovednarayani.org/wp-content/uploads/2016/12/sripuramarial-2.jpg"

    };
    Context mContext;
    LayoutInflater layoutInflater;

    public TourismPagerAdapter(Context mContext) {
        this.mContext = mContext;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((LinearLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.iv);
//        imageView.setImageResource(mResources[position]);
        Glide.with(mContext)
                .applyDefaultRequestOptions(new RequestOptions()
                        .placeholder(R.drawable.ic_default_image)
                        .error(R.drawable.ic_default_image))
                .load(mResources[position]).into(imageView);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}




