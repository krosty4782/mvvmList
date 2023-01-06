package com.nutmeg.core.domain.use_cases

import com.nutmeg.core.domain.repositories.FavouritesRepository

class StoreFavouriteUseCase(private val favouritesRepository: FavouritesRepository) {
    suspend fun storeFavourite(postId: String) = favouritesRepository.storeFavourite(postId)
}