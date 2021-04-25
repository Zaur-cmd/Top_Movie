package com.example.topmovie.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

        @GET("3/movie/top_rated")
        Call<Root> getListOfMovies(
                @Query("language") String language,
                @Query("page") int page,
                @Query("api_key") String apiKey
        );
}



