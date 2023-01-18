package com.mvvmlist.users

import com.mvvmlist.domain.use_cases.GetAlbumsUseCase
import javax.inject.Inject

data class AlbumsUseCases @Inject constructor(val getAlbumsUseCase: GetAlbumsUseCase)