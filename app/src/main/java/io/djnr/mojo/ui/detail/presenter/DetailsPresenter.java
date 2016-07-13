package io.djnr.mojo.ui.detail.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.lang.ref.WeakReference;

import io.djnr.mojo.ui.detail.IDetails;
import io.djnr.mojo.ui.movies.IMovies;
import io.djnr.mojo.utils.Constants;

/**
 * Created by Dj on 7/13/2016.
 */
public class DetailsPresenter implements IDetails.ProvidedPresenter, IDetails.RequiredPresenter{
    private WeakReference<IDetails.RequiredView> mView;
    private IDetails.ProvidedModel mModel;

    public DetailsPresenter(IDetails.RequiredView view){
        mView = new WeakReference<IDetails.RequiredView>(view);
    }

    public void setModel(IDetails.ProvidedModel model){
        this.mModel = model;
        getDataAndSetViews();
    }

    private IDetails.RequiredView getView() throws NullPointerException{
        if(mView != null){
            return mView.get();
        }else{
            throw new NullPointerException("View is unavailable.");
        }
    }

    @Override
    public Context getAppContext() {
        return getView().getAppContext();
    }

    @Override
    public Context getActivityContext() {
        return getView().getActivityContext();
    }

    @Override
    public void getDataAndSetViews() {
        Intent i = ((Activity)getActivityContext()).getIntent();
        String title = i.getStringExtra(Constants.MOVIE_TITLE);
        String year = i.getStringExtra(Constants.MOVIE_RELEASE_DATE);
        String rate = i.getStringExtra(Constants.MOVE_RATE);
        String summary = i.getStringExtra(Constants.MOVE_PLOT);
        String poster_url = i.getStringExtra(Constants.MOVIE_POSTER_URL);

        getView().setViews(title, year, rate, summary, poster_url);
    }
}
