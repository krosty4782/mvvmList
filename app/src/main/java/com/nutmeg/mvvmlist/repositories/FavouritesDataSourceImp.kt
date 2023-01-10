package com.nutmeg.mvvmlist.repositories

import com.nutmeg.core.data.datasource.FavouritesDataSource
import com.nutmeg.core.data.services.FavouritesService

class FavouritesDataSourceImp(private val favouritesService: FavouritesService): FavouritesDataSource {
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