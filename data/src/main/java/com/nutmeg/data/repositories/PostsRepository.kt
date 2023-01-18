package com.nutmeg.data.repositories

import com.nutmeg.data.datasource.PostDataSource
import com.nutmeg.domain.repositories.PostsRepository

class PostsRepository(private val dataSource: PostDataSource) : PostsRepository {
    override suspend fun getPosts() = dataSource.getPosts()
}