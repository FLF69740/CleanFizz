package com.example.core.usecase

import android.content.Context
import com.example.core.ResultOf
import com.example.core.doIfSuccess
import com.example.core.model.NextScreenType
import com.example.core.repository.MenuRepository

class GetErrorMessageUseCase(private val menuRepository: MenuRepository) {

    suspend operator fun invoke(context: Context): ResultOf<NextScreenType> {

        var nxType: NextScreenType.ErrorScreen = NextScreenType.ErrorScreen("Unknown error")

        val data = menuRepository.getErrorData(context = context)

        data.doIfSuccess {
            nxType = NextScreenType.ErrorScreen(it ?: "")
        }

        return ResultOf.Success(nxType)
    }

}