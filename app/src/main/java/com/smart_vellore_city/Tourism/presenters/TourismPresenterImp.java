package com.smart_vellore_city.Tourism.presenters;

import com.smart_vellore_city.Tourism.interfaces.ITourismHomeContract;
import com.smart_vellore_city.Tourism.model.TourismSitesPojo;

import java.util.ArrayList;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class TourismPresenterImp implements ITourismHomeContract.ITourismPresenter {

    private ArrayList<TourismSitesPojo> arrayList = new ArrayList<>();

    @Override
    public void getTourismSitesArrayList(onFinishListener onFinishedListener) {


        arrayList.add(new TourismSitesPojo("Sripuram - Golden Temple", "Hindu temple in Vellore, India",
                "The golden temple complex inside the Sripuram spiritual park is " +
                        "situated at the foot of a small range of green hills at Thirumalaikodi " +
                        "village, 8 km from Vellore in Tamil Nadu, India. It is 120 km from Tirupati," +
                        " 145 km from Chennai, 160 km from Puducherry and 200 km from Bengaluru.,",
                "Sri Narayani Peetam, Sri Puram, Thirumalai Kodi, Vellore, Tamil Nadu 632055",
                "4.2", "https://www.hindufaqs.com/wp-content/uploads/2015/02/Sripuram-Golden-Temple.jpg",
                "https://www.yatramantra.com/tamilnadu/wp-content/uploads/sites/4/2015/10/Sripuram-Golden-Temple-433x544.jpg",
                "http://www.belovednarayani.org/wp-content/uploads/2016/12/sripuramarial-2.jpg",
                "http://www.sankarayatra.com/travelogue/wp-content/uploads/2016/10/Sripuram-Mahalakshmi-Golden-Temple-2.jpg",
                "4005", "Ornate, gold-covered temple in a vast spiritual park complex with a star-shaped path & gardens"));
        arrayList.add(new TourismSitesPojo("Vellore Fort", "Stalwart fort built in the 16th century",
                "16-century fortress was the former headquarters of the Aravidu Dynasty & features a moat &" +
                        " ramparts.", "Balaji Nagar, Vellore, Tamil Nadu 632004",
                "4.2", "http://www.darlingresidency.com/public/img/places1.jpg", "",
                "", "", "2458", "16-century fortress was the former headquarters of the Aravidu Dynasty & features a moat & ramparts. - Google"));
        arrayList.add(new TourismSitesPojo("Yelagiri", "Zoo in Puthur R.F., Tamil Nadu",
                "Yelagiri is a hill station in the southeast Indian state of Tamil Nadu. Built in 1964," +
                        " the hilltop Velavan Temple is a colorful Murugan temple with views of the valley below. " +
                        "The Jalagamparai Waterfalls crash into a swimming hole surrounded by trails and picnic spots. " +
                        "Nearby is a temple dedicated to Lord Shiva. Close to artificial Punganur Lake, the Nature Park " +
                        "has a garden and an aquarium, with fish and tortoises.", "Yelagiri, Tamil Nadu 635853",
                "4.6", "https://image3.mouthshut.com/images/imagesp/925043598s.jpg", "",
                "", "", "996", "Hillside conservation area with scenic hiking trails & temples, plus hotels & restaurants."));
        arrayList.add(new TourismSitesPojo("Amirthi Zoological Park", "Village in Tamil Nadu",
                "Amirthi Zoological Park is a zoo in Tiruvannamalai District in the Indian state of" +
                        " Tamil Nadu. It was opened in 1967 and is about 55 kilometres from district headquarters " +
                        "Tiruvannamalai city and 25 kilometres from the Vellore city. The area of the park is 25 " +
                        "hectares and one can find beautiful water falls.", " Kannamangalam, Kathalampattu R.F, Amirthi, Vellore, Tamil Nadu 632102",
                "3.8", "https://img.dtnext.in/Articles/2018/Apr/201804040115291521_Amirthi-zoo-seeks-new-animals-to-boost-footfall_SECVPF.gif", "",
                "", "", "875", "Small zoo established in 1967 in a scenic area with waterfalls & trees, plus a playground for kids"));
        arrayList.add(new TourismSitesPojo("Jalagamparai Waterfalls",
                "Tourist attraction in Nagalathu " +
                        "Extension R.F., Tamil Nadu",
                "Jalagamparai waterfalls is one of the important tourist spots in " +
                        "Yelagiri Hills to visit. At a distance 37 km from Yelagiri, 37 from" +
                        " Athanavur and 13 km from Thirupattur, magnificent Jalagamparai Waterfalls" +
                        " near Jadayanur is created by the River Attaaru running through the valleys " +
                        "of Yelagiri Hills. It is one of the best places to visit in Yelagiri Hills.\n" +
                        "\n" +
                        "Jalagamparai waterfalls is flowing down from a height of 15 meters," +
                        " the place is popular among lovebirds. Bathing in this waterfall cures" +
                        " diseases because it passes through various herbal plants in the hills." +
                        " The waterfall is situated in an isolated place and is not crowded most " +
                        "of the time. The best time to visit the Jalagamparai waterfalls is from November" +
                        " to January as the water from the North East Monsoon rains will ensure that there" +
                        " is water in the waterfalls. This waterfall is very near to the Jalagamparai Temple " +
                        "which is an important temple dedicated to Lord Shiva.", " Nagalathu Extension " +
                "R.F., Tamil Nadu 635853",
                "3.8", "http://im.hunt.in/cg/City-Guide/kodaikanal-waterfall.jpg", "", "", "", "845", "Perfect place to spend weekends with Friends and family."));
        onFinishedListener.onFinished(arrayList);
    }
}
