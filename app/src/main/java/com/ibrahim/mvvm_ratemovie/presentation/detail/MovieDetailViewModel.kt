package com.ibrahim.mvvm_ratemovie.presentation.detail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ibrahim.mvvm_ratemovie.data.local.db.dao.MovieDao
import com.ibrahim.mvvm_ratemovie.data.local.db.entity.MovieEntity
import com.ibrahim.mvvm_ratemovie.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private var movieDao: MovieDao): ViewModel() {

     val movie = MutableLiveData<Movie>()

     fun insertUserRating (rated:Int){
          val movieEntity = MovieEntity(movieId = movie.value?.id?:0, userVote = rated, posterPath = movie.value?.posterPath.toString(), title = movie.value?.title.toString(), genreIds = movie.value?.genreIds.toString(), voteAverage = movie.value?.voteAverage.toString(), releaseDate = movie.value?.releaseDate.toString())
          movieDao.insertMovie(movieEntity)
     }
}