package io.djnr.mojo.ui.movies.presenter;

import android.content.Context;
import android.preference.PreferenceManager;

import java.lang.ref.WeakReference;
import java.util.List;

import io.djnr.mojo.R;
import io.djnr.mojo.model.Movies;
import io.djnr.mojo.model.Result;
import io.djnr.mojo.remote.MoviesAPI;
import io.djnr.mojo.ui.movies.IMovies;
import io.djnr.mojo.ui.movies.view.adapter.MoviesAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    public void setModel(IMovies.ProvidedModel model) {
        this.mModel = model;
        fetchMovies(getSort());
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
    public void setMovies(List<Result> results) {
        getView().displayMovies(results);
    }

    @Override
    public String getSort() {
        return PreferenceManager.getDefaultSharedPreferences(getActivityContext())
                        .getString(getActivityContext().getString(R.string.pref_sort_key),
                                getActivityContext().getString(R.string.pref_sort_popularity));
    }

    @Override
    public void fetchMovies(String sort_order) {
        if (sort_order.equals(getActivityContext().getString(R.string.pref_sort_popularity))) {
            mModel.getPopularMovies();
        } else {
            mModel.getTopRatedMovies();
        }
    }
}
