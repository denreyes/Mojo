package io.djnr.mojo.dagger.component;

import dagger.Subcomponent;
import io.djnr.mojo.dagger.module.MoviesFragmentModule;
import io.djnr.mojo.dagger.scope.FragmentScope;
import io.djnr.mojo.ui.movies.view.MoviesFragment;

/**
 * Created by Dj on 7/25/2016.
 */
@FragmentScope
@Subcomponent( modules = MoviesFragmentModule.class )
public interface MoviesFragmentComponent {
    MoviesFragment inject(MoviesFragment fragment);
}
