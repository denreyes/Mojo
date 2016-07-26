package io.djnr.mojo.dagger.module;

import dagger.Module;
import dagger.Provides;
import io.djnr.mojo.dagger.scope.FragmentScope;
import io.djnr.mojo.ui.movies.IMovies;
import io.djnr.mojo.ui.movies.model.MoviesModel;
import io.djnr.mojo.ui.movies.presenter.MoviesPresenter;
import io.djnr.mojo.ui.movies.view.MoviesFragment;

/**
 * Created by Dj on 7/25/2016.
 */
@Module
public class MoviesFragmentModule {
    private MoviesFragment fragment;

    public MoviesFragmentModule(MoviesFragment fragment){
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    MoviesFragment providesMoviesFragment(){
        return fragment;
    }

    @Provides
    @FragmentScope
    IMovies.ProvidedPresenter providedPresenter(){
        MoviesPresenter presenter = new MoviesPresenter(fragment);
        MoviesModel model = new MoviesModel(presenter);
        presenter.setModel(model);
        return presenter;
    }
}
