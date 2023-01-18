package com.nutmeg.data.services

import com.nutmeg.domain.models.Post
import retrofit2.http.GET

interface PostService {
    @GET("/posts")
    suspend fun getPosts() : List<Post>
}