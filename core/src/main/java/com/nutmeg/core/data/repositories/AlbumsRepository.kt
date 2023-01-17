package com.nutmeg.core.data.repositories

import com.nutmeg.core.data.datasource.AlbumsDataSource
import com.nutmeg.core.domain.repositories.AlbumsRepository

class AlbumsRepository(private val albumsDataSource: AlbumsDataSource) : AlbumsRepository {
    override suspend fun getAlbums() = albumsDataSource.getAlbums()
}