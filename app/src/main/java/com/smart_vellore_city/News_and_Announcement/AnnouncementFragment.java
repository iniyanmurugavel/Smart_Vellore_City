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

public class AnnouncementFragment extends Fragment {
    RecyclerView news_rv;

    ArrayList<NewsPojo> newsPojo = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_feeds, container, false);
        announcementList();
        initViews(v);
        return v;
    }

    public void initViews(View view) {
        news_rv = (RecyclerView) view.findViewById(R.id.news_rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        news_rv.setLayoutManager(layoutManager);
        NewsAnnouncementAdapter adapter = new NewsAnnouncementAdapter(newsPojo, getActivity(), 1);
        news_rv.setAdapter(adapter);

    }


    public void announcementList() {

        newsPojo.add(new NewsPojo("Mega Job Fair for Differently abled 05, January 2019",
                "Mega Job Fair for Differently abled 05, January 2019",
                "1 hour(s) ago", "", "05/01/2019 - 05/01/2019"));

        newsPojo.add(new NewsPojo("Vellore District Government Blood Banks tentative Blood donation Camp schedule – September 2018 to August 2019",
                "Vellore District Government Blood Banks tentative Blood donation Camp schedule – September 2018 to August 2019",
                "1 week ago", "", "01/09/2018 - 31/08/2019"));

    }
}