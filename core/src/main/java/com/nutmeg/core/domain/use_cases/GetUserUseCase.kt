package com.nutmeg.core.domain.use_cases

import com.nutmeg.core.data.repositories.UsersRepository
import com.nutmeg.core.domain.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserUseCase(private val usersRepository: UsersRepository) :
    BaseUseCase<User, Int> {
    override suspend fun buildUseCase(params: Int): Result<User> {
        try {
            return withContext(Dispatchers.IO) {
                val user = usersRepository.getUser(params)
                return@withContext Result.success(user)
            }

        } catch (exception: Exception) {
            return Result.failure(exception.cause ?: Throwable("Unknown Exception"))
        }
    }
}