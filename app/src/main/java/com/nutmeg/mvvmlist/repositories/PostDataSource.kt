package com.nutmeg.mvvmlist.repositories

import com.nutmeg.data.datasource.PostDataSource
import com.nutmeg.data.services.PostService
import com.nutmeg.domain.models.Post

class PostDataSource(private val potService: PostService) :
    PostDataSource {
    override suspend fun getPosts(): List<Post> {
        return potService.getPosts()
    }
}