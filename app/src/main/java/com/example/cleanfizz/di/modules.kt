package com.example.cleanfizz.di

import com.example.cleanfizz.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

}

val viewModelModule = module {
    viewModel { MainViewModel() }
}