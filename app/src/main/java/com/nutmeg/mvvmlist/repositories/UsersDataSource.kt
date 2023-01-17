package com.nutmeg.mvvmlist.repositories

import com.nutmeg.core.data.datasource.UsersDataSource
import com.nutmeg.core.data.services.UsersService
import com.nutmeg.core.domain.models.User

class UsersDataSource(private val usersService: UsersService) :
    UsersDataSource {
    override suspend fun getUsers(): List<User> {
        return usersService.getUsers()
    }

    override suspend fun getUser(userId: Int): User {
        return usersService.getUser(userId)
    }
}