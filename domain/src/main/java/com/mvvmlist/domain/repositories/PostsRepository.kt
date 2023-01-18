package com.mvvmlist.domain.repositories

import com.mvvmlist.domain.models.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
}