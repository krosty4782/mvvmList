package com.mvvmlist.data.datasource

import com.mvvmlist.domain.models.Post

interface PostDataSource {
    suspend fun getPosts(): List<Post>
}