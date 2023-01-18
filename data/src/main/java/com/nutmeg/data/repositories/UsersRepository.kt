package com.nutmeg.data.repositories

import com.nutmeg.data.datasource.UsersDataSource
import com.nutmeg.domain.repositories.UsersRepository

class UsersRepository(private val usersDataSource: UsersDataSource) : UsersRepository {
    override suspend fun getUsers() = usersDataSource.getUsers()

    override suspend fun getUser(userId: Int) = usersDataSource.getUser(userId)

}