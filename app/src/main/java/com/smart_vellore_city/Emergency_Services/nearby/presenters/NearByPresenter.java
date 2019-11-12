package com.smart_vellore_city.Emergency_Services.nearby.presenters;


import com.smart_vellore_city.Emergency_Services.nearby.beans.RecentNearByBean;
import com.smart_vellore_city.Emergency_Services.nearby.contracts.NearByContract;

import java.util.ArrayList;
import java.util.List;


public class NearByPresenter implements NearByContract.presenter {
    NearByContract.view view;


    public NearByPresenter(NearByContract.view view) {
        this.view = view;
    }


    @Override
    public void loadNearByRecentDatas() {
        List<RecentNearByBean> recentNearByBeans = new ArrayList<>();
        recentNearByBeans.add(new RecentNearByBean("Vellore Ambulance Service (Zion Ambulance)","Arcot Road, Thottapalayam, Near CMC Jubilee Gate, Sripuram, Saidapet, Vellore, Tamil Nadu 632004","14 Kms"));
        recentNearByBeans.add(new RecentNearByBean("RTP AC AMBULANCE SERVICE","No: 5/2, New katpadi Road, CT scan Centre Complex, Thottapalayam, Vellore, Tamil Nadu 632004","21 Kms"));
        recentNearByBeans.add(new RecentNearByBean("Banu Medicals","Shop No:75/2, Opp. CMC Hospital, IDA Scudder Road, Saidapet, Vellore, Tamil Nadu 632004","4 Kms"));
        recentNearByBeans.add(new RecentNearByBean("CMC VELLORE EYE HOSPITAL","Shop No:75/2, Opp. CMC Hospital, IDA Scudder Road, Saidapet, Vellore, Tamil Nadu 632004","10 Kms"));
        recentNearByBeans.add(new RecentNearByBean("Vellore Eye and Dental Hospital","No. 683/2, 3rd Main Road, Phase 2,, Sathuvachari,, Nehru Nagar, Phase 2, Sathuvachari, Vellore, Tamil Nadu 632009","5 Kms"));
        view.setRecentNearBySearch(recentNearByBeans);
    }
}
