package com.mvvmlist.posts

import com.mvvmlist.domain.use_cases.DeleteFavouriteUseCase
import com.mvvmlist.domain.use_cases.IsFavouriteUseCase
import com.mvvmlist.domain.use_cases.StoreFavouriteUseCase
import javax.inject.Inject

data class FavouritesUseCases @Inject constructor(
    val isFavouriteUseCase: IsFavouriteUseCase,
    val storeFavouriteUseCase: StoreFavouriteUseCase,
    val deleteFavouriteUseCase: DeleteFavouriteUseCase
)