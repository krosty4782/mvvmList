package com.nutmeg.mvvmlist

import android.app.Application
import com.nutmeg.core.data.repositories.PostsRepository
import com.nutmeg.core.data.repositories.UsersRepository
import com.nutmeg.core.data.services.PostService
import com.nutmeg.core.data.services.UsersService
import com.nutmeg.core.domain.use_cases.GetPostsWithNameUseCase
import com.nutmeg.mvvmlist.base.UseCases
import com.nutmeg.mvvmlist.posts.PostsModelConverter
import com.nutmeg.mvvmlist.repositories.PostDataSourceImp
import com.nutmeg.mvvmlist.repositories.UsersDataSourceImp
import com.nutmeg.mvvmlist.util.Constant
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class MVVMApplication : Application() {
    override fun onCreate() {
        super.onCreate()
//        MVVMViewModelFactory.inject(this, UseCases(GetPostsWithNameUseCase(postsRepository = potRepository, usersRepository = usersRepository)), postsModelConverter)
    }
}