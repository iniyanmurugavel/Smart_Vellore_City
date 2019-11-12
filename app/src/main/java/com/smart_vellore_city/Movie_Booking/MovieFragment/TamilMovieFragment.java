package com.smart_vellore_city.Movie_Booking.MovieFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.Movie_Booking.Adapter.MovieAdapter;
import com.smart_vellore_city.Movie_Booking.Bean.MovieBean;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 09-06-2017.
 */

public class TamilMovieFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<MovieBean> beanList;
    private RecyclerView.LayoutManager manager;
    private MovieAdapter adapter;
    public static String names[] =
            {"Sarkar","Kadamban","Imaigal","Mariyappan","Pambu Sattai","Pugazl",
                    "Sathuran","Tharmadurai","Thondan","Thupparivalan","Enthiran 2.0"};
    public static String images[] =
            {
                    "https://i2.wp.com/veekeez.com/wp-content/uploads/2018/09/4-1.jpg",
                    "https://i2.wp.com/veekeez.com/wp-content/uploads/2018/09/4-1.jpg",
                    "https://i2.wp.com/veekeez.com/wp-content/uploads/2018/09/4-1.jpg",
                    "https://i2.wp.com/veekeez.com/wp-content/uploads/2018/09/4-1.jpg",
                    "https://i2.wp.com/veekeez.com/wp-content/uploads/2018/09/4-1.jpg",
                    "https://i2.wp.com/veekeez.com/wp-content/uploads/2018/09/4-1.jpg",
                    "https://i2.wp.com/veekeez.com/wp-content/uploads/2018/09/4-1.jpg",
                    "https://i2.wp.com/veekeez.com/wp-content/uploads/2018/09/4-1.jpg",
                    "https://i2.wp.com/veekeez.com/wp-content/uploads/2018/09/4-1.jpg",
                    "https://i2.wp.com/veekeez.com/wp-content/uploads/2018/09/4-1.jpg",
                    "https://i2.wp.com/veekeez.com/wp-content/uploads/2018/09/4-1.jpg"

            };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tamil_movie_fragment,container,false);
        recyclerView = (RecyclerView)v.findViewById(R.id.my_recycler);
        if(recyclerView != null){
            recyclerView.setHasFixedSize(true);
        }

        manager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(manager);

        beanList = new ArrayList<>();
        for (int i=0;i<names.length;i++){
            MovieBean bean = new MovieBean(images[i],names[i]);
            beanList.add(bean);
        }
        adapter = new MovieAdapter(beanList,getContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return v;
    }
}
