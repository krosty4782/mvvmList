package com.nutmeg.core.data.repositories

import com.nutmeg.core.data.datasource.FavouritesDataSource
import com.nutmeg.core.domain.repositories.FavouritesRepository

class FavouritesRepository(private val favouritesDataSource: FavouritesDataSource) :
    FavouritesRepository {
    override suspend fun isFavourite(postId: String): Boolean {
        return favouritesDataSource.isFavourite(postId)
    }

    override suspend fun storeFavourite(postId: String) {
        return favouritesDataSource.storeFavourite(postId)
    }

    override suspend fun deleteFavourite(postId: String) {
        return favouritesDataSource.deleteFavourite(postId)
    }

}