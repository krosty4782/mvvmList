package com.mvvmlist.data.repositories

import com.mvvmlist.data.datasource.AlbumsDataSource
import com.mvvmlist.domain.repositories.AlbumsRepository

class AlbumsRepository(private val albumsDataSource: AlbumsDataSource) : AlbumsRepository {
    override suspend fun getAlbums() = albumsDataSource.getAlbums()
}