package io.djnr.mojo;

import android.app.Application;
import android.content.Context;

import io.djnr.mojo.dagger.component.AppComponent;
import io.djnr.mojo.dagger.component.DaggerAppComponent;
import io.djnr.mojo.dagger.module.AppModule;

/**
 * Created by Dj on 7/25/2016.
 */
public class MoviesApp extends Application{

    public static MoviesApp get(Context context){
        return (MoviesApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }

    private AppComponent appComponent;

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
