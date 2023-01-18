package com.nutmeg.mvvmlist.posts

import com.nutmeg.domain.use_cases.DeleteFavouriteUseCase
import com.nutmeg.domain.use_cases.IsFavouriteUseCase
import com.nutmeg.domain.use_cases.StoreFavouriteUseCase
import javax.inject.Inject

data class FavouritesUseCases @Inject constructor(
    val isFavouriteUseCase: com.nutmeg.domain.use_cases.IsFavouriteUseCase,
    val storeFavouriteUseCase: com.nutmeg.domain.use_cases.StoreFavouriteUseCase,
    val deleteFavouriteUseCase: com.nutmeg.domain.use_cases.DeleteFavouriteUseCase
)