package com.nutmeg.domain.use_cases

import com.nutmeg.domain.repositories.FavouritesRepository

class DeleteFavouriteUseCase(private val favouritesRepository: FavouritesRepository) {
    suspend fun deleteFavourite(postId: Int) = favouritesRepository.deleteFavourite(postId)
}