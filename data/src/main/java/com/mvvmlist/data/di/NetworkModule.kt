package com.mvvmlist.data.di


import com.mvvmlist.data.util.Constant
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
private object NetworkModule {

    @Provides
    @Reusable
    fun getHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Reusable
    fun getOkHttpClient(interceptor: HttpLoggingInterceptor) =
        OkHttpClient().newBuilder().addInterceptor(interceptor).build()

    @Provides
    @Reusable
    fun getRetrofit(client: OkHttpClient) =
        Retrofit.Builder().baseUrl(Constant.BASE_URL).client(client).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
}