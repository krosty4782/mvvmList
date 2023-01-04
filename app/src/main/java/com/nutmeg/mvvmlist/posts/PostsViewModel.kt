package com.nutmeg.mvvmlist.posts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nutmeg.mvvmlist.base.BaseViewModel
import com.nutmeg.mvvmlist.base.NavigationDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val useCases: PostUseCases,
    private val postsModelConverter: PostsModelConverter
) : BaseViewModel() {

    private val _navigation = MutableLiveData<NavigationDestination>()
    val navigation: LiveData<NavigationDestination> = _navigation
    private val _posts: MutableLiveData<List<PostsModel>> = MutableLiveData()
    val posts: LiveData<List<PostsModel>> = _posts

    fun onViewLoaded() {
        viewModelScope.launch {
            useCases.getAllPostsWithNameUseCase.buildUseCase(null).let {
                if (it.isSuccess) {
                    _posts.postValue(postsModelConverter.convert(it.getOrNull()))
                } else {
                    //This logger could be wrapped and injected for testability
                    Log.e("Error", "Couldn't load posts")
                }
            }
        }
    }

    fun onUsernameClicked(userId: Int) {
        _navigation.postValue(NavigationDestination.User(userId))
    }

    fun doneNavigating() {
        _navigation.postValue(null)
    }
}