package com.nutmeg.mvvmlist.users

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nutmeg.domain.models.Album
import com.nutmeg.domain.models.User
import com.nutmeg.mvvmlist.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val useCases: UserUseCases,
    private val albumsUseCases: AlbumsUseCases
) : BaseViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user
    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums

    fun onViewLoaded(userId: Int) {
        viewModelScope.launch {
            launch {
                useCases.getUser.buildUseCase(userId).let {
                    if (it.isSuccess) {
                        _user.postValue(it.getOrNull())
                    } else {
                        //You could here handle error based on exceptionOrNull, and show whatever is needed in the UI
                        logError()
                    }
                }
            }
            launch {
                albumsUseCases.getAlbumsUseCase.buildUseCase().let {
                    if (it.isSuccess) {
                        _albums.postValue(it.getOrNull())
                    } else {
                        logError()
                    }
                }
            }
        }
    }

    private fun logError() {
        //This logger could be wrapped and injected for testability
        Log.e("Error", "Couldn't load posts")
    }
}