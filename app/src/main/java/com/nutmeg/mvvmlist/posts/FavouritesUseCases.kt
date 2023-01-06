package com.nutmeg.mvvmlist.posts

import com.nutmeg.core.domain.use_cases.DeleteFavouriteUseCase
import com.nutmeg.core.domain.use_cases.IsFavouriteUseCase
import com.nutmeg.core.domain.use_cases.StoreFavouriteUseCase

class FavouritesUseCases(
    private val isFavouriteUseCase: IsFavouriteUseCase,
    private val storeFavouriteUseCase: StoreFavouriteUseCase,
    private val deleteFavouriteUseCase: DeleteFavouriteUseCase
)