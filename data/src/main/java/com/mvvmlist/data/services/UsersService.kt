package com.mvvmlist.data.services

import com.mvvmlist.domain.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersService {
    @GET("/users")
    suspend fun getUsers(): List<User>

    @GET("/users/{userId}")
    suspend fun getUser(@Path("userId")userId: Int): User
}