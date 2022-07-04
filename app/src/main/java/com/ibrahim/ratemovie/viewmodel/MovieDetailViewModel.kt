package com.ibrahim.ratemovie.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ibrahim.ratemovie.model.Movie



class MovieDetailViewModel (application: Application) : BaseViewModel(application)  {
    val movie = MutableLiveData<Movie>()
}