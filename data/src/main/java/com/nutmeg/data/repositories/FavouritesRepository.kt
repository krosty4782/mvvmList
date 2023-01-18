package com.nutmeg.data.repositories

import com.nutmeg.data.datasource.FavouritesDataSource
import com.nutmeg.domain.repositories.FavouritesRepository

class FavouritesRepository(private val favouritesDataSource: FavouritesDataSource) :
    FavouritesRepository {
    override suspend fun isFavourite(postId: Int) = favouritesDataSource.isFavourite(postId)

    override suspend fun storeFavourite(postId: Int) = favouritesDataSource.storeFavourite(postId)

    override suspend fun deleteFavourite(postId: Int) = favouritesDataSource.deleteFavourite(postId)

}