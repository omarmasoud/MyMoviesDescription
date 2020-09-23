package com.example.mymoviesdescription

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") Key : String = "a17b5a5150dd1a33cde3709c335ef796",
        @Query("page") pageNumber: Int = 1
    ) : Call<MoviesResponse>
}