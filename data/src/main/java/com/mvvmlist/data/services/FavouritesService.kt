package com.mvvmlist.data.services

interface FavouritesService {

    fun isFavourite(postId: Int): Boolean

    fun storeFavourite(postId:Int)

    fun deleteFavourite(postId:Int)
}