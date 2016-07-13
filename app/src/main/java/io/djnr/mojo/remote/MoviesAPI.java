package io.djnr.mojo.remote;

import io.djnr.mojo.model.Movies;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Dj on 7/7/2016.
 */
public interface MoviesAPI {
    public static final String BASE_URL = "http://api.themoviedb.org/3/movie/";
//    Add MovieDB api key below
    public static final String API_KEY = "";

    @GET("popular?api_key="+API_KEY)
    Call<Movies> popularMovies();

    @GET("top_rated?api_key="+API_KEY)
    Call<Movies> topRatedMovies();

    class Factory{
        private static MoviesAPI service;

        public static MoviesAPI getInstance(){

            if(service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                service = retrofit.create(MoviesAPI.class);
            }

            return service;
        }

    }
}
