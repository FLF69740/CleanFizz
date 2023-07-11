package com.example.core.repository

import android.content.Context
import com.example.core.ResultOf
import com.example.core.model.FormularyBusinessModel

interface MenuRepository {
    suspend fun saveUserData(formularyBusinessModel: FormularyBusinessModel, context: Context)
    suspend fun saveErrorData(message: String, context: Context)
    suspend fun getUserData(context: Context): ResultOf<FormularyBusinessModel>
    suspend fun getErrorData(context: Context): ResultOf<String?>
}