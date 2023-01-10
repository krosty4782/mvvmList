package com.nutmeg.core.domain.use_cases

import com.nutmeg.core.domain.repositories.FavouritesRepository

class DeleteFavouriteUseCase(private val favouritesRepository: FavouritesRepository) {
    suspend fun deleteFavourite(postId: Int) = favouritesRepository.deleteFavourite(postId)
}