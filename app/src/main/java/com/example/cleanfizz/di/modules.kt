package com.example.cleanfizz.di

import com.example.cleanfizz.viewmodel.MainViewModel
import com.example.core.interactor.MainInteractor
import com.example.core.usecase.GetNextScreenAfterFormularyUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // USE CASES
    single { GetNextScreenAfterFormularyUseCase() }

    single { MainInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}