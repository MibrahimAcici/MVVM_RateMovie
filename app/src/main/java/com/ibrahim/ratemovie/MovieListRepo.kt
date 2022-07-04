package com.ibrahim.ratemovie


import com.ibrahim.ratemovie.service.MovieService


class MovieListRepo constructor(private val movieAPI: MovieService) {
    fun getPlaceService() = movieAPI
}