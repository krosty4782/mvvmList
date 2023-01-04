package com.nutmeg.core.data.datasource

import com.nutmeg.core.domain.models.Post

interface PostDataSource {
    suspend fun getPosts(): List<Post>
}