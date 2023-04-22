package com.ibrahim.mvvm_ratemovie.data.local.repository

import androidx.lifecycle.LiveData
import com.ibrahim.mvvm_ratemovie.data.local.db.dao.MovieDao
import com.ibrahim.mvvm_ratemovie.data.local.db.entity.MovieEntity
import javax.inject.Inject

class RateMoviesRepository @Inject constructor(
        private val movieDao: MovieDao) {

    fun getRatedMoviesByRate(rate:Int): LiveData<List<MovieEntity>> {
        return movieDao.getRateMoviesByRate(rate)
    }

}