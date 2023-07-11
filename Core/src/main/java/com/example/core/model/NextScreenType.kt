package com.example.core.model

sealed class NextScreenType {
    object ResultScreen: NextScreenType()

    data class ErrorScreen(
        val message: String
    ): NextScreenType()
}