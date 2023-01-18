package com.nutmeg.data.datasource

import com.nutmeg.domain.models.Post

interface PostDataSource {
    suspend fun getPosts(): List<Post>
}