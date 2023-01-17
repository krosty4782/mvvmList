package com.nutmeg.core.data.datasource

import com.nutmeg.core.domain.models.Album

interface AlbumsDataSource {

    suspend fun getAlbums(): List<Album>
}