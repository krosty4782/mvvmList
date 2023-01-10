package com.nutmeg.mvvmlist.repositories

import com.nutmeg.core.data.datasource.PostDataSource
import com.nutmeg.core.data.services.PostService
import com.nutmeg.core.domain.models.Post

class PostDataSourceImp(private val potService: PostService) : PostDataSource {
    override suspend fun getPosts(): List<Post> {
        return potService.getPosts()
    }
}