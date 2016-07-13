package io.djnr.mojo.ui.detail;

import android.content.Context;

import io.djnr.mojo.ui.detail.model.DetailsModel;

/**
 * Created by Dj on 7/13/2016.
 */
public interface IDetails {

    interface RequiredView{
        Context getAppContext();
        Context getActivityContext();
        void setViews(String title, String year, String rate, String summary, String poster_url);
    };

    interface ProvidedPresenter{
        void getDataAndSetViews();
    };

    interface RequiredPresenter{
        Context getAppContext();
        Context getActivityContext();
    };

    interface ProvidedModel{};

}
