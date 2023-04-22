package com.ibrahim.mvvm_ratemovie.presentation.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ibrahim.mvvm_ratemovie.domain.model.Movie
import com.ibrahim.mvvm_ratemovie.domain.usecase.AllMoviesUsecase

import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel@Inject constructor(
    private val allMoviesUsecase: AllMoviesUsecase
): ViewModel() {
    init {
        allMoviesUsecase.getAllMovies()
    }
    val movieResponse = allMoviesUsecase.allMovies
    val error = allMoviesUsecase.errorLiveData




}


/* @Inject constructor(application: Application): ViewModel() {

    var errorLiveData: MutableLiveData<String> = MutableLiveData()
    private var movieAPIService = MovieAPI() // Servisimizi tanımladık.
    //var movieListLiveData: MutableLiveData<MoviesResponse> = MutableLiveData() //Livedatamı tanımladım.

    val movieList = MutableLiveData<List<Movie?>>()

    fun getAllMovies() {
        movieAPIService.getMovieService().getMovies("d8645a71bef876249378e16b83434d01","en-US",1)
            .enqueue(object : Callback<MoviesResponse> {
                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                    movieList.value = response.body()?.results ?: emptyList()
                }
                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    errorLiveData.value = "Filmler çekilemedi."
                }
            })
    }
}
*/