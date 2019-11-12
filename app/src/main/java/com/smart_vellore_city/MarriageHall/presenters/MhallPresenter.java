package com.smart_vellore_city.MarriageHall.presenters;


import com.smart_vellore_city.MarriageHall.beans.MhallBean;
import com.smart_vellore_city.MarriageHall.contracts.IMhallContract;

import java.util.ArrayList;
import java.util.List;

public class MhallPresenter implements IMhallContract.presenter {
    IMhallContract.view view;

    public MhallPresenter(IMhallContract.view view) {
        this.view = view;
    }


    @Override
    public void loadDatas() {
        List<MhallBean> mhallBeanList = new ArrayList<>();
        mhallBeanList.add(new MhallBean("Vellore Marriage Hall","3.9","1.3 Kms","1,500","10","150","15,000",12.909914, 79.130418,"P. Dhandapani Mudaliar Mahal, No.7/1, Masilamani Mudaliar Hostel Road, Bishop David Nagar, Kosapet, Vellore, Tamil Nadu 632001","https://www.hyderabad.weddingokay.com/wp-content/uploads/2015/10/hall92-300x200.jpg"));
        mhallBeanList.add(new MhallBean("Marriage Hall","3.0","2.3 Kms","500","4","50","5,000",12.935235, 79.138350,"Chitoor-Vellore Highway (SH-9), Thottapalayam, Vellore, Tamil Nadu 632012","https://i.ytimg.com/vi/RNUCItLxpTU/maxresdefault.jpg"));
        mhallBeanList.add(new MhallBean("Anukulas Convention center","3.6","2.2 Kms","1,000","8","100","12,000",12.934116, 79.139020,"New Katpadi Road, Opposite to Chelliyamman Koil, Vellore, Tamil Nadu, Samuel Nagar, Thottapalayam, Vellore, Tamil Nadu 632004","https://static1.squarespace.com/static/521be5abe4b0d492d86da9f8/t/53e817a0e4b00effbcfbd841/1407719411716/Imperial+Decorations+-+Indian+Wedding+Floral+Hall+Stage+Decorations.jpg?format=1500w"));
        mhallBeanList.add(new MhallBean("Srinivasa Marriage Hall","3.5","850 Mts","800","6","70","10,000",12.921145, 79.135939,"Main Bazaar, Main Bazar, Opposite R.K.S. Medicals, Vellore, Sripuram, Saidapet, Vellore, Tamil Nadu 632004","http://www.rsmahal.com/wp-content/uploads/2017/02/new14-768x432.jpg"));
        mhallBeanList.add(new MhallBean("Narayana Reddy Marriage Hall","5.0","1.2 Kms","1,500","10","150","15,000",12.926150, 79.133075,"Dharmaraja Kovil St, Thottapalayam, Vellore, Tamil Nadu 632004","https://in.bookmyfunction.com/blog/wp-content/uploads/2015/12/indian-wedding-flower-decorations.jpg"));
        mhallBeanList.add(new MhallBean("Saradambal Srinivasamudallyar Marriage Hall","3.9","3.1 Kms","700","3","20","500",12.900885, 79.131547,"No. 85, Officers Line, Vellore, Sasthri Nagar, Krishna Nagar, Veerasamy Nagar, Vellore, Tamil Nadu 632001","https://in.bookmyfunction.com/blog/wp-content/uploads/2015/12/indian-wedding-mandap-decoration.jpg"));
        view.getDatas(mhallBeanList);
    }
}
