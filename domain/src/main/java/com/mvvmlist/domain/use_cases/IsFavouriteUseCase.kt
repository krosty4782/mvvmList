package com.mvvmlist.domain.use_cases

import com.mvvmlist.domain.repositories.FavouritesRepository

class IsFavouriteUseCase(private val favouritesRepository: FavouritesRepository) {
    suspend fun isFavourite(postId: Int) = favouritesRepository.isFavourite(postId)
}