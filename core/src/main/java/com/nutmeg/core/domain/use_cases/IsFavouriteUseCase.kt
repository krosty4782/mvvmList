package com.nutmeg.core.domain.use_cases

import com.nutmeg.core.domain.repositories.FavouritesRepository

class IsFavouriteUseCase(private val favouritesRepository: FavouritesRepository) {
    suspend fun isFavourite(postId: Int) = favouritesRepository.isFavourite(postId)
}