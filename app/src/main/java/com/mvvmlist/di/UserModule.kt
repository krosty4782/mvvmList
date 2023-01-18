package com.mvvmlist.di

import com.mvvmlist.data.datasource.AlbumsDataSource
import com.mvvmlist.data.datasource.AlbumsDataSourceImp
import com.mvvmlist.data.repositories.AlbumsRepository
import com.mvvmlist.data.services.AlbumsService
import com.mvvmlist.domain.repositories.UsersRepository
import com.mvvmlist.domain.use_cases.GetAlbumsUseCase
import com.mvvmlist.domain.use_cases.GetUserUseCase
import com.mvvmlist.users.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
private object UserModule {

    @Provides
    fun getGetUserUseCase(usersRepository: UsersRepository) =
        GetUserUseCase(usersRepository)

    @Provides
    fun getUserUseCases(getUserUseCases: GetUserUseCase) =
        UserUseCases(getUserUseCases)

    @Provides
    fun getAlbumDataSource(albumService: AlbumsService): AlbumsDataSource =
        AlbumsDataSourceImp(albumService)

    @Provides
    fun getAlbumRepository(albumsDataSource: AlbumsDataSource): com.mvvmlist.domain.repositories.AlbumsRepository =
        AlbumsRepository(albumsDataSource)


    @Provides
    fun getGetAlbumUseCase(getAlbumsRepository: com.mvvmlist.domain.repositories.AlbumsRepository) =
        GetAlbumsUseCase(getAlbumsRepository)
}