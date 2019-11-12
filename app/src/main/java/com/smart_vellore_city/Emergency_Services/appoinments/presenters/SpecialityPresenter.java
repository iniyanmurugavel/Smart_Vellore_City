package com.smart_vellore_city.Emergency_Services.appoinments.presenters;


import com.smart_vellore_city.Emergency_Services.appoinments.contracts.SpecialityContract;

import java.util.ArrayList;
import java.util.List;

public class SpecialityPresenter implements SpecialityContract.presenter {

    SpecialityContract.view view;

    public SpecialityPresenter(SpecialityContract.view view) {
        this.view = view;
    }

    @Override
    public void getSpecialityDatas() {
        List<String> specialityList = new ArrayList<>();
        specialityList.add("General Physician");
        specialityList.add("Stress & Mental Health");
        specialityList.add("Skin Problems");
        specialityList.add("Neurology");
        specialityList.add("Cancer Advice");
        specialityList.add("Oncology");
        view.loadSpecialityDatas(specialityList);
    }
}
