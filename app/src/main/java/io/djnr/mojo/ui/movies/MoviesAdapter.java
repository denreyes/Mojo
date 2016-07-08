package io.djnr.mojo.ui.movies;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.djnr.mojo.R;
import io.djnr.mojo.model.Result;
import io.djnr.mojo.ui.detail.DetailsActivity;

/**
 * Created by Dj on 7/8/2016.
 */

public class MoviesAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInfalter;
    private List<Result> mResults;
    private static final String BASE_IMG_URL = "http://image.tmdb.org/t/p/w342/";

    static class ViewHolder implements View.OnClickListener{
        @BindView(R.id.img_poster)
        ImageView imagePoster;
        Result result;
        View view;
        Context context;

        public ViewHolder(View view, Result result){
            this.view = view;
            this.result = result;
            this.context = view.getContext();
            ButterKnife.bind(this, view);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("MOVIE_POSTER_URL",BASE_IMG_URL + result.getPosterPath());
            intent.putExtra("MOVIE_TITLE",result.getTitle());
            intent.putExtra("MOVIE_RELEASE_DATE", result.getReleaseDate());
            intent.putExtra("MOVE_RATE", result.getVoteAverage());
            intent.putExtra("MOVE_PLOT", result.getOverview());
            v.getContext().startActivity(intent);
        }
    }

    public MoviesAdapter(Context context, List<Result> results){
        mContext = context;
        mInfalter = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        mResults = results;
    }

    @Override
    public int getCount() {
        return mResults.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder(mInfalter.inflate(R.layout.grid_item_movie, parent, false), mResults.get(position));

        Glide.with(mContext)
                .load(BASE_IMG_URL + mResults.get(position).getPosterPath())
                .fitCenter()
                .crossFade()
                .into(holder.imagePoster);

        return holder.view;
    }
}