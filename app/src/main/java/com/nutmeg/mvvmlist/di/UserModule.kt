package com.nutmeg.mvvmlist.di

import com.nutmeg.core.data.datasource.AlbumsDataSource
import com.nutmeg.core.data.repositories.AlbumsRepository
import com.nutmeg.core.data.repositories.UsersRepository
import com.nutmeg.core.data.services.AlbumsService
import com.nutmeg.core.domain.use_cases.GetAlbumsUseCase
import com.nutmeg.core.domain.use_cases.GetUserUseCase
import com.nutmeg.mvvmlist.users.AlbumsUseCases
import com.nutmeg.mvvmlist.users.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    @Singleton
    fun getGetUserUseCase(usersRepository: UsersRepository) =
        GetUserUseCase(usersRepository)

    @Provides
    @Singleton
    fun getUserUseCases(getUserUseCases: GetUserUseCase) =
        UserUseCases(getUserUseCases)

    @Provides
    @Singleton
    fun getAlbumService(retrofit: Retrofit) =
        retrofit.create(AlbumsService::class.java)

    @Provides
    @Singleton
    fun getAlbumDataSource(albumService: AlbumsService): AlbumsDataSource =
        com.nutmeg.mvvmlist.repositories.AlbumsDataSource(albumService)

    @Provides
    @Singleton
    fun getAlbumRepository(albumsDataSource: AlbumsDataSource): com.nutmeg.core.domain.repositories.AlbumsRepository =
        AlbumsRepository(albumsDataSource)


    @Provides
    @Singleton
    fun getGetAlbumUseCase(getAlbumsRepository: com.nutmeg.core.domain.repositories.AlbumsRepository) =
        GetAlbumsUseCase(getAlbumsRepository)

    @Provides
    @Singleton
    fun getAlbumsUseCase(getAlbumsUseCase: GetAlbumsUseCase) =
        AlbumsUseCases(getAlbumsUseCase)
}