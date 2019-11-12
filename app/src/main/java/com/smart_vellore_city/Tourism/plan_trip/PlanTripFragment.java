package com.smart_vellore_city.Tourism.plan_trip;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.E_Market.model.EMarketPojo;
import com.smart_vellore_city.R;
import com.smart_vellore_city.Tourism.interfaces.RecyclerClickListener;
import com.smart_vellore_city.agri.adapter.AgriAdapter;

import java.util.ArrayList;

public class PlanTripFragment extends Fragment implements RecyclerClickListener {

    int currentPage = 0;
    RecyclerView recyclerview;
    ArrayList<EMarketPojo> pojo = new ArrayList<>();
    ArrayList<TourAgentPojo> tourAgentPojo = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_agri, container, false);

        currentPage = getArguments().getInt("current_page");

        initViews(v);


        return v;
    }

    public void initViews(View view) {
        recyclerview = (RecyclerView) view.findViewById(R.id.agri_rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);

        dataList();
    }


    public void dataList() {

        pojo.clear();
        tourAgentPojo.clear();


        if (currentPage == 1) {
            tourAgentPojo.add(new TourAgentPojo("PANDIA RAJAN ", "3 Bookings", "Hi, I'm Pandiarajan. I have been working as a Tour Guide/escort, I also started working as a freelance guide and tour leader since 2004 and now . I got a University degree in B.A.Tourism and also i have done M.T.M , and I'm a professional licenced Tour Guide and Tour Leader.",
                    "Languages Known : English (primary), English (Fluent), Hindi (Fluent), German (Basic)",
                    "4.8", "Licensed", "https://tourguides.viator.com/Images/Profile/Large/af8ce22d-e318-4ad1-bc2c-ee1f1798830b_dfc0e5f3-c6ad-4acb-afd3-41e2e6e96c31.jpg", "9894591650"));
            tourAgentPojo.add(new TourAgentPojo("Ashok T  ", "No Bookings",
                    "Experienced Certified Tourism Professional from Ministry of Tourism, Govt of India. I enjoy guiding and storytelling, use to learn something new every day thats keep me updated myself, as my tourists",
                    "Languages:" +
                            "English (primary)," +
                            "Tamil (Fluent)," +
                            "French (Basic)," +
                            "Hindi (Basic)",
                    "3.3", "Licensed",
                    "https://tourguides.viator.com/Images/Profile/Thumbnail/e3482e40-86ed-4cce-a74d-6ccf2cf95ba5_0f2e618a-3207-4c6e-b970-3cbae8b5a8e2.jpg",
                    "9894591650"));
            tourAgentPojo.add(new TourAgentPojo("srinivasan lakshmanan  ", "No Bookings",
                    "Over two decades of Experience\n" +
                            "Fluent in English,French,German and Italian" +
                            "Guided tours all over India" +
                            "Ability to provide deep insight of Indian", "Languages:" +
                    "English (primary)," +
                    "Tamil (Fluent)," +
                    "French (Basic)," +
                    "Italian (Basic)",
                    "2.1", "No",
                    "https://tourguides.viator.com/Images/Profile/Thumbnail/6aab1470-8ffa-4770-8e86-177bd6f7901e_7a5a63f5-4491-471d-a738-0fbb2d4cce05.jpg",
                    "9894591650"));
            AgriAdapter adapter = new AgriAdapter(tourAgentPojo, getActivity(), 2, "");
            recyclerview.setAdapter(adapter);
        }

        if (currentPage == 2) {
            pojo.add(new EMarketPojo("Regency Sameera Vellore by GRT Hotels",
                    "Address: No.145, Green Circle, New By-pass Rd, Vellore, Tamil Nadu 632004",
                    "089395 57722", "4.1"));
            pojo.add(new EMarketPojo("Hotel Aavanaa Inn",
                    "Address: No. 144, Arcot Road, (Opp to CMC Hospital), Vellore, Tamil Nadu 632004",
                    "0416 221 5073", "3.6"));
            pojo.add(new EMarketPojo("SGRT Residency",
                    "Address: 313, South Avenue Road, Phase 2, Sathuvachari, Vellore, Tamil Nadu 632009",
                    " 077081 28731", "3.7"));
            pojo.add(new EMarketPojo("GOLDEN GATEWAY - STAY WITH COMFORT",
                    "Address: Azad Rd, Thirumalaikodi, Vellore, Tamil Nadu 632055",
                    "0416 227 1899", "4.5"));

            AgriAdapter adapter = new AgriAdapter(pojo, getActivity(), 1, this);
            recyclerview.setAdapter(adapter);


        }
        if (currentPage == 3) {
            pojo.add(new EMarketPojo("Darling Residency",
                    "Address: 11/8, Anna Salai, Kosapet, Vellore, Tamil Nadu 632001",
                    "0416 221 3001", "4.1"));
            pojo.add(new EMarketPojo("Poppys Anukula Residency",
                    "Address: Opp. New Bus Stand, New Katpadi Road, Vellore, Tamil Nadu 632004",
                    "088704 77720", "4.0"));
            pojo.add(new EMarketPojo("DP stay",
                    "Address: Auxiliam College Road, Suthanthira Ponvizha Nagar, Bharathi Nagar, Gandhi Nagar, Vellore, Tamil Nadu 632006",
                    " 098946 42495", "4.0"));
            pojo.add(new EMarketPojo("Dharani Solitary Woods Resorts",
                    "Address: Kugayanallore (Via Thiruvalam), Vellore Dist, Kugaiyanallore, Tamil Nadu",
                    " 0416 291 5580", "3.3"));

            AgriAdapter adapter = new AgriAdapter(pojo, getActivity(), 1, this);
            recyclerview.setAdapter(adapter);


        }
        if (currentPage == 4) {
            pojo.add(new EMarketPojo("Preethi Womens Hostel",
                    "Address: No: 24, Chittoor High Road, Near Katpadi Railway Station, Vallimalai Road, Katpadi, Vellore, Tamil Nadu 632007",
                    "075029 62785", "4.2"));
            pojo.add(new EMarketPojo("Meenakshi Sundari Working Womens Hostel",
                    "Address: N 14,7th east man rad, 7th East Main Rd, Gandhi Nagar, Vellore, Tamil Nadu 632006",
                    "099946 21183", "4.4"));
            pojo.add(new EMarketPojo("The Mansion Of The Gods, Men's Hostel, Christian Medical College, Vellore",
                    "Address: Bagayam, Vellore, Tamil Nadu 632002", " 0244 42495", "4.8"));
            pojo.add(new EMarketPojo("Modale Hostel",
                    "Address: Bagayam, Vellore, Tamil Nadu 632002",
                    " 0416 228 6114", "4.6"));

            AgriAdapter adapter = new AgriAdapter(pojo, getActivity(), 1, this);
            recyclerview.setAdapter(adapter);


        }
    }

    @Override
    public void onItemClick() {

    }
}
