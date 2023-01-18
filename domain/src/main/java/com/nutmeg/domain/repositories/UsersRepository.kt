package com.nutmeg.domain.repositories

import com.nutmeg.domain.models.User

interface UsersRepository {
    suspend fun getUsers() : List<User>

    suspend fun getUser(userId: Int) : User
}