package com.mvvmlist.data.repositories

import com.mvvmlist.data.datasource.PostDataSource
import com.mvvmlist.domain.repositories.PostsRepository

class PostsRepository(private val dataSource: PostDataSource) : PostsRepository {
    override suspend fun getPosts() = dataSource.getPosts()
}