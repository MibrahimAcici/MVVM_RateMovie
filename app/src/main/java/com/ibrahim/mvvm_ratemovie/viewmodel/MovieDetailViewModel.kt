package com.ibrahim.mvvm_ratemovie.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ibrahim.mvvm_ratemovie.model.Movie



class MovieDetailViewModel (application: Application) : BaseViewModel(application)  {
    val movie = MutableLiveData<Movie>()
}