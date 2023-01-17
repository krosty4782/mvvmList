package com.nutmeg.mvvmlist.posts

import com.nutmeg.core.domain.use_cases.DeleteFavouriteUseCase
import com.nutmeg.core.domain.use_cases.IsFavouriteUseCase
import com.nutmeg.core.domain.use_cases.StoreFavouriteUseCase
import javax.inject.Inject

data class FavouritesUseCases @Inject constructor(
    val isFavouriteUseCase: IsFavouriteUseCase,
    val storeFavouriteUseCase: StoreFavouriteUseCase,
    val deleteFavouriteUseCase: DeleteFavouriteUseCase
)