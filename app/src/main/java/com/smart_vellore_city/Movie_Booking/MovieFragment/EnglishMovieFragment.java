package com.smart_vellore_city.Movie_Booking.MovieFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.Movie_Booking.Adapter.EnglishMovieAdapter;
import com.smart_vellore_city.Movie_Booking.Bean.EnglishMovieBean;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 21-06-2017.
 */

public class EnglishMovieFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    List<EnglishMovieBean> beanList;
    EnglishMovieAdapter adapter;
    public static String title[] =
            {"Samson","Cosmopolis","Dark Circle","Dark Kight Rises","Killing Them Softly","Locker","Popoye","Victor","Wonder","Zero","Zero"};
    public static String images[] = {
            "https://1.bp.blogspot.com/-9Pc93hnpP4E/Wlrwky7HKwI/AAAAAAAAAmo/8xc9mcEanzID5l3gcCNugTLR3Z7HrwCrgCLcBGAs/s1600/Samson-movie.jpg",
            "https://1.bp.blogspot.com/-9Pc93hnpP4E/Wlrwky7HKwI/AAAAAAAAAmo/8xc9mcEanzID5l3gcCNugTLR3Z7HrwCrgCLcBGAs/s1600/Samson-movie.jpg",
            "https://1.bp.blogspot.com/-9Pc93hnpP4E/Wlrwky7HKwI/AAAAAAAAAmo/8xc9mcEanzID5l3gcCNugTLR3Z7HrwCrgCLcBGAs/s1600/Samson-movie.jpg",
            "https://1.bp.blogspot.com/-9Pc93hnpP4E/Wlrwky7HKwI/AAAAAAAAAmo/8xc9mcEanzID5l3gcCNugTLR3Z7HrwCrgCLcBGAs/s1600/Samson-movie.jpg",
            "https://1.bp.blogspot.com/-9Pc93hnpP4E/Wlrwky7HKwI/AAAAAAAAAmo/8xc9mcEanzID5l3gcCNugTLR3Z7HrwCrgCLcBGAs/s1600/Samson-movie.jpg",
            "https://1.bp.blogspot.com/-9Pc93hnpP4E/Wlrwky7HKwI/AAAAAAAAAmo/8xc9mcEanzID5l3gcCNugTLR3Z7HrwCrgCLcBGAs/s1600/Samson-movie.jpg",
            "https://1.bp.blogspot.com/-9Pc93hnpP4E/Wlrwky7HKwI/AAAAAAAAAmo/8xc9mcEanzID5l3gcCNugTLR3Z7HrwCrgCLcBGAs/s1600/Samson-movie.jpg",
            "https://1.bp.blogspot.com/-9Pc93hnpP4E/Wlrwky7HKwI/AAAAAAAAAmo/8xc9mcEanzID5l3gcCNugTLR3Z7HrwCrgCLcBGAs/s1600/Samson-movie.jpg",
            "https://1.bp.blogspot.com/-9Pc93hnpP4E/Wlrwky7HKwI/AAAAAAAAAmo/8xc9mcEanzID5l3gcCNugTLR3Z7HrwCrgCLcBGAs/s1600/Samson-movie.jpg",
            "https://1.bp.blogspot.com/-9Pc93hnpP4E/Wlrwky7HKwI/AAAAAAAAAmo/8xc9mcEanzID5l3gcCNugTLR3Z7HrwCrgCLcBGAs/s1600/Samson-movie.jpg",
            "https://1.bp.blogspot.com/-9Pc93hnpP4E/Wlrwky7HKwI/AAAAAAAAAmo/8xc9mcEanzID5l3gcCNugTLR3Z7HrwCrgCLcBGAs/s1600/Samson-movie.jpg",


    };
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.english_movie_fragment,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.my_recycler);
        if (recyclerView != null){
            recyclerView.setHasFixedSize(true);
        }

        manager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(manager);

        beanList = new ArrayList<>();

        for (int i=0;i<title.length;i++){
            EnglishMovieBean bean = new EnglishMovieBean(title[i],images[i]);
            beanList.add(bean);
        }
        adapter = new EnglishMovieAdapter(beanList,getContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }
}