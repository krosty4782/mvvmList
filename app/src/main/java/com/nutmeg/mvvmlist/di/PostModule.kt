package com.nutmeg.mvvmlist.di


import com.nutmeg.data.datasource.FavouritesDataSource
import com.nutmeg.data.services.FavouritesService
import com.nutmeg.data.services.FavouritesServiceImp
import com.nutmeg.data.services.PostService
import com.nutmeg.data.services.UsersService
import com.nutmeg.domain.repositories.FavouritesRepository
import com.nutmeg.domain.repositories.PostsRepository
import com.nutmeg.domain.repositories.UsersRepository
import com.nutmeg.domain.use_cases.DeleteFavouriteUseCase
import com.nutmeg.domain.use_cases.GetPostsWithNameAndFavsUseCase
import com.nutmeg.domain.use_cases.IsFavouriteUseCase
import com.nutmeg.domain.use_cases.StoreFavouriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.nutmeg.data.datasource.PostDataSource
import com.nutmeg.data.datasource.UsersDataSource
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object PostModule {

    @Provides
    fun getUserService(retrofit: Retrofit) = retrofit.create(UsersService::class.java)

    @Provides
    fun getPostService(retrofit: Retrofit) = retrofit.create(PostService::class.java)

    @Provides
    @Singleton //In memory caching while the app runs
    fun getFavouritesService(): FavouritesService = FavouritesServiceImp()

    @Provides
    fun getUsersDataSource(usersService: UsersService): UsersDataSource =
        com.nutmeg.mvvmlist.repositories.UsersDataSource(usersService)

    @Provides
    fun getPostDataSource(postService: PostService): PostDataSource =
        com.nutmeg.mvvmlist.repositories.PostDataSource(postService)

    @Provides
    fun getUsersRepository(usersDataSource: UsersDataSource): UsersRepository =
        com.nutmeg.data.repositories.UsersRepository(usersDataSource)

    @Provides
    fun getPostsRepository(dataSource: PostDataSource): PostsRepository =
        com.nutmeg.data.repositories.PostsRepository(dataSource)

    @Provides
    fun getPostsWithNameUseCase(
        postRepository: PostsRepository,
        userRepository: UsersRepository,
        favouritesRepository: FavouritesRepository
    ) = GetPostsWithNameAndFavsUseCase(postRepository, userRepository, favouritesRepository)

    @Provides
    fun getFavouritesDataSource(favouritesService: FavouritesService) : FavouritesDataSource =
        com.nutmeg.mvvmlist.repositories.FavouritesDataSource(favouritesService)

    @Provides
    fun getFavouritesRepository(favouritesDataSource: FavouritesDataSource): FavouritesRepository =
        com.nutmeg.data.repositories.FavouritesRepository(favouritesDataSource)

    @Provides
    fun getIsFavouriteUseCase(favouritesRepository: FavouritesRepository) =
        com.nutmeg.domain.use_cases.IsFavouriteUseCase(favouritesRepository)

    @Provides
    fun getStoreFavouriteUseCase(favouritesRepository: FavouritesRepository) =
        com.nutmeg.domain.use_cases.StoreFavouriteUseCase(favouritesRepository)

    @Provides
    fun getDeleteFavouriteUseCase(favouritesRepository: FavouritesRepository) =
        com.nutmeg.domain.use_cases.DeleteFavouriteUseCase(favouritesRepository)
}