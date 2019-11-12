package com.smart_vellore_city.MarriageHall.contracts;

import java.util.List;

public interface MhallBookingContract {
    interface view{
        void getFunctionList(List<String> functionList);
    }
    interface presenter{
        void loadFunctionList();
    }
}
