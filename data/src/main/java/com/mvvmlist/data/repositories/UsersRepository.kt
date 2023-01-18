package com.mvvmlist.data.repositories

import com.mvvmlist.data.datasource.UsersDataSource
import com.mvvmlist.domain.repositories.UsersRepository

class UsersRepository(private val usersDataSource: UsersDataSource) : UsersRepository {
    override suspend fun getUsers() = usersDataSource.getUsers()

    override suspend fun getUser(userId: Int) = usersDataSource.getUser(userId)

}