package com.ibrahim.mvvm_ratemovie.domain.usecase

import com.ibrahim.mvvm_ratemovie.data.local.repository.RateMoviesRepository
import javax.inject.Inject

class RateMoviesUsecase @Inject constructor(private val rateMoviesRepository: RateMoviesRepository) {

    fun getRatedMoviesByRate(rate: Int) = rateMoviesRepository.getRatedMoviesByRate(rate)

}