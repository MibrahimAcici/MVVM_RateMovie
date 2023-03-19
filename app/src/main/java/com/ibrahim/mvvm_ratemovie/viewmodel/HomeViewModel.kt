package com.ibrahim.mvvm_ratemovie.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ibrahim.mvvm_ratemovie.model.Movie
import com.ibrahim.mvvm_ratemovie.model.MoviesResponse
import com.ibrahim.mvvm_ratemovie.service.MovieAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel(application: Application) : BaseViewModel(application) {

    private var movieAPIService = MovieAPI() // Servisimizi tanımladık.
    //var movieListLiveData: MutableLiveData<MoviesResponse> = MutableLiveData() //Livedatamı tanımladım.

    val movieList = MutableLiveData<List<Movie?>>()

    fun fetchMovies() {
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
