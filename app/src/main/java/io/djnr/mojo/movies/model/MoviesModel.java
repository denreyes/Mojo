package io.djnr.mojo.movies.model;

import io.djnr.mojo.movies.IMovies;

/**
 * Created by Dj on 7/13/2016.
 */
public class MoviesModel implements IMovies.ProvidedModel{
    private IMovies.RequiredPresenter mPresenter;

    public MoviesModel(IMovies.RequiredPresenter presenter){
        this.mPresenter = presenter;
    }
}
