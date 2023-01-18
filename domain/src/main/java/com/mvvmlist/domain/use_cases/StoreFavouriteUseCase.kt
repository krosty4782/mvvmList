package com.mvvmlist.domain.use_cases

import com.mvvmlist.domain.repositories.FavouritesRepository

class StoreFavouriteUseCase(private val favouritesRepository: FavouritesRepository) {
    suspend fun storeFavourite(postId: Int) = favouritesRepository.storeFavourite(postId)
}