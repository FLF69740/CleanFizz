package com.example.data.repository

import android.content.Context
import com.example.core.ResultOf
import com.example.core.model.FormularyBusinessModel
import com.example.core.repository.MenuRepository

class MenuRepositoryImpl(private val preferencesDataRepository: PreferencesDataRepository): MenuRepository {
    override suspend fun saveUserData(formularyBusinessModel: FormularyBusinessModel, context: Context) {
        preferencesDataRepository.saveDataToPreferences(formulary = formularyBusinessModel, context = context)
    }

    override suspend fun getUserData(context: Context): ResultOf<FormularyBusinessModel> = preferencesDataRepository.getPreferencesData(context)
}