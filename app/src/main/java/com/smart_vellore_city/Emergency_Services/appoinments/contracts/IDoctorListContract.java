package com.smart_vellore_city.Emergency_Services.appoinments.contracts;

import com.smart_vellore_city.Emergency_Services.appoinments.models.DocBean;

import java.util.List;

public interface IDoctorListContract {
    interface view{
        void getDatas(List<DocBean> docBeanList);
    }
    interface model{

    }
    interface presenter{
        void loadDatas();
    }
}
