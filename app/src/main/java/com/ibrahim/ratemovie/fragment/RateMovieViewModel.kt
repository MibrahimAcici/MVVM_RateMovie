package com.ibrahim.ratemovie.fragment

import android.app.Application
import com.ibrahim.ratemovie.db.Database
import com.ibrahim.ratemovie.viewmodel.BaseViewModel

class RateMovieViewModel(application: Application) : BaseViewModel(application) {

    fun getRatedMoviesByRate(rate:Int) = Database.getDatabase(getApplication()).moviedao().getRateMoviesByRate(rate)
}