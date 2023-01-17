package com.nutmeg.mvvmlist.di


import com.nutmeg.core.data.datasource.FavouritesDataSource
import com.nutmeg.core.data.services.FavouritesService
import com.nutmeg.core.data.services.FavouritesServiceImp
import com.nutmeg.core.data.services.PostService
import com.nutmeg.core.data.services.UsersService
import com.nutmeg.core.domain.repositories.FavouritesRepository
import com.nutmeg.core.domain.repositories.PostsRepository
import com.nutmeg.core.domain.repositories.UsersRepository
import com.nutmeg.core.domain.use_cases.DeleteFavouriteUseCase
import com.nutmeg.core.domain.use_cases.GetPostsWithNameAndFavsUseCase
import com.nutmeg.core.domain.use_cases.IsFavouriteUseCase
import com.nutmeg.core.domain.use_cases.StoreFavouriteUseCase
import com.nutmeg.mvvmlist.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostModule {

    @Provides
    fun getUserService(retrofit: Retrofit) = retrofit.create(UsersService::class.java)

    @Provides
    fun getPostService(retrofit: Retrofit) = retrofit.create(PostService::class.java)

    @Provides
    @Singleton //In memory caching while the app runs
    fun getFavouritesService(): FavouritesService = FavouritesServiceImp()

    @Provides
    fun getUsersDataSource(usersService: UsersService): com.nutmeg.core.data.datasource.UsersDataSource =
        com.nutmeg.mvvmlist.repositories.UsersDataSource(usersService)

    @Provides
    fun getPostDataSource(postService: PostService): com.nutmeg.core.data.datasource.PostDataSource =
        com.nutmeg.mvvmlist.repositories.PostDataSource(postService)

    @Provides
    fun getUsersRepository(usersDataSource: com.nutmeg.core.data.datasource.UsersDataSource): UsersRepository =
        com.nutmeg.core.data.repositories.UsersRepository(usersDataSource)

    @Provides
    fun getPostsRepository(dataSource: com.nutmeg.core.data.datasource.PostDataSource): PostsRepository =
        com.nutmeg.core.data.repositories.PostsRepository(dataSource)

    @Provides
    fun getPostsWithNameUseCase(
        postRepository: PostsRepository,
        userRepository: UsersRepository,
        favouritesRepository: FavouritesRepository
    ) = GetPostsWithNameAndFavsUseCase(postRepository, userRepository, favouritesRepository)

    @Provides
    fun getFavouritesDataSource(favouritesService: FavouritesService) : FavouritesDataSource=
        com.nutmeg.mvvmlist.repositories.FavouritesDataSource(favouritesService)

    @Provides
    fun getFavouritesRepository(favouritesDataSource: FavouritesDataSource): FavouritesRepository =
        com.nutmeg.core.data.repositories.FavouritesRepository(favouritesDataSource)

    @Provides
    fun getIsFavouriteUseCase(favouritesRepository: FavouritesRepository) =
        IsFavouriteUseCase(favouritesRepository)

    @Provides
    fun getStoreFavouriteUseCase(favouritesRepository: FavouritesRepository) =
        StoreFavouriteUseCase(favouritesRepository)

    @Provides
    fun getDeleteFavouriteUseCase(favouritesRepository: FavouritesRepository) =
        DeleteFavouriteUseCase(favouritesRepository)
}