package com.nutmeg.mvvmlist.di

import com.nutmeg.core.data.datasource.PostDataSource
import com.nutmeg.core.data.datasource.UsersDataSource
import com.nutmeg.core.data.repositories.FavouritesRepository
import com.nutmeg.core.data.repositories.UsersRepository
import com.nutmeg.core.data.services.FavouritesService
import com.nutmeg.core.data.services.FavouritesServiceImp
import com.nutmeg.core.data.services.PostService
import com.nutmeg.core.data.services.UsersService
import com.nutmeg.core.domain.use_cases.DeleteFavouriteUseCase
import com.nutmeg.core.domain.use_cases.GetPostsWithNameAndFavsUseCase
import com.nutmeg.core.domain.use_cases.IsFavouriteUseCase
import com.nutmeg.core.domain.use_cases.StoreFavouriteUseCase
import com.nutmeg.mvvmlist.posts.FavouritesUseCases
import com.nutmeg.mvvmlist.posts.PostUseCases
import com.nutmeg.mvvmlist.posts.PostsModelConverter
import com.nutmeg.mvvmlist.repositories.FavouritesDataSourceImp
import com.nutmeg.mvvmlist.repositories.PostDataSourceImp
import com.nutmeg.mvvmlist.repositories.UsersDataSourceImp
import com.nutmeg.mvvmlist.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun getOkHttpClient(interceptor: HttpLoggingInterceptor) =
        OkHttpClient().newBuilder().addInterceptor(interceptor).build()

    @Provides
    @Singleton
    fun getRetrofit(client: OkHttpClient) =
        Retrofit.Builder().baseUrl(Constant.BASE_URL).client(client).addConverterFactory(
            GsonConverterFactory.create()
        ).build()

    @Provides
    @Singleton
    fun getUserService(retrofit: Retrofit) = retrofit.create(UsersService::class.java)

    @Provides
    @Singleton
    fun getPostService(retrofit: Retrofit) = retrofit.create(PostService::class.java)

    @Provides
    @Singleton
    fun getFavouritesService(): FavouritesService = FavouritesServiceImp()

    @Provides
    @Singleton
    fun getUsersDataSource(usersService: UsersService): UsersDataSource =
        UsersDataSourceImp(usersService)

    @Provides
    @Singleton
    fun getPostDataSource(postService: PostService): PostDataSource = PostDataSourceImp(postService)

    @Provides
    @Singleton
    fun getUsersRepository(usersDataSource: UsersDataSource) = UsersRepository(usersDataSource)

    @Provides
    @Singleton
    fun getPostsRepository(dataSource: PostDataSource) =
        com.nutmeg.core.data.repositories.PostsRepository(dataSource)

    @Provides
    @Singleton
    fun getPostsModelConverter() = PostsModelConverter()

    @Provides
    @Singleton
    fun getPostsWithNameUseCase(
        postRepository: com.nutmeg.core.data.repositories.PostsRepository,
        userRepository: UsersRepository,
        favouritesRepository: FavouritesRepository
    ) = GetPostsWithNameAndFavsUseCase(postRepository, userRepository, favouritesRepository)


    @Provides
    @Singleton
    fun getPostUseCases(getPostsWithNameUseCase: GetPostsWithNameAndFavsUseCase) =
        PostUseCases(getPostsWithNameUseCase)

    @Provides
    @Singleton
    fun getFavouritesDataSource(favouritesService: FavouritesService) =
        FavouritesDataSourceImp(favouritesService)

    @Provides
    @Singleton
    fun getFavouritesRepository(favouritesDataSource: FavouritesDataSourceImp) =
        FavouritesRepository(favouritesDataSource)

    @Provides
    @Singleton
    fun getIsFavouriteUseCase(favouritesRepository: FavouritesRepository) =
        IsFavouriteUseCase(favouritesRepository)

    @Provides
    @Singleton
    fun getStoreFavouriteUseCase(favouritesRepository: FavouritesRepository) =
        StoreFavouriteUseCase(favouritesRepository)

    @Provides
    @Singleton
    fun getDeleteFavouriteUseCase(favouritesRepository: FavouritesRepository) =
        DeleteFavouriteUseCase(favouritesRepository)

    @Provides
    @Singleton
    fun getFavouritesUseCases(
        isFavouriteUseCase: IsFavouriteUseCase,
        storeFavouriteUseCase: StoreFavouriteUseCase,
        deleteFavouriteUseCase: DeleteFavouriteUseCase
    ) =
        FavouritesUseCases(isFavouriteUseCase, storeFavouriteUseCase, deleteFavouriteUseCase)
}