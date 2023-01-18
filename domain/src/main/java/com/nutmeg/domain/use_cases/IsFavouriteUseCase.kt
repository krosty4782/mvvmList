package com.nutmeg.domain.use_cases

import com.nutmeg.domain.repositories.FavouritesRepository

class IsFavouriteUseCase(private val favouritesRepository: FavouritesRepository) {
    suspend fun isFavourite(postId: Int) = favouritesRepository.isFavourite(postId)
}