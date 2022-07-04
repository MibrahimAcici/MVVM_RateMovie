package com.ibrahim.ratemovie.viewmodel

import android.app.Application
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import com.ibrahim.ratemovie.adapter.MovieAdapter
import com.ibrahim.ratemovie.model.Movie
import com.ibrahim.ratemovie.model.MoviesResponse
import com.ibrahim.ratemovie.service.MovieAPI
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
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
