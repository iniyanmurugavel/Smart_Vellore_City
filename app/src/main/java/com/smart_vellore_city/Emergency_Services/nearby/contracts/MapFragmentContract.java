package com.smart_vellore_city.Emergency_Services.nearby.contracts;


import com.smart_vellore_city.Emergency_Services.nearby.beans.MapNearByBean;

import java.util.List;

public interface MapFragmentContract {
    interface view{
        void setRecentNearBySearch(List<MapNearByBean> mapNearByBeanList);
    }
    interface presenter{
        void loadNearByRecentDatas(String type);
    }
}
