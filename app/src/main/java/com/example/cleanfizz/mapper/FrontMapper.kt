package com.example.cleanfizz.mapper

import com.example.cleanfizz.model.FrontFormulary
import com.example.cleanfizz.model.FrontItemFizzBuzz
import com.example.core.model.FizzBuzzListBusiness
import com.example.core.model.FormularyBusinessModel
import com.example.core.model.ItemFizzBuzzBusiness
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

    fun getFrontListFizzBuzz(fizzBuzzList: FizzBuzzListBusiness): FrontItemFizzBuzz{

        val listResult = mutableListOf<String>()

        fizzBuzzList.mFizzBuzzList.forEachIndexed { index, itemFizzBuzzBusiness ->
            when(itemFizzBuzzBusiness){
                is ItemFizzBuzzBusiness.IsNumber -> listResult.add((index+1).toString())
                is ItemFizzBuzzBusiness.WordItem -> listResult.add(itemFizzBuzzBusiness.data)
            }
        }

        return FrontItemFizzBuzz(listResult)
    }




}