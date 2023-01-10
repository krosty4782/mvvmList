package com.nutmeg.mvvmlist.di

import com.nutmeg.core.data.repositories.UsersRepository
import com.nutmeg.core.domain.use_cases.GetUserUseCase
import com.nutmeg.mvvmlist.users.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

//    @Provides
//    @Singleton
//    fun getGetUserUseCase(userDataSource: UsersDataSource) =
//        UsersRepository(userDataSource)

    @Provides
    @Singleton
    fun getGetUserUseCase(usersRepository: UsersRepository) =
        GetUserUseCase(usersRepository)

    @Provides
    @Singleton
    fun getUserUseCases(getUserUseCases: GetUserUseCase) =
        UserUseCases(getUserUseCases)
}