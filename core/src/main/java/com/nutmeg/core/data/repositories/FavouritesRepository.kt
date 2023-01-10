package com.nutmeg.core.data.repositories

import com.nutmeg.core.data.datasource.FavouritesDataSource
import com.nutmeg.core.domain.repositories.FavouritesRepository

class FavouritesRepository(private val favouritesDataSource: FavouritesDataSource) :
    FavouritesRepository {
    override suspend fun isFavourite(postId: Int): Boolean {
        return favouritesDataSource.isFavourite(postId)
    }

    override suspend fun storeFavourite(postId: Int) {
        return favouritesDataSource.storeFavourite(postId)
    }

    override suspend fun deleteFavourite(postId: Int) {
        return favouritesDataSource.deleteFavourite(postId)
    }

}