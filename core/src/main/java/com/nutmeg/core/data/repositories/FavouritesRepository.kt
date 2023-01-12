package com.nutmeg.core.data.repositories

import com.nutmeg.core.data.datasource.FavouritesDataSource
import com.nutmeg.core.domain.repositories.FavouritesRepository

class FavouritesRepository(private val favouritesDataSource: FavouritesDataSource) :
    FavouritesRepository {
    override suspend fun isFavourite(postId: Int) = favouritesDataSource.isFavourite(postId)

    override suspend fun storeFavourite(postId: Int) = favouritesDataSource.storeFavourite(postId)

    override suspend fun deleteFavourite(postId: Int) = favouritesDataSource.deleteFavourite(postId)

}