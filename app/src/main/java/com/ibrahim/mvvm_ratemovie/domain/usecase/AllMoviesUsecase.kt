package com.ibrahim.mvvm_ratemovie.domain.usecase


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ibrahim.mvvm_ratemovie.data.remote.repository.AllMoviesRepository
import com.ibrahim.mvvm_ratemovie.domain.model.Movie
import com.ibrahim.mvvm_ratemovie.domain.model.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Inject

class AllMoviesUsecase @Inject constructor(private val allMoviesRepository: AllMoviesRepository) {

    private var _allMovies = MutableLiveData<MoviesResponse>()
    val allMovies: LiveData<MoviesResponse> = _allMovies
    var errorLiveData: MutableLiveData<String> = MutableLiveData()

    val movie = MutableLiveData<Movie>()

    fun getAllMovies(/*page:Int*/){
        allMoviesRepository.getAllMovies().enqueue(object : Callback<MoviesResponse>{
            override fun onResponse(call: Call<MoviesResponse>, response: retrofit2.Response<MoviesResponse>) {
                _allMovies.value = response.body()
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                errorLiveData.value = t.message
            }

        } )
    }



}