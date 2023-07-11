package com.example.cleanfizz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanfizz.mapper.FrontMapper
import com.example.cleanfizz.model.FrontFormulary
import com.example.core.ResultOf
import com.example.core.interactor.MainInteractor
import com.example.core.model.NextScreenType
import kotlinx.coroutines.launch

class MainViewModel(interactor: MainInteractor): ViewModel() {

    private val getNextScreen = interactor.getNexScreen


    // LIVEDATA

    private val formularyIsOk = MutableLiveData<Boolean>()
    fun getScreenValidation() = formularyIsOk

    private val formularyIsKO = MutableLiveData<String>()
    fun getScreenError()= formularyIsKO


    // OBSERVATION

    fun responseValidateBtn(formulary: FrontFormulary) {
        viewModelScope.launch {
            when(val result = getNextScreen.invoke(formulary = FrontMapper.frontNextScreenToBusiness(formulary))){
                is ResultOf.Success -> {
                    when (result.data) {
                        is NextScreenType.ResultScreen -> formularyIsOk.postValue(true)
                        is NextScreenType.ErrorScreen -> formularyIsKO.postValue((result.data as NextScreenType.ErrorScreen).message )
                    }
                }
                is ResultOf.Error -> formularyIsKO.postValue("UNKNOWN ERROR")
                else -> formularyIsKO.postValue("UNKNOWN ERROR")
            }
        }
    }


}