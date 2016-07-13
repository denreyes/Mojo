package io.djnr.mojo.ui.detail.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.djnr.mojo.R;
import io.djnr.mojo.ui.detail.IDetails;
import io.djnr.mojo.ui.detail.model.DetailsModel;
import io.djnr.mojo.ui.detail.presenter.DetailsPresenter;

/**
 * Created by Dj on 7/8/2016.
 */
public class DetailsFragment extends Fragment implements IDetails.RequiredView{
    @BindView(R.id.img_poster)
    ImageView mImagePoster;
    @BindView(R.id.text_title)
    TextView mTextTitle;
    @BindView(R.id.text_year)
    TextView mTextYear;
    @BindView(R.id.text_rating)
    TextView mTextRating;
    @BindView(R.id.text_content)
    TextView mTextContent;

    IDetails.ProvidedPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);
        setup();
        return view;
    }

    private void setup() {
        DetailsPresenter presenter = new DetailsPresenter(this);
        DetailsModel model = new DetailsModel(presenter);
        presenter.setModel(model);
        this.mPresenter = presenter;
    }

    @Override
    public Context getAppContext() {
        return getActivity().getApplicationContext();
    }

    @Override
    public Context getActivityContext() {
        return getActivity();
    }

    @Override
    public void setViews(String title, String year, String rate, String summary, String poster_url) {
        mTextTitle.setText(title);
        mTextYear.setText(year);
        mTextRating.setText(rate);
        mTextContent.setText(summary);

        Glide.with(this)
                .load(poster_url)
                .fitCenter()
                .crossFade()
                .into(mImagePoster);
    }
}
