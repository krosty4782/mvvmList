package com.nutmeg.core.data.services

import com.nutmeg.core.domain.models.Post
import retrofit2.http.GET

interface PostService {
    @GET("/posts")
    suspend fun getPosts() : List<Post>
}