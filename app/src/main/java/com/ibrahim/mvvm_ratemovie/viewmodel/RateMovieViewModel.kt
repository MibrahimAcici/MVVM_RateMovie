package com.ibrahim.mvvm_ratemovie.viewmodel

import android.app.Application
import com.ibrahim.mvvm_ratemovie.db.Database

class RateMovieViewModel(application: Application) : BaseViewModel(application) {

    fun getRatedMoviesByRate(rate:Int) = Database.getDatabase(getApplication()).moviedao().getRateMoviesByRate(rate)
}