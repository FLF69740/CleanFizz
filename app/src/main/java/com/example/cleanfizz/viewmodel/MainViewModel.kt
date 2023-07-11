package com.example.cleanfizz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {



    // LIVEDATA

    private val formularyIsOk = MutableLiveData<Boolean>()
    fun getScreenValidation() = formularyIsOk

    private val formularyIsKO = MutableLiveData<Boolean>()
    fun getScreenError()= formularyIsKO


    // OBSERVATION

    fun responseValidateBtn(wordOne: String?, wordTwo: String?, numberOne: Int?, numberTwo: Int?) {
        viewModelScope.launch {
            formularyIsKO.postValue(true)
        }
    }


}