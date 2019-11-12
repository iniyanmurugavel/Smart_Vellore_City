package com.smart_vellore_city.Tourism.interfaces;


import com.smart_vellore_city.Tourism.model.TourismSitesPojo;

import java.util.ArrayList;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public interface ITourismHomeContract {


    interface ITourSitesPojo {

        void onDestroy();

        void onRequestData();

    }


    interface ITourismView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<TourismSitesPojo> pojo);

        void onResponseFailure(Throwable throwable);
    }


    interface ITourismPresenter {
        interface onFinishListener {
            void onFinished(ArrayList<TourismSitesPojo> TourismSitesArrayList);

            void onFailure(Throwable t);
        }

        void getTourismSitesArrayList(onFinishListener onFinishedListener);
    }

}
