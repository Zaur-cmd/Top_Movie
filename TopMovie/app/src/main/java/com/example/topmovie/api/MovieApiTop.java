package com.example.topmovie.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiTop {
    @GET("3/movie/popular")
    Call<Root> getListOfMovies(
            @Query("language") String language,
            @Query("page") int page,
            @Query("api_key") String apiKey
    );
}

