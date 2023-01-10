package com.nutmeg.core.data.services

interface FavouritesService {

    fun isFavourite(postId: Int): Boolean

    fun storeFavourite(postId:Int)

    fun deleteFavourite(postId:Int)
}