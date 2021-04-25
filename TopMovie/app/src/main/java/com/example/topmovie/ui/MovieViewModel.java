package com.example.topmovie.ui;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.topmovie.api.MovieApi;
import com.example.topmovie.api.MovieApiTop;
import com.example.topmovie.api.Result;
import com.example.topmovie.api.Root;
import com.example.topmovie.api.TvApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieViewModel extends ViewModel {

    private String API_KEY = "2a3613f525ae0e69aa9dc225cf6658ab";
    private int PAGE = 1;
    private String language = "en-US";
    private static final String ROOTURL = "https://api.themoviedb.org/";

    /**
     * Все лайвдаты:
     * 1) Популярные фильмы
     * 2)
     * 3)
     */
    private MutableLiveData<List<Result>> popularMoviesLiveData = new MutableLiveData<List<Result>>();

    private MutableLiveData<List<Result>> topMoviesLiveData = new MutableLiveData<List<Result>>();

    private MutableLiveData<List<Result>> tvMoviesLiveData = new MutableLiveData<List<Result>>();


    public MutableLiveData getPopularMoviesLiveData() {
        return this.popularMoviesLiveData;
    }
    public MutableLiveData gettopMoviesLiveData() {
        return this.topMoviesLiveData;
    }
    public MutableLiveData gettvMoviesLiveData() {
        return this.tvMoviesLiveData;
    }


    // Retrofit
    private Retrofit getRetroInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOTURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /** Популярные фильмы */
    private MovieApi getMovieApi() {
        return getRetroInstance().create(MovieApi.class);
    }
    private MovieApiTop getMovieApiTop(){return getRetroInstance().create(MovieApiTop.class);

    }
    private TvApi getTvApi(){
        return getRetroInstance().create(TvApi.class);
    }


    public void initPopularMovies() {

        getMovieApi().getListOfMovies(
                language,
                PAGE,
                API_KEY
        ).enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (!response.isSuccessful())return;
                if (response.body() != null) {
                    List<Result> listOfResults = response.body().getResults();
                    popularMoviesLiveData.postValue(listOfResults);

                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.d("ERROR_TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    private MovieApiTop movieApiTop() {
        return (MovieApiTop) getRetroInstance().create(MovieApi.class);
    }

    public void initTopMovies() {

        getMovieApiTop().getListOfMovies(
                language,
                PAGE,
                API_KEY
        ).enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (!response.isSuccessful())return;
                if (response.body() != null) {
                    List<Result> listOfResults = response.body().getResults();
                    topMoviesLiveData.postValue(listOfResults);

                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.d("ERROR_TAG", "onFailure: " + t.getMessage());
            }
        });
    }
    private TvApi tvApi() {
        return (TvApi) getRetroInstance().create(MovieApi.class);
    }



    public void initTopTv() {



        getTvApi().getListOfMovies(
                language,
                PAGE,
                API_KEY
        ).enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (!response.isSuccessful())return;
                if (response.body() != null) {
                    List<Result> listOfResults = response.body().getResults();
                    tvMoviesLiveData.postValue(listOfResults);
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.d("ERROR_TAG", "onFailure: " + t.getMessage());
            }
        });
    }


    //  2)----- фильмы */

    //  3)----- фильмы */
}
