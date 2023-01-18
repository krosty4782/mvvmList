package com.mvvmlist.repositories

import com.mvvmlist.data.datasource.AlbumsDataSource
import com.mvvmlist.data.services.AlbumsService

class AlbumsDataSource(private val albumsService: AlbumsService) : AlbumsDataSource {
    override suspend fun getAlbums() = albumsService.getAlbums()
}