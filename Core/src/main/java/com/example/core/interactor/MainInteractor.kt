package com.example.core.interactor

import com.example.core.usecase.GetErrorMessageUseCase
import com.example.core.usecase.GetNextScreenAfterFormularyUseCase

data class MainInteractor (
    val getNexScreen: GetNextScreenAfterFormularyUseCase,
    val getErrorMessage: GetErrorMessageUseCase
)