package com.example.core.usecase

import com.example.core.ERRORS_TITLE
import com.example.core.LIMIT_ERROR
import com.example.core.NUMBER_1_ERROR
import com.example.core.NUMBER_2_ERROR
import com.example.core.ResultOf
import com.example.core.SINGLE_ERROR_TITLE
import com.example.core.WORD_1_ERROR
import com.example.core.WORD_2_ERROR
import com.example.core.convertString
import com.example.core.model.FormularyBusinessModel
import com.example.core.model.NextScreenType
import com.example.core.safeLet
import com.example.core.safeNotLet
import java.lang.StringBuilder

class GetNextScreenAfterFormularyUseCase() {

    suspend operator fun invoke(formulary: FormularyBusinessModel): ResultOf<NextScreenType>? {

        var result: ResultOf<NextScreenType>? = null
        val errorList = mutableListOf<String>()

        safeLet (formulary.numberOne,formulary.numberTwo,formulary.wordOne,formulary.wordTwo,formulary.limit){ _,_,_,_,_ ->
            result = ResultOf.Success(NextScreenType.ResultScreen)
        }

        registerError(formulary.wordOne, EnumError.WORD1, errorList)
        registerError(formulary.wordTwo, EnumError.WORD2, errorList)
        registerError(formulary.numberOne.convertString(), EnumError.NUMBER1, errorList)
        registerError(formulary.numberTwo.convertString(), EnumError.NUMBER2, errorList)
        registerError(formulary.limit.convertString(), EnumError.LIMIT, errorList)

        if (errorList.isNotEmpty()) {
            result = ResultOf.Success(NextScreenType.ErrorScreen(buildErrorMessage(errorList = errorList)))
        }

        return result
    }

    private suspend fun registerError(value: String?, enum: EnumError, errorList: MutableList<String>){
        safeNotLet (value){ _ ->
            when(enum) {
                EnumError.WORD1 -> errorList.add(WORD_1_ERROR)
                EnumError.WORD2 -> errorList.add(WORD_2_ERROR)
                EnumError.NUMBER1 -> errorList.add(NUMBER_1_ERROR)
                EnumError.NUMBER2 -> errorList.add(NUMBER_2_ERROR)
                EnumError.LIMIT -> errorList.add(LIMIT_ERROR)
            }

        }
    }

    private suspend fun buildErrorMessage(errorList: MutableList<String>): String {
        val builder = StringBuilder()
        builder.append(
            if (errorList.size > 1) {
                ERRORS_TITLE
            } else {
                builder.append(SINGLE_ERROR_TITLE)
            })
        errorList.forEach {
            builder.append(it)
        }
        return builder.toString()
    }

    enum class EnumError{
        WORD1,
        WORD2,
        NUMBER1,
        NUMBER2,
        LIMIT
    }
}