package io.djnr.mojo.ui.movies.model;

import java.util.List;

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
public class MoviesModel implements IMovies.ProvidedModel{
    private IMovies.RequiredPresenter mPresenter;

    public MoviesModel(IMovies.RequiredPresenter presenter){
        this.mPresenter = presenter;
    }

    @Override
    public void getPopularMovies() {
        MoviesAPI.Factory.getInstance().popularMovies().enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                List<Result> results = response.body().getResults();
                mPresenter.setMovies(results);
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

            }
        });
    }

    @Override
    public void getTopRatedMovies() {
        MoviesAPI.Factory.getInstance().topRatedMovies().enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                List<Result> results = response.body().getResults();
                mPresenter.setMovies(results);
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

            }
        });
    }
}
