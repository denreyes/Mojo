package io.djnr.mojo.ui.movies;

import android.content.Context;

import java.util.List;

import io.djnr.mojo.model.Result;
import io.djnr.mojo.ui.movies.view.MoviesFragment;

/**
 * Created by Dj on 7/13/2016.
 */
public interface IMovies {

    interface RequiredView{
        Context getAppContext();
        Context getActivityContext();
        void displayMovies(List<Result> results);
    }

    interface ProvidedPresenter{
        String getSort();
        void setView(RequiredView view);
        void fetchMovies(String sort);
    }

    interface RequiredPresenter{
        Context getAppContext();
        Context getActivityContext();
        void setMovies(List<Result> results);
    }

    interface ProvidedModel{
        void getPopularMovies();
        void getTopRatedMovies();
    }
}
