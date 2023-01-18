package com.mvvmlist.posts

import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mvvmlist.base.BaseViewModel
import com.mvvmlist.base.NavigationDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val useCases: PostUseCases,
    private val postsModelConverter: PostsModelConverter,
    private val favouritesUseCases: FavouritesUseCases
) : BaseViewModel() {

    private val _navigation = MutableLiveData<NavigationDestination>()
    val navigation: LiveData<NavigationDestination> = _navigation

    @VisibleForTesting
    val _posts = MutableLiveData<List<PostsModel>>()
    val posts: LiveData<List<PostsModel>> = _posts

    fun onViewLoaded() {
        viewModelScope.launch {
            useCases.getAllPostsWithNameAndFavUseCase.buildUseCase().let {
                if (it.isSuccess) {
                    _posts.postValue(postsModelConverter.convert(it.getOrNull()))
                } else {
                    //This logger could be wrapped and injected for testability
                    Log.e("Error", "Couldn't load posts")
                    //You could here handle error based on exceptionOrNull, and show whatever is needed in the UI
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

    fun onFavouritesClicked(postsModel: PostsModel) {

        with(postsModel.postId) {
            val modifiedList = posts.value?.toMutableList()
            val index = modifiedList?.indexOfFirst { it.postId == this }
            val newPost: PostsModel
            if (postsModel.isFavourite) {
                viewModelScope.launch {
                    favouritesUseCases.deleteFavouriteUseCase.deleteFavourite(this@with)
                }
                newPost = postsModel.copy(isFavourite = false)
            } else {
                viewModelScope.launch {
                    favouritesUseCases.storeFavouriteUseCase.storeFavourite(this@with)
                }
                newPost = postsModel.copy(isFavourite = true)
            }
            index?.let { modifiedList.set(it, newPost) }
            _posts.postValue(modifiedList)
        }
    }
}