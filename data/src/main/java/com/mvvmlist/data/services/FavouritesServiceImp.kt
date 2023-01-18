package com.mvvmlist.data.services

class FavouritesServiceImp() : FavouritesService {

    /*Just local in memory caching for easiness purposes, this could use localStorage/DB/any other
    kind of persistency if required*/

    private var favourites = mutableSetOf<Int>()

    override fun isFavourite(postId: Int): Boolean {
        return favourites.contains(postId)
    }

    //In case these are actually implemented against a DB/Network etc.
    // you might want to return the status of the transaction to act accordingly
    override fun storeFavourite(postId: Int) {
        favourites.add(postId)
    }

    override fun deleteFavourite(postId: Int) {
        favourites.remove(postId)
    }
}