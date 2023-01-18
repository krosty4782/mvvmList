package com.nutmeg.domain.use_cases

import com.nutmeg.domain.repositories.FavouritesRepository

class StoreFavouriteUseCase(private val favouritesRepository: FavouritesRepository) {
    suspend fun storeFavourite(postId: Int) = favouritesRepository.storeFavourite(postId)
}