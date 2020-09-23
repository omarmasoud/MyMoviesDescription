package com.example.moviesappinkotlin

import com.example.mymoviesdescription.ApiServices
import com.example.mymoviesdescription.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesClient {
    val BASE_URL = "https://api.themoviedb.org/3/"
    val service: ApiServices


    init {
       val retrofit = Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()

            service = retrofit.create(ApiServices::class.java)
    }

    fun fetchPopularMovies(page: Int = 1,
                           onSuccess: (moviesList: MutableList<MyMovie>) -> Unit,
                           onError: () -> Unit
    ){
        service.getPopularMovies(pageNumber = page)
            .enqueue(object : Callback<MoviesResponse> {
                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    onError.invoke()
                }

                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                    if(response.isSuccessful){
                        if(response.body() != null){
                           onSuccess.invoke(response.body()!!.myMovies)
                        } else {
                           onError.invoke()
                        }

                    }

                }

            })
    }
}