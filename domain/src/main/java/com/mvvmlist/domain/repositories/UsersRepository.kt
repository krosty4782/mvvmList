package com.mvvmlist.domain.repositories

import com.mvvmlist.domain.models.User

interface UsersRepository {
    suspend fun getUsers() : List<User>

    suspend fun getUser(userId: Int) : User
}