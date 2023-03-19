package com.ibrahim.mvvm_ratemovie.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

abstract class BaseViewModel(application: Application) : AndroidViewModel(application){

    var errorLiveData: MutableLiveData<String> = MutableLiveData()


}