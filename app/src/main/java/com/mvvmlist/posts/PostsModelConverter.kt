package com.mvvmlist.posts

import com.mvvmlist.domain.models.PostWithUser
import javax.inject.Inject

class PostsModelConverter @Inject constructor(){

    fun convert(posts: List<PostWithUser>?): List<PostsModel>? {
        val postsModel = posts?.map {
            PostsModel(
                title = it.post.title,
                body = it.post.body,
                username = it.user.username,
                isFavourite = it.isFavourite,
                userId = it.user.id,
                postId = it.post.id
            )
        }
        return postsModel?.toMutableList()
    }
}