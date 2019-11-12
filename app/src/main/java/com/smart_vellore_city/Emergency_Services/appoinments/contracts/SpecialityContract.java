package com.smart_vellore_city.Emergency_Services.appoinments.contracts;

import java.util.List;

public interface SpecialityContract {
    interface view{
        void loadSpecialityDatas(List<String> specialityItems);
    }
    interface presenter{
        void getSpecialityDatas();
    }
}
