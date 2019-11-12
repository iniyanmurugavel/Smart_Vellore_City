package com.smart_vellore_city.SchoolColleges.contracts;


import com.smart_vellore_city.SchoolColleges.beans.SchoolCollegeBean;

import java.util.List;

public interface SchoolCollegeContract {
    interface view{
        void getDatas(List<SchoolCollegeBean> schoolCollegeBeans);
    }
    interface presenter{
        void loadSchools();
        void loadColleges();
    }
}
