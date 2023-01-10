package com.nutmeg.core.domain.repositories

interface FavouritesRepository {
    suspend fun isFavourite(postId: Int): Boolean

    suspend fun storeFavourite(postId: Int)

    suspend fun deleteFavourite(postId: Int)
}