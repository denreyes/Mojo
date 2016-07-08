package io.djnr.mojo.ui.movies;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.djnr.mojo.R;
import io.djnr.mojo.model.Movies;
import io.djnr.mojo.model.Result;
import io.djnr.mojo.remote.MoviesAPI;
import io.djnr.mojo.settings.SettingsActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dj on 7/6/2016.
 */
public class MoviesFragment extends Fragment {
    private static final String TAG = "MoviesFragment";
    @BindView(R.id.grid_movies)
    GridView mGridMovies;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detailfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(getActivity(), SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        ButterKnife.bind(this, view);

        String sort_order =
                PreferenceManager.getDefaultSharedPreferences(getActivity())
                        .getString(getString(R.string.pref_sort_key),
                                getString(R.string.pref_sort_popularity));

        fetchMovies(sort_order);
        return view;
    }

    private void fetchMovies(String sort_order) {
        if (sort_order.equals(getString(R.string.pref_sort_popularity))) {
            MoviesAPI.Factory.getInstance().popularMovies().enqueue(new Callback<Movies>() {
                @Override
                public void onResponse(Call<Movies> call, Response<Movies> response) {
                    List<Result> results = response.body().getResults();
                    mGridMovies.setAdapter(new MoviesAdapter(getActivity(), results));
                }

                @Override
                public void onFailure(Call<Movies> call, Throwable t) {

                }
            });
        } else {
            MoviesAPI.Factory.getInstance().topRatedMovies().enqueue(new Callback<Movies>() {
                @Override
                public void onResponse(Call<Movies> call, Response<Movies> response) {
                    List<Result> results = response.body().getResults();
                    mGridMovies.setAdapter(new MoviesAdapter(getActivity(), results));
                }

                @Override
                public void onFailure(Call<Movies> call, Throwable t) {

                }
            });
        }
    }

}
