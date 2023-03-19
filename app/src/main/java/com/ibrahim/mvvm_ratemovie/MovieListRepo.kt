package com.ibrahim.mvvm_ratemovie


import com.ibrahim.mvvm_ratemovie.service.MovieService


class MovieListRepo constructor(private val movieAPI: MovieService) {
    fun getPlaceService() = movieAPI
}