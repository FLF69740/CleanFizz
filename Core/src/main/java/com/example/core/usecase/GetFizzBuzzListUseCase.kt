package com.example.core.usecase

import android.content.Context
import com.example.core.ResultOf
import com.example.core.doIfFailure
import com.example.core.doIfSuccess
import com.example.core.model.FizzBuzzListBusiness
import com.example.core.model.FormularyBusinessModel
import com.example.core.model.ItemFizzBuzzBusiness
import com.example.core.repository.MenuRepository
import java.lang.Exception

class GetFizzBuzzListUseCase(private val menuRepository: MenuRepository) {

    suspend operator fun  invoke(context: Context): ResultOf<FizzBuzzListBusiness> {

        val formularyData = menuRepository.getUserData(context = context)
        val listResult = mutableListOf<ItemFizzBuzzBusiness>()

        formularyData.doIfSuccess { formulary ->

            val counter = List(formulary.limit ?: 0){it+1}

            counter.forEach {
                listResult.add(createItemFizzBuzz(it, formulary = formulary))
            }

        }

        formularyData.doIfFailure {
            return ResultOf.Error(Exception("UNKNOWN ERROR"))
        }

        return ResultOf.Success(FizzBuzzListBusiness(listResult))
    }

    private fun createItemFizzBuzz(count: Int, formulary: FormularyBusinessModel): ItemFizzBuzzBusiness {
        var response = ""

        response += checkWord(counter = count, number = formulary.numberOne ?: 0, word = formulary.wordOne ?: "")
        response += checkWord(counter = count, number = formulary.numberTwo ?: 0, word = formulary.wordTwo ?: "")

        return if (response == "") {
            ItemFizzBuzzBusiness.IsNumber
        } else {
            ItemFizzBuzzBusiness.WordItem(response)
        }
    }

    private fun checkWord(counter: Int, number: Int, word: String): String = if (counter % number == 0) word else ""

}