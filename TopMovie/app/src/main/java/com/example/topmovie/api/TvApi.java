package com.example.topmovie.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TvApi {
    @GET("3/movie/now_playing")
    Call<Root> getListOfMovies(
            @Query("language") String language,
            @Query("page") int page,
            @Query("api_key") String apiKey
    );

}
