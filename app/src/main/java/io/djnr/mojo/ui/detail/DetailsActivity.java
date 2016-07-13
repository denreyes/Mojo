package io.djnr.mojo.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.djnr.mojo.R;
import io.djnr.mojo.ui.detail.view.DetailsFragment;

/**
 * Created by Dj on 7/8/2016.
 */
public class DetailsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new DetailsFragment()).commit();
    }
}
