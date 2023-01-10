package com.nutmeg.mvvmlist.posts

import com.nutmeg.core.domain.models.PostWithUser

class PostsModelConverter {

    fun convert(posts: List<PostWithUser>?): MutableList<PostsModel>? {
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