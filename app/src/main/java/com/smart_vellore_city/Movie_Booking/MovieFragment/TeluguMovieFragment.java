package com.smart_vellore_city.Movie_Booking.MovieFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.Movie_Booking.Adapter.TeluguMovieAdapter;
import com.smart_vellore_city.Movie_Booking.Bean.TeluguMovieBean;
import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 09-06-2017.
 */

public class TeluguMovieFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    List<TeluguMovieBean> beanList;
    TeluguMovieAdapter adapter;
    public static String title[] = {"Taxiwala","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    public static String images[] = {
           "https://in.bmscdn.com/iedb/movies/images/website/poster/large/taxiwala-et00070814-12-02-2018-11-11-47.jpg",
            "https://in.bmscdn.com/iedb/movies/images/website/poster/large/taxiwala-et00070814-12-02-2018-11-11-47.jpg",
            "https://in.bmscdn.com/iedb/movies/images/website/poster/large/taxiwala-et00070814-12-02-2018-11-11-47.jpg",
            "https://in.bmscdn.com/iedb/movies/images/website/poster/large/taxiwala-et00070814-12-02-2018-11-11-47.jpg",
            "https://in.bmscdn.com/iedb/movies/images/website/poster/large/taxiwala-et00070814-12-02-2018-11-11-47.jpg",
            "https://in.bmscdn.com/iedb/movies/images/website/poster/large/taxiwala-et00070814-12-02-2018-11-11-47.jpg",
            "https://in.bmscdn.com/iedb/movies/images/website/poster/large/taxiwala-et00070814-12-02-2018-11-11-47.jpg",
            "https://in.bmscdn.com/iedb/movies/images/website/poster/large/taxiwala-et00070814-12-02-2018-11-11-47.jpg",
            "https://in.bmscdn.com/iedb/movies/images/website/poster/large/taxiwala-et00070814-12-02-2018-11-11-47.jpg",

    };
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.telugu_movie_fragment,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.my_recycler);
        if (recyclerView != null){
            recyclerView.setHasFixedSize(true);
        }

        manager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(manager);
        beanList = new ArrayList<>();

        for (int i=0;i<title.length;i++){
            TeluguMovieBean bean = new TeluguMovieBean(images[i],title[i]);
            beanList.add(bean);
        }

        adapter = new TeluguMovieAdapter(beanList,getContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }
}
