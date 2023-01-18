package com.nutmeg.data.datasource

import com.nutmeg.domain.models.Album


interface AlbumsDataSource {

    suspend fun getAlbums(): List<Album>
}