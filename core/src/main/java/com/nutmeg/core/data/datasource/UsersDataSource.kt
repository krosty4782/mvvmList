package com.nutmeg.core.data.datasource

import com.nutmeg.core.domain.models.User

interface UsersDataSource {
    suspend fun getUsers() : List<User>
}