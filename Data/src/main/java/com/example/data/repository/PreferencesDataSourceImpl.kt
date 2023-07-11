package com.example.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.core.ResultOf
import com.example.core.SHARED_PREF_LIMIT
import com.example.core.SHARED_PREF_LIMIT_VALUE
import com.example.core.SHARED_PREF_NUMBER_ONE
import com.example.core.SHARED_PREF_NUMBER_ONE_VALUE
import com.example.core.SHARED_PREF_NUMBER_TWO
import com.example.core.SHARED_PREF_WORD_ONE
import com.example.core.SHARED_PREF_WORD_ONE_VALUE
import com.example.core.SHARED_PREF_WORD_TWO
import com.example.core.SHARED_PREF_WORD_TWO_VALUE
import com.example.core.model.FormularyBusinessModel

class PreferencesDataSourceImpl: PreferencesDataRepository {
    override suspend fun saveDataToPreferences(formulary: FormularyBusinessModel, context: Context) {
        context.getSharedPreferences(SHARED_PREF_WORD_ONE, 0)
            .edit()
            .putString(SHARED_PREF_WORD_ONE_VALUE, formulary.wordOne)
            .apply()

        context.getSharedPreferences(SHARED_PREF_WORD_TWO, 0)
            .edit()
            .putString(SHARED_PREF_WORD_TWO_VALUE, formulary.wordTwo)
            .apply()

        context.getSharedPreferences(SHARED_PREF_NUMBER_ONE, 0)
            .edit()
            .putInt(SHARED_PREF_NUMBER_ONE_VALUE, formulary.numberOne ?: 0)
            .apply()

        context.getSharedPreferences(SHARED_PREF_NUMBER_TWO, 0)
            .edit()
            .putInt(SHARED_PREF_WORD_TWO_VALUE, formulary.numberTwo ?: 0)
            .apply()

        context.getSharedPreferences(SHARED_PREF_LIMIT, 0)
            .edit()
            .putInt(SHARED_PREF_LIMIT_VALUE, formulary.limit ?: 0)
            .apply()
    }

    override suspend fun getPreferencesData(context: Context): ResultOf<FormularyBusinessModel> = ResultOf.Success(
        FormularyBusinessModel(
            context.getSharedPreferences(SHARED_PREF_WORD_ONE, 0).getString(SHARED_PREF_WORD_ONE_VALUE, null),
            context.getSharedPreferences(SHARED_PREF_WORD_TWO, 0).getString(SHARED_PREF_WORD_TWO_VALUE, null),
            context.getSharedPreferences(SHARED_PREF_NUMBER_ONE, 0).getInt(SHARED_PREF_NUMBER_ONE_VALUE, 0),
            context.getSharedPreferences(SHARED_PREF_NUMBER_TWO, 0).getInt(SHARED_PREF_WORD_TWO_VALUE, 0),
            context.getSharedPreferences(SHARED_PREF_LIMIT, 0).getInt(SHARED_PREF_LIMIT_VALUE, 0)
        )
    )

}