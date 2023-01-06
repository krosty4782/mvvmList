package com.nutmeg.core.domain.repositories

interface FavouritesRepository {
    suspend fun isFavourite(postId: String): Boolean

    suspend fun storeFavourite(postId: String)

    suspend fun deleteFavourite(postId: String)
}