package com.smart_vellore_city.MarriageHall.contracts;


import com.smart_vellore_city.MarriageHall.beans.MhallBean;

import java.util.List;

public interface IMhallContract {
    interface view{
       void getDatas(List<MhallBean> mhallBeanList);
    }
    interface presenter{
       void loadDatas();
    }
}
