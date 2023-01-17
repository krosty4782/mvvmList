package com.nutmeg.mvvmlist.users

import com.nutmeg.core.domain.use_cases.GetAlbumsUseCase
import javax.inject.Inject

data class AlbumsUseCases @Inject constructor(val getAlbumsUseCase: GetAlbumsUseCase)