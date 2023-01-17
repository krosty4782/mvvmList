package com.nutmeg.mvvmlist.di

import com.nutmeg.core.data.datasource.AlbumsDataSource
import com.nutmeg.core.data.repositories.AlbumsRepository
import com.nutmeg.core.data.services.AlbumsService
import com.nutmeg.core.domain.repositories.UsersRepository
import com.nutmeg.core.domain.use_cases.GetAlbumsUseCase
import com.nutmeg.core.domain.use_cases.GetUserUseCase
import com.nutmeg.mvvmlist.users.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object UserModule {

    @Provides
    fun getGetUserUseCase(usersRepository: UsersRepository) =
        GetUserUseCase(usersRepository)

    @Provides
    fun getUserUseCases(getUserUseCases: GetUserUseCase) =
        UserUseCases(getUserUseCases)

    @Provides
    fun getAlbumService(retrofit: Retrofit) =
        retrofit.create(AlbumsService::class.java)

    @Provides
    fun getAlbumDataSource(albumService: AlbumsService): AlbumsDataSource =
        com.nutmeg.mvvmlist.repositories.AlbumsDataSource(albumService)

    @Provides
    fun getAlbumRepository(albumsDataSource: AlbumsDataSource): com.nutmeg.core.domain.repositories.AlbumsRepository =
        AlbumsRepository(albumsDataSource)


    @Provides
    fun getGetAlbumUseCase(getAlbumsRepository: com.nutmeg.core.domain.repositories.AlbumsRepository) =
        GetAlbumsUseCase(getAlbumsRepository)
}