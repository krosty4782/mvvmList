package com.nutmeg.mvvmlist.posts

import com.nutmeg.core.domain.use_cases.DeleteFavouriteUseCase
import com.nutmeg.core.domain.use_cases.IsFavouriteUseCase
import com.nutmeg.core.domain.use_cases.StoreFavouriteUseCase

data class FavouritesUseCases(
    val isFavouriteUseCase: IsFavouriteUseCase,
    val storeFavouriteUseCase: StoreFavouriteUseCase,
    val deleteFavouriteUseCase: DeleteFavouriteUseCase
)