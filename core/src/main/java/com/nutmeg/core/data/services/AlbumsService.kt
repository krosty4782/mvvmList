package com.nutmeg.core.data.services

import com.nutmeg.core.domain.models.Album
import retrofit2.http.GET

interface AlbumsService {

    @GET("/albums")
    suspend fun getAlbums(): List<Album>
}