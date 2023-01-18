package com.nutmeg.mvvmlist.repositories

import com.nutmeg.data.datasource.UsersDataSource
import com.nutmeg.data.services.UsersService
import com.nutmeg.domain.models.User

class UsersDataSource(private val usersService: UsersService) :
    UsersDataSource {
    override suspend fun getUsers(): List<User> {
        return usersService.getUsers()
    }

    override suspend fun getUser(userId: Int): User {
        return usersService.getUser(userId)
    }
}