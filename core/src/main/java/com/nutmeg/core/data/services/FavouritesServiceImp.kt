package com.nutmeg.core.data.services

class FavouritesServiceImp() : FavouritesService {

    /*Just local in memory caching for easyness purposes, this could use localStorage/DB/any other
    kind of persistency if required*/

    private val favourites = setOf<String>()

    override fun isFavourite(postId: String): Boolean {
        return favourites.contains(postId)
    }

    override fun storeFavourite(postId: String) {
        favourites.plus(postId)
    }

    override fun deleteFavourite(postId: String) {
        favourites.minus(postId)
    }
}