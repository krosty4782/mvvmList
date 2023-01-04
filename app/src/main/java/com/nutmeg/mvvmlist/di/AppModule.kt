package com.nutmeg.mvvmlist.di

import com.nutmeg.core.data.repositories.UsersRepository
import com.nutmeg.core.data.services.PostService
import com.nutmeg.core.data.services.UsersService
import com.nutmeg.core.domain.use_cases.GetPostsWithNameUseCase
import com.nutmeg.mvvmlist.posts.PostUseCases
import com.nutmeg.mvvmlist.posts.PostsModelConverter
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
    fun getUsersDataSource(usersService: UsersService) = UsersDataSourceImp(usersService)

    @Provides
    @Singleton
    fun getPostDataSource(postService: PostService) = PostDataSourceImp(postService)

    @Provides
    @Singleton
    fun getUsersRepository(usersDataSource: UsersDataSourceImp) = UsersRepository(usersDataSource)

    @Provides
    @Singleton
    fun getPostsRepository(dataSource: PostDataSourceImp) =
        com.nutmeg.core.data.repositories.PostsRepository(dataSource)

    @Provides
    @Singleton
    fun getPostsModelConverter() = PostsModelConverter()

    @Provides
    @Singleton
    fun getPostsWithNameUseCase(
        getPostsRepository: com.nutmeg.core.data.repositories.PostsRepository,
        getUserRepository: UsersRepository
    ) = GetPostsWithNameUseCase(getPostsRepository, getUserRepository)


    @Provides
    @Singleton
    fun getPostUseCases(getPostsWithNameUseCase: GetPostsWithNameUseCase) =
        PostUseCases(getPostsWithNameUseCase)
}