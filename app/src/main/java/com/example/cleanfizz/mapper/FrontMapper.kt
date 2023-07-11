package com.example.cleanfizz.mapper

import com.example.cleanfizz.model.FrontFormulary
import com.example.core.model.FormularyBusinessModel
import com.example.core.model.NextScreenType

object FrontMapper {

    fun frontNextScreenToBusiness(formulary: FrontFormulary): FormularyBusinessModel = FormularyBusinessModel(
        wordOne = formulary.wordOne,
        wordTwo = formulary.wordTwo,
        numberOne = formulary.numberOne,
        numberTwo = formulary.numberTwo,
        limit = formulary.limit
    )

    fun getErrorMessageForErrorScreen(nextType: NextScreenType.ErrorScreen) = nextType.message
}