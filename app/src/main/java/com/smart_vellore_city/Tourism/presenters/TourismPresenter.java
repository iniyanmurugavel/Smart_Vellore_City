package com.smart_vellore_city.Tourism.presenters;

import com.smart_vellore_city.Tourism.interfaces.ITourismHomeContract;
import com.smart_vellore_city.Tourism.model.TourismSitesPojo;

import java.util.ArrayList;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class TourismPresenter implements ITourismHomeContract.ITourSitesPojo, ITourismHomeContract.ITourismPresenter.onFinishListener {

    private ITourismHomeContract.ITourismView view;
    private ITourismHomeContract.ITourismPresenter presenter;

    public TourismPresenter(ITourismHomeContract.ITourismView view, ITourismHomeContract.ITourismPresenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public void onFinished(ArrayList<TourismSitesPojo> TourismSitesArrayList) {

        if (view != null) {
            view.setDataToRecyclerView(TourismSitesArrayList);
            view.hideProgress();
        }

    }

    @Override
    public void onFailure(Throwable t) {
        if (view != null) {
            view.onResponseFailure(t);
            view.hideProgress();
        }

    }


    @Override
    public void onDestroy() {
        view = null;

    }

    @Override
    public void onRequestData() {
        presenter.getTourismSitesArrayList(this);
    }
}
