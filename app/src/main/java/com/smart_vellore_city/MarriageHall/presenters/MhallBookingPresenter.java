package com.smart_vellore_city.MarriageHall.presenters;

import com.smart_vellore_city.MarriageHall.contracts.MhallBookingContract;

import java.util.ArrayList;
import java.util.List;

public class MhallBookingPresenter implements MhallBookingContract.presenter {
    MhallBookingContract.view view;

    public MhallBookingPresenter(MhallBookingContract.view view) {
        this.view = view;
    }

    @Override
    public void loadFunctionList() {
        List<String> functionList = new ArrayList<>();
        functionList.add("Weddings & Pre-Wedding Planning.");
        functionList.add("Birthday Party.");
        functionList.add("Anniversaries");
        functionList.add("Theme Party / Kitty Party");
        functionList.add("Personal Celebrations");
        functionList.add("Family Get-Together");
        functionList.add("Mata ki Chowki / Jagran");
        functionList.add("Traditional Jhankies");
        view.getFunctionList(functionList);
    }
}
