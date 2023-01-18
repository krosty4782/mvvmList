package com.nutmeg.mvvmlist.di

import com.nutmeg.data.datasource.AlbumsDataSource
import com.nutmeg.data.repositories.AlbumsRepository
import com.nutmeg.data.services.AlbumsService
import com.nutmeg.domain.repositories.UsersRepository
import com.nutmeg.domain.use_cases.GetAlbumsUseCase
import com.nutmeg.domain.use_cases.GetUserUseCase
import com.nutmeg.mvvmlist.users.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
private object UserModule {

    @Provides
    fun getGetUserUseCase(usersRepository: UsersRepository) =
        com.nutmeg.domain.use_cases.GetUserUseCase(usersRepository)

    @Provides
    fun getUserUseCases(getUserUseCases: com.nutmeg.domain.use_cases.GetUserUseCase) =
        UserUseCases(getUserUseCases)

    @Provides
    fun getAlbumService(retrofit: Retrofit) =
        retrofit.create(AlbumsService::class.java)

    @Provides
    fun getAlbumDataSource(albumService: AlbumsService): AlbumsDataSource =
        com.nutmeg.mvvmlist.repositories.AlbumsDataSource(albumService)

    @Provides
    fun getAlbumRepository(albumsDataSource: AlbumsDataSource): com.nutmeg.domain.repositories.AlbumsRepository =
        AlbumsRepository(albumsDataSource)


    @Provides
    fun getGetAlbumUseCase(getAlbumsRepository: com.nutmeg.domain.repositories.AlbumsRepository) =
        com.nutmeg.domain.use_cases.GetAlbumsUseCase(getAlbumsRepository)
}