package com.mvvmlist.data.services

import com.mvvmlist.domain.models.Album
import retrofit2.http.GET

interface AlbumsService {

    @GET("/albums")
    suspend fun getAlbums(): List<Album>
}