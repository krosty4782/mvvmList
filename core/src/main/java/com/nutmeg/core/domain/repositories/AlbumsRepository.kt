package com.nutmeg.core.domain.repositories

import com.nutmeg.core.domain.models.Album

interface AlbumsRepository {
    suspend fun getAlbums(): List<Album>
}