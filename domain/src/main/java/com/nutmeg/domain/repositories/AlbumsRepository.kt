package com.nutmeg.domain.repositories

import com.nutmeg.domain.models.Album

interface AlbumsRepository {
    suspend fun getAlbums(): List<Album>
}