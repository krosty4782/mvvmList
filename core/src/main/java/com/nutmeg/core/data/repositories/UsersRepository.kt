package com.nutmeg.core.data.repositories

import com.nutmeg.core.data.datasource.UsersDataSource
import com.nutmeg.core.domain.models.User
import com.nutmeg.core.domain.repositories.UsersRepository

class UsersRepository(private val usersDataSource: UsersDataSource) : UsersRepository {
    override suspend fun getUsers(): List<User> {
        return usersDataSource.getUsers()
    }
}