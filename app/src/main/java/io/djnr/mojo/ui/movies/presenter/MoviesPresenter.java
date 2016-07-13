package io.djnr.mojo.ui.movies.presenter;

import android.content.Context;

import java.lang.ref.WeakReference;

import io.djnr.mojo.ui.movies.IMovies;

/**
 * Created by Dj on 7/13/2016.
 */
public class MoviesPresenter implements IMovies.ProvidedPresenter, IMovies.RequiredPresenter{
    private WeakReference<IMovies.RequiredView> mView;
    private IMovies.ProvidedModel mModel;

    public MoviesPresenter(IMovies.RequiredView view){
        this.mView = new WeakReference<IMovies.RequiredView>(view);
    }

    private IMovies.RequiredView getView() throws NullPointerException{
        if(mView != null){
            return mView.get();
        }else{
            throw new NullPointerException("View is unavailable");
        }
    }

    public void setModel(IMovies.ProvidedModel model){
        this.mModel = model;
    }

    @Override
    public Context getAppContext() {
        return getView().getAppContext();
    }

    @Override
    public Context getActivityContext() {
        return getView().getActivityContext();
    }
}
