package com.nutmeg.mvvmlist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nutmeg.mvvmlist.base.BaseViewModel
import com.nutmeg.mvvmlist.base.UseCases
import com.nutmeg.mvvmlist.posts.PostsModelConverter
import java.lang.IllegalStateException

object MVVMViewModelFactory : ViewModelProvider.Factory {
    lateinit var dependencies: UseCases
    lateinit var converter: PostsModelConverter

    fun inject(dependencies: UseCases, postsModelConverter: PostsModelConverter) {
        MVVMViewModelFactory.dependencies = dependencies
        MVVMViewModelFactory.converter = postsModelConverter
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(BaseViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(UseCases::class.java, PostsModelConverter::class.java)
                .newInstance(dependencies, converter)
        } else {
            throw IllegalStateException("ViewModel must extend BaseViewModel")
        }

    }
}