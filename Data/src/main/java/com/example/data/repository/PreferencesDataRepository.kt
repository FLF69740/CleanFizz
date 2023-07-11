package com.example.data.repository

import android.content.Context
import com.example.core.ResultOf
import com.example.core.model.FormularyBusinessModel

interface PreferencesDataRepository {
    suspend fun saveDataToPreferences(formulary: FormularyBusinessModel, context: Context)
    suspend fun getPreferencesData(context: Context): ResultOf<FormularyBusinessModel>
}