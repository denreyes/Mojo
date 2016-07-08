package io.djnr.mojo.ui.detail;

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

/**
 * Created by Dj on 7/8/2016.
 */
public class DetailsFragment extends Fragment {
    @BindView(R.id.img_poster)
    ImageView mImagePoster;
    @BindView(R.id.text_title)
    TextView mTextTitle;
    @BindView(R.id.text_year)
    TextView mTextYear;
    @BindView(R.id.text_duration)
    TextView mTextDuration;
    @BindView(R.id.text_rating)
    TextView mTextRating;
    @BindView(R.id.text_content)
    TextView mTextContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);
        Intent i = getActivity().getIntent();
        mTextTitle.setText(i.getStringExtra("MOVIE_TITLE"));
        mTextYear.setText("(" + i.getStringExtra("MOVIE_RELEASE_DATE").substring(0, 4) + ")");
        mTextRating.setText(i.getDoubleExtra("MOVE_RATE",0)+"/10");
        mTextContent.setText(i.getStringExtra("MOVE_PLOT"));

        Glide.with(this)
                .load(i.getStringExtra("MOVIE_POSTER_URL"))
                .fitCenter()
                .crossFade()
                .into(mImagePoster);

        return view;
    }
}
