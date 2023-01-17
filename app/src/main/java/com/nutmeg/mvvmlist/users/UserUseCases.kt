package com.nutmeg.mvvmlist.users

import com.nutmeg.core.domain.use_cases.GetUserUseCase
import javax.inject.Inject

data class UserUseCases @Inject constructor(val getUser: GetUserUseCase)