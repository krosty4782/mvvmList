package com.mvvmlist.domain.repositories

import com.mvvmlist.domain.models.Album

interface AlbumsRepository {
    suspend fun getAlbums(): List<Album>
}