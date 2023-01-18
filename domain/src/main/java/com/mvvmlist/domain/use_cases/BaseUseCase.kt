package com.mvvmlist.domain.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

interface BaseUseCase<out Type, in Params> where Type : Any {

    val callbackDispatcher: CoroutineContext
        get() = Dispatchers.Main

    suspend fun buildUseCase(params: Params? = null): Result<Type>


    suspend operator fun invoke(params: Params?, onSuccess: (Type) -> Unit, onFailure: (Throwable) -> Unit) {
        val result = buildUseCase(params)

        coroutineScope {
            launch(callbackDispatcher) {
                result.fold(
                    onFailure = onFailure,
                    onSuccess = onSuccess
                )
            }
        }
    }
}