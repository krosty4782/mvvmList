package com.mvvmlist.data.services

import com.mvvmlist.domain.models.Post
import retrofit2.http.GET

interface PostService {
    @GET("/posts")
    suspend fun getPosts() : List<Post>
}