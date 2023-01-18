package com.mvvmlist.repositories

import com.mvvmlist.data.datasource.PostDataSource
import com.mvvmlist.data.services.PostService
import com.mvvmlist.domain.models.Post

class PostDataSource(private val potService: PostService) :
    PostDataSource {
    override suspend fun getPosts(): List<Post> {
        return potService.getPosts()
    }
}