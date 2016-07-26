package io.djnr.mojo.dagger.module;

import dagger.Module;
import dagger.Provides;
import io.djnr.mojo.dagger.scope.FragmentScope;
import io.djnr.mojo.ui.detail.IDetails;
import io.djnr.mojo.ui.detail.model.DetailsModel;
import io.djnr.mojo.ui.detail.presenter.DetailsPresenter;
import io.djnr.mojo.ui.detail.view.DetailsFragment;

/**
 * Created by Dj on 7/26/2016.
 */
@Module
public class DetailsFragmentModule {
    private DetailsFragment fragment;

    public DetailsFragmentModule(DetailsFragment fragment){
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    DetailsFragment providesDetailsFragment(){
        return fragment;
    }

    @Provides
    @FragmentScope
    IDetails.ProvidedPresenter providedPresenter(){
        DetailsPresenter presenter = new DetailsPresenter(fragment);
        DetailsModel model = new DetailsModel(presenter);
        presenter.setModel(model);
        return presenter;
    }
}
