package com.nutmeg.domain.repositories

import com.nutmeg.domain.models.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
}