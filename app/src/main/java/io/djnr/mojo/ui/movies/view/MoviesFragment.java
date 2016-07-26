package io.djnr.mojo.ui.movies.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.djnr.mojo.MoviesApp;
import io.djnr.mojo.R;
import io.djnr.mojo.dagger.module.MoviesFragmentModule;
import io.djnr.mojo.model.Result;
import io.djnr.mojo.ui.movies.IMovies;
import io.djnr.mojo.ui.movies.view.adapter.MoviesAdapter;
import io.djnr.mojo.settings.SettingsActivity;

/**
 * Created by Dj on 7/6/2016.
 */
public class MoviesFragment extends Fragment implements IMovies.RequiredView{
    private static final String TAG = "MoviesFragment";
    @BindView(R.id.grid_movies)
    GridView mGridMovies;

    @Inject
    public IMovies.ProvidedPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        ButterKnife.bind(this, view);
        setupComponent();
        return view;
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

    private void setupComponent() {
        MoviesApp.get(getActivity())
                .getAppComponent()
                .getMoviesComponent(new MoviesFragmentModule(this))
                .inject(this);
    }

    @Override
    public Context getAppContext() {
        return getAppContext();
    }

    @Override
    public Context getActivityContext() {
        return getActivity();
    }

    @Override
    public void displayMovies(List<Result> results) {
        mGridMovies.setAdapter(new MoviesAdapter(getActivity(), results));
    }
}
