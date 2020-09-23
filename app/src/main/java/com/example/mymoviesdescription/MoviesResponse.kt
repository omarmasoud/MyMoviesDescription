package com.example.mymoviesdescription

import com.example.moviesappinkotlin.MyMovie
import com.google.gson.annotations.SerializedName

data class MoviesResponse (
    @SerializedName("results") val myMovies : MutableList<MyMovie>,
    @SerializedName("page") val currentPage : Int,
    @SerializedName("total_pages") val totalPages : Int
)