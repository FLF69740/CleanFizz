package com.example.cleanfizz.viewmodel

import android.content.Context
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
    private val getErrorMessage = interactor.getErrorMessage


    // LIVEDATA

    private val formularyIsOk = MutableLiveData<Boolean>()
    fun getScreenValidation() = formularyIsOk

    private val formularyIsKO = MutableLiveData<String>()
    fun getScreenError()= formularyIsKO

    private val errorText = MutableLiveData<String>()
    fun getErrorText() = errorText


    // OBSERVATION

    fun responseValidateBtn(formulary: FrontFormulary, context: Context) {
        viewModelScope.launch {
            when(val result = getNextScreen.invoke(formulary = FrontMapper.frontNextScreenToBusiness(formulary), context)){
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

    fun responseErrorText(context: Context) {
        viewModelScope.launch {
            when(val result = getErrorMessage.invoke(context = context)){
                is ResultOf.Success -> errorText.postValue(FrontMapper.getErrorMessageForErrorScreen(result.data as NextScreenType.ErrorScreen))
                is ResultOf.Error -> errorText.postValue("pas bon ça")
            }
        }
    }


}