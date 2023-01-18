package com.mvvmlist.domain.use_cases

import com.mvvmlist.domain.repositories.FavouritesRepository

class DeleteFavouriteUseCase(private val favouritesRepository: FavouritesRepository) {
    suspend fun deleteFavourite(postId: Int) = favouritesRepository.deleteFavourite(postId)
}