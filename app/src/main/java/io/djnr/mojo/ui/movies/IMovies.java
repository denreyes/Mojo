package io.djnr.mojo.ui.movies;

import android.content.Context;

/**
 * Created by Dj on 7/13/2016.
 */
public interface IMovies {

    interface RequiredView{
        Context getAppContext();
        Context getActivityContext();
    }

    interface ProvidedPresenter{}

    interface RequiredPresenter{
        Context getAppContext();
        Context getActivityContext();
    }

    interface ProvidedModel{}
}
