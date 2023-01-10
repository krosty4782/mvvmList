package com.nutmeg.core.data.datasource

interface FavouritesDataSource {
    suspend fun isFavourite(postId: Int): Boolean

    suspend fun storeFavourite(postId: Int)

    suspend fun deleteFavourite(postId: Int)
}