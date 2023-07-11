package com.example.core.usecase

import com.example.core.repository.MenuRepository

class GetErrorMessageUseCase(private val menuRepository: MenuRepository) {

    suspend operator fun invoke()

}