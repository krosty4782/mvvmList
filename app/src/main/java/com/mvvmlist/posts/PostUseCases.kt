package com.mvvmlist.posts

import com.mvvmlist.domain.use_cases.GetPostsWithNameAndFavsUseCase
import javax.inject.Inject

data class PostUseCases @Inject constructor(val getAllPostsWithNameAndFavUseCase: GetPostsWithNameAndFavsUseCase)