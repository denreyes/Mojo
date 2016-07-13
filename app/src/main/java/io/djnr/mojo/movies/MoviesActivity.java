package io.djnr.mojo.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.djnr.mojo.R;
import io.djnr.mojo.movies.view.MoviesFragment;

public class MoviesActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MoviesFragment()).commit();
    }
}
