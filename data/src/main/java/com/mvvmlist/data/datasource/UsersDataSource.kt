package com.mvvmlist.data.datasource

import com.mvvmlist.domain.models.User

interface UsersDataSource {
    suspend fun getUsers() : List<User>

    suspend fun getUser(userId: Int) : User
}