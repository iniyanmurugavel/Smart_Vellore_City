package com.smart_vellore_city.Emergency_Services.nearby.contracts;


import com.smart_vellore_city.Emergency_Services.nearby.beans.RecentNearByBean;

import java.util.List;

public interface NearByContract {
    interface view{
        void setRecentNearBySearch(List<RecentNearByBean> recentNearByBeanList);
    }
    interface presenter{
        void loadNearByRecentDatas();
    }
}
