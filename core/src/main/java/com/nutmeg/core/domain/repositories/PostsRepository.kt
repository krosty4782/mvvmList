package com.nutmeg.core.domain.repositories

import com.nutmeg.core.domain.models.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
}