package com.nutmeg.core.data.datasource

interface FavouritesDataSource {
    suspend fun isFavourite(postId: String): Boolean

    suspend fun storeFavourite(postId: String)

    suspend fun deleteFavourite(postId: String)
}