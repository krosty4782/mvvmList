package com.nutmeg.data.repositories

import com.nutmeg.data.datasource.AlbumsDataSource
import com.nutmeg.domain.repositories.AlbumsRepository

class AlbumsRepository(private val albumsDataSource: AlbumsDataSource) : AlbumsRepository {
    override suspend fun getAlbums() = albumsDataSource.getAlbums()
}