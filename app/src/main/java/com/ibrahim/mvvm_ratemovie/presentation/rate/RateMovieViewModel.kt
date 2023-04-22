package com.ibrahim.mvvm_ratemovie.presentation.rate

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ibrahim.mvvm_ratemovie.data.local.db.entity.MovieEntity
import com.ibrahim.mvvm_ratemovie.domain.usecase.RateMoviesUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RateMovieViewModel@Inject constructor(
    private val rateMoviesUsecase: RateMoviesUsecase
): ViewModel() {

    fun ratedMovie(rate:Int): LiveData<List<MovieEntity>> {
        return rateMoviesUsecase.getRatedMoviesByRate(rate)
    }


}
