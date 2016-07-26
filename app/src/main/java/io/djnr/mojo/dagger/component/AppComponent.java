package io.djnr.mojo.dagger.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import io.djnr.mojo.dagger.module.AppModule;
import io.djnr.mojo.dagger.module.DetailsFragmentModule;
import io.djnr.mojo.dagger.module.MoviesFragmentModule;

/**
 * Created by Dj on 7/25/2016.
 */
@Singleton
@Component( modules = AppModule.class )
public interface AppComponent {
    Application application();
    MoviesFragmentComponent getMoviesComponent(MoviesFragmentModule module);
    DetailsFragmentComponent getDetailsComponent(DetailsFragmentModule module);
}
