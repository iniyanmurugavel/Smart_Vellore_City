package com.smart_vellore_city.parking.callback;



import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Murugan on 04-12-2018.
 */

public interface GetSlots {

    void moveSlotNumber(ArrayList<String> sNumber);

    void showOutOfSlotBookingMessage();
}
