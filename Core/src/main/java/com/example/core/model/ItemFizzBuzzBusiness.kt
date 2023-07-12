package com.example.core.model

sealed class ItemFizzBuzzBusiness {

    object IsNumber : ItemFizzBuzzBusiness()

    data class WordItem(
        val data: String
    ) : ItemFizzBuzzBusiness()
}