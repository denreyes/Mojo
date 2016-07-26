package io.djnr.mojo.dagger.component;

import dagger.Subcomponent;
import io.djnr.mojo.dagger.module.DetailsFragmentModule;
import io.djnr.mojo.dagger.scope.FragmentScope;
import io.djnr.mojo.ui.detail.view.DetailsFragment;

/**
 * Created by Dj on 7/26/2016.
 */
@FragmentScope
@Subcomponent(modules = DetailsFragmentModule.class)
public interface DetailsFragmentComponent {
    DetailsFragment inject(DetailsFragment fragment);
}
