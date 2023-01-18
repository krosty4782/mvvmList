package com.mvvmlist.repositories

import com.mvvmlist.data.datasource.FavouritesDataSource
import com.mvvmlist.data.services.FavouritesService

class FavouritesDataSource(private val favouritesService: FavouritesService):
    FavouritesDataSource {
    override suspend fun isFavourite(postId: Int): Boolean {
        return favouritesService.isFavourite(postId)
    }

    override suspend fun storeFavourite(postId: Int) {
        return favouritesService.storeFavourite(postId)
    }

    override suspend fun deleteFavourite(postId: Int) {
        return favouritesService.deleteFavourite(postId)
    }
}