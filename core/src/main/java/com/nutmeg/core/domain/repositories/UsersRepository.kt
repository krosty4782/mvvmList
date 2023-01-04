package com.nutmeg.core.domain.repositories

import com.nutmeg.core.domain.models.User

interface UsersRepository {
    suspend fun getUsers() : List<User>
}