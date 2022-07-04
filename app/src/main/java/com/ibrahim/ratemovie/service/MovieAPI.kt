package com.ibrahim.ratemovie.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieAPI {
//https://api.themoviedb.org/3/movie/top_rated?api_key=d8645a71bef876249378e16b83434d01
    private val BASE_URL = "https://api.themoviedb.org"

    private val movieApi: MovieService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieService::class.java)

    fun getMovieService() = movieApi
}
//https://api.themoviedb.org/3/movie/top_rated?api_key=d8645a71bef876249378e16b83434d01
//https://api.themoviedb.org/3/movie/top_rated?api_key=d8645a71bef876249378e16b83434d01&page=2
//https://api.themoviedb.org/3/search/movie?api_key=d8645a71bef876249378e16b83434d01&query=Jack+Reacher
//https://api.themoviedb.org/3/movie/343611?api_key=d8645a71bef876249378e16b83434d01