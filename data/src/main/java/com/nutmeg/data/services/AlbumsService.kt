package com.nutmeg.data.services

import com.nutmeg.domain.models.Album
import retrofit2.http.GET

interface AlbumsService {

    @GET("/albums")
    suspend fun getAlbums(): List<Album>
}