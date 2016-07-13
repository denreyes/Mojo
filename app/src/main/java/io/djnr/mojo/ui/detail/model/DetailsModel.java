package io.djnr.mojo.ui.detail.model;

import io.djnr.mojo.ui.detail.IDetails;

/**
 * Created by Dj on 7/13/2016.
 */
public class DetailsModel implements IDetails.ProvidedModel{
    IDetails.RequiredPresenter mPresenter;

    public DetailsModel(IDetails.RequiredPresenter presenter){
        this.mPresenter = presenter;
    }
}
