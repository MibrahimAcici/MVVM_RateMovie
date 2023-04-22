package com.ibrahim.mvvm_ratemovie.data.remote.repository

import com.ibrahim.mvvm_ratemovie.data.remote.MovieApiService
import com.ibrahim.mvvm_ratemovie.domain.model.MoviesResponse
import retrofit2.Call
import javax.inject.Inject

class AllMoviesRepository @Inject constructor(
    private val movieApiService: MovieApiService) {

    fun getAllMovies(): Call<MoviesResponse> {
        return movieApiService.getAllMovies()
    }

}