package com.example.cleanfizz.di

import com.example.cleanfizz.viewmodel.MainViewModel
import com.example.core.interactor.MainInteractor
import com.example.core.repository.MenuRepository
import com.example.core.usecase.GetNextScreenAfterFormularyUseCase
import com.example.data.repository.MenuRepositoryImpl
import com.example.data.repository.PreferencesDataRepository
import com.example.data.repository.PreferencesDataSourceImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // DATA
    factory<PreferencesDataRepository> { PreferencesDataSourceImpl() }
    factory<MenuRepository> { MenuRepositoryImpl(get()) }

    // USE CASES
    single { GetNextScreenAfterFormularyUseCase(get()) }

    single { MainInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}