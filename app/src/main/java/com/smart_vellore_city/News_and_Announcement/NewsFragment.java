package com.smart_vellore_city.News_and_Announcement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.R;

import java.util.ArrayList;

/**
 * Created by Priyadharshini on 16-11-2018.
 */

public class NewsFragment extends Fragment {

    RecyclerView news_rv;

    ArrayList<NewsPojo> newsPojo = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_feeds, container, false);

        newsList();
        initViews(v);
        return v;
    }

    public void initViews(View view) {
        news_rv = (RecyclerView) view.findViewById(R.id.news_rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        news_rv.setLayoutManager(layoutManager);
        NewsAnnouncementAdapter adapter = new NewsAnnouncementAdapter(newsPojo, 0, getActivity());
        news_rv.setAdapter(adapter);

    }


    public void newsList() {

        newsPojo.add(new NewsPojo("IMD issues red alert; Tamil Nadu, Kerala and Puducherryy",
                "Chennai and other parts of Tamil Nadu and Puducherry receive.In the last 24 hours ending 8.30am, Kattumannarkoil in Cuddalore ",
                "4 secs ago", "https://static.asianetnews.com/images/01cwccny53smn3qxpxrxjpdqv0/kaaja.gif", ""));

        newsPojo.add(new NewsPojo("Vellore Engineering Students Ready to Test Their Formula Car in Germany",
                "With the dream of seeing their car driven by Formula One champion Lewis Hamilton someday, 40 engineering students from the Vellore Institute of Technology (VIT) in Tamil Nadu have put their head together to design a Formula car.",
                "7 mins ago", "http://www.racecar-engineering.com/wp-content/uploads/2016/07/DSC02407_1.jpg", ""));
        newsPojo.add(new NewsPojo("VITEEE 2018 Online Application Process Begins for Vellore Institute of Technology, Apply Before 15th Mar 2018",
                "The last date for the submission of the online application form for VIT Engineering Entrance Examination 2018 is 15th March 2018.",
                "2 hour(s) ago", "https://static-collegedunia.com/public/college_data/images/appImage/25914_VIT_New.jpg", ""));

        newsPojo.add(new NewsPojo("TTE Pushed Out of Train by 6 Passengers for Demanding ID Proof",
                "One of the six assailants identified as Manick of Odisha was arrested at Chittoor in Andhra Pradesh and brought to Katpadi, police said. The five others managed to escape. Police said they all were travelling in a group.",
                "6 hour(s) ago", "https://www.thehindu.com/migration_catalog/article14438781.ece/alternates/FREE_660/02th_honey-wall+02TH_WALAJAH.jpg.jpg", ""));

        newsPojo.add(new NewsPojo("Tamil Nadu: Villagers in Vellore live in fear as rain fury refuses to end",
                "A group of villagers in Vellore in Tamil Nadu are living in fear that the rains may wash away their homes as a nearby lake is not maintained well.",
                "1 day ago", "https://tnproblems.files.wordpress.com/2017/07/fb_img_1499224353956.jpg?w=760", ""));
    }
}
