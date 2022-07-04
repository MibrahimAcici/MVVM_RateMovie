package com.ibrahim.ratemovie.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel(application: Application) : AndroidViewModel(application){

    var errorLiveData: MutableLiveData<String> = MutableLiveData()


}