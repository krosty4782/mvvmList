package com.nutmeg.core.data.repositories

import com.nutmeg.core.data.datasource.PostDataSource
import com.nutmeg.core.domain.models.Post
import com.nutmeg.core.domain.repositories.PostsRepository

class PostsRepository(private val dataSource: PostDataSource) : PostsRepository {
    override suspend fun getPosts() = dataSource.getPosts()
}