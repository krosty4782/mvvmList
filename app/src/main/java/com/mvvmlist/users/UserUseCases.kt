package com.mvvmlist.users

import com.mvvmlist.domain.use_cases.GetUserUseCase
import javax.inject.Inject

data class UserUseCases @Inject constructor(val getUser: GetUserUseCase)