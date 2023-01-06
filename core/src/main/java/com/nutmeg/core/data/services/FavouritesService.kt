package com.nutmeg.core.data.services

interface FavouritesService {

    fun isFavourite(postId: String): Boolean

    fun storeFavourite(postId:String)

    fun deleteFavourite(postId:String)
}