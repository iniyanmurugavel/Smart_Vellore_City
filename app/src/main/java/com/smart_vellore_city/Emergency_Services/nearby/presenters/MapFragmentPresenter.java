package com.smart_vellore_city.Emergency_Services.nearby.presenters;


import com.smart_vellore_city.Emergency_Services.nearby.beans.MapNearByBean;
import com.smart_vellore_city.Emergency_Services.nearby.contracts.MapFragmentContract;

import java.util.ArrayList;
import java.util.List;


public class MapFragmentPresenter implements MapFragmentContract.presenter{
    MapFragmentContract.view view;

    public MapFragmentPresenter(MapFragmentContract.view view) {
        this.view = view;
    }

    @Override
    public void loadNearByRecentDatas(String type) {
        List<MapNearByBean> recentNearByBeans = new ArrayList<>();
        switch(type){
            case "Hospital":
                recentNearByBeans.add(new MapNearByBean("Vellore Hospital","3.7","SH 207, Sasthri Nagar, Krishna Nagar, Veerasamy Nagar, Vellore, Tamil Nadu 632001",1,12.901644, 79.131535));
                recentNearByBeans.add(new MapNearByBean("Sri Narayani Hospital And Research Center","3.6","Azad Road, Sripuram, Thirumalaikodi, Thirumalaikodi, Vellore, Tamil Nadu 632055",1,12.870473, 79.089906));
                recentNearByBeans.add(new MapNearByBean("Christian Medical College","4.0","Arni RoadBagayam, Thorapadi, Vallarnagar, Bagayam, Vellore, Tamil Nadu 632002",1,12.877294, 79.134935));
                recentNearByBeans.add(new MapNearByBean("CMC","4.4","32, Bangalore Rd, Thottapalayam, Vellore, Tamil Nadu 632008",1,12.925164, 79.133837));
                recentNearByBeans.add(new MapNearByBean("CMC VELLORE EYE HOSPITAL","3.8","Ida Scudder Road, Arni Road, Kosapet, Vellore, Tamil Nadu 632001",1,12.913086, 79.133608));
                view.setRecentNearBySearch(recentNearByBeans);
                break;
            case "Medicals":
                recentNearByBeans.add(new MapNearByBean("Vellore Medical","4.6","No. 1, Opposite Sri Arya Bhavan Coffee Shop, Thennamara St, Kosapet, Vellore, Tamil Nadu 632001",2,12.914000, 79.132556));
                recentNearByBeans.add(new MapNearByBean("Banu Medicals","3.3","Shop No:75/2, Opp. CMC Hospital, IDA Scudder Road, Saidapet, Vellore, Tamil Nadu 632004",2,12.923971, 79.135489));
                recentNearByBeans.add(new MapNearByBean("Sri Tamilnadu Medicals","5.0","Old No. 95/5, New No. 2/4, Opposite. Solapuri Amman Kovil, Avalkara Street, Vasanthapuram, Kosapet, Vellore, Tamil Nadu 632001",2,12.914084, 79.132074));
                recentNearByBeans.add(new MapNearByBean("Bawa Medicals","3.6","Katpadi Rd, Thottapalayam, Vellore, Tamil Nadu 632004",2,12.927822, 79.133658));
                recentNearByBeans.add(new MapNearByBean("Om Shakthi Medical","3.2","No. 39/3, K.G.N. Complex, Thennamara St, Opposite Krishna Complex, Kosapet, Vellore, Tamil Nadu 632001",2,12.913896, 79.133886));
                view.setRecentNearBySearch(recentNearByBeans);
                break;
            case "Ambulance":
                recentNearByBeans.add(new MapNearByBean("Vellore Ambulance Service (Zion Ambulance)","4.9","Arcot Road, Thottapalayam, Near CMC Jubilee Gate, Sripuram, Saidapet, Vellore, Tamil Nadu 632004",3,12.924229, 79.137079));
                recentNearByBeans.add(new MapNearByBean("King Air Ambulance Services in Vellore","4.3","Kandasamy Jamedar Street, Kalas Palayam, Kosapet, Vellore, Tamil Nadu 632001",3,12.915142, 79.136828));
                recentNearByBeans.add(new MapNearByBean("RTP AC AMBULANCE SERVICE","5.0","No: 5/2, New katpadi Road, CT scan Centre Complex, Thottapalayam, Vellore, Tamil Nadu 632004",3,12.925575, 79.129443));
                recentNearByBeans.add(new MapNearByBean("Air Ambulance Aviation","5.0","IDA Scudder Rd, Vellore, Tamil Nadu 632004",3,12.924110, 79.135770));
                view.setRecentNearBySearch(recentNearByBeans);
                break;
            case "Blood Banks":
                recentNearByBeans.add(new MapNearByBean("Masonic Blood Bank","4.5","5/2, Katpadi Road, Katpadi Road, Near Oscar, Katpadi Road, Thottapalayam, Vellore, Tamil Nadu 632004",4,12.930466, 79.135075));
                recentNearByBeans.add(new MapNearByBean("Red Cross (Blood Bank)","3.3","SH 9, Balaji Nagar, Vellore, Tamil Nadu 632004",4,12.922154, 79.131894));
                view.setRecentNearBySearch(recentNearByBeans);
                break;
            case "Police Stations":
                recentNearByBeans.add(new MapNearByBean("Vellore South Police Station","3.6","Arni Road, SH-9, Saidapet, Vellore, Tamil Nadu 600015",5,12.916294, 79.132732));
                recentNearByBeans.add(new MapNearByBean("Vellore Katpadi Police Station","3.6","Chitoor-Vellore Highway (SH-9), Kumarappan Nagar, KRS Nagar, Katpadi, Vellore, Tamil Nadu 632007",5,12.975391, 79.137224));
                recentNearByBeans.add(new MapNearByBean("North Police Station","3.4","Vellore,, Balaji Nagar, Vellore, Tamil Nadu 632004",5,12.923250, 79.131648));
                recentNearByBeans.add(new MapNearByBean("Bagayam Police Station","3.6","Arni Rd, Bagayam, Vellore, Tamil Nadu 632002",5,12.875329, 79.133711));
                recentNearByBeans.add(new MapNearByBean("Sathuvachari Police Station","2.4","NH-46, Phase 2, Sathuvachari, Vellore, Tamil Nadu 632009",5,12.936364, 79.153243));
                view.setRecentNearBySearch(recentNearByBeans);
                break;
            case "Atms":
                recentNearByBeans.add(new MapNearByBean("ICICI BANK ATM","3.8","Bangalore Rd, Thottapalayam, Vellore, Tamil Nadu 632004",6,12.929798, 79.134898));
                recentNearByBeans.add(new MapNearByBean("Bank of Baroda ATM","4.2","Officers Line, Kosapet, Vasanthapuram, Kosapet, Vellore, Tamil Nadu 632004",6,12.911591, 79.132019));
                recentNearByBeans.add(new MapNearByBean("SBI ATM","4.0","Official Line, Next To Head Post Office, Vasanthapuram, Kosapet, Vellore, Tamil Nadu 632001",6,12.915142, 79.132334));
                recentNearByBeans.add(new MapNearByBean("Central Bank ATM","4.3","Gandhi Rd, Thottapalayam, Vellore, Tamil Nadu 632004",6,12.924657, 79.135285));
                recentNearByBeans.add(new MapNearByBean("Punjab National Bank ATM","4.6","Mandi St, Balaji Nagar, Vellore, Tamil Nadu 632004",6,12.9224715,79.1329346));
                view.setRecentNearBySearch(recentNearByBeans);
                break;
            case "Banks":
                recentNearByBeans.add(new MapNearByBean("Tamilnadu Mercantile Bank","4.5","7, Mundy Street, Vellore, Saidapet, Vellore, Tamil Nadu 632004",7,12.922966, 79.133058));
                recentNearByBeans.add(new MapNearByBean("Punjab National Bank","4.3","Mundy Street, Mundy Street, Near Panjab Bank, Mandi Street, Balaji Nagar, Vellore, Tamil Nadu 632004",7,12.922451, 79.132886));
                recentNearByBeans.add(new MapNearByBean("Vellore District Central Cooperative Bank","1.0","Long Bazzar, Balaji Nagar, Vellore, Tamil Nadu 632004",7,12.919458, 79.133382));
                recentNearByBeans.add(new MapNearByBean("Bank of India","3.7","3-5 New Katpadi Road, Thottapalayam, Vellore, Tamil Nadu 632004",7,12.930316, 79.134829));
                recentNearByBeans.add(new MapNearByBean("Canara Bank","3.2","SH 9, Balaji Nagar, Vellore, Tamil Nadu 632004",7,12.921993, 79.131946));
                view.setRecentNearBySearch(recentNearByBeans);
                break;
            case "Toilets":
                recentNearByBeans.add(new MapNearByBean("Bus stand bathroom","2.3","Thottapalayam, Vellore, Tamil Nadu 632012",8,12.935022, 79.136254));
                recentNearByBeans.add(new MapNearByBean("Bus Stand Bathroom","2.0","Balaji Nagar, Vellore, Tamil Nadu 632004",8,12.921604, 79.132299));
                recentNearByBeans.add(new MapNearByBean("Toilet Bathroom 6","3.3","Thottapalayam, Vellore, Tamil Nadu 632012",8,12.934679, 79.137226));
                recentNearByBeans.add(new MapNearByBean("Bathroom","5.0","Sitting Bazaar Rd, Balaji Nagar, Vellore, Tamil Nadu 632004",8,12.919073, 79.132440));
                recentNearByBeans.add(new MapNearByBean("Toilet Bathrooms","4.0","2/1, Mandi St, Sripuram, Saidapet, Vellore, Tamil Nadu 632004",8,12.921740, 79.132695));
                view.setRecentNearBySearch(recentNearByBeans);
                break;
        }
    }
}
