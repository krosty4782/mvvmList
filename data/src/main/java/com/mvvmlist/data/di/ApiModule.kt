package com.mvvmlist.data.di

import com.mvvmlist.data.services.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object ApiModule {
    @Provides
    fun getUserService(retrofit: Retrofit) = retrofit.create(UsersService::class.java)

    @Provides
    fun getPostService(retrofit: Retrofit) = retrofit.create(PostService::class.java)

    @Provides
    fun getAlbumService(retrofit: Retrofit) = retrofit.create(AlbumsService::class.java)

    @Provides
    @Singleton //In memory caching while the app runs
    fun getFavouritesService(): FavouritesService = FavouritesServiceImp()

}