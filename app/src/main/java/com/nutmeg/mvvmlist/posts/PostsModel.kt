package com.nutmeg.mvvmlist.posts

data class PostsModel(
    val title: String,
    val body: String,
    val username: String,
    val isFavourite: Boolean,
    val userId: Int,
    val postId: Int
)