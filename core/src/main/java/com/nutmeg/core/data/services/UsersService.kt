package com.nutmeg.core.data.services

import com.nutmeg.core.domain.models.User
import retrofit2.http.GET

interface UsersService {
    @GET("/users")
    suspend fun getUsers(): List<User>
}