package com.mvvmlist.data.datasource

import com.mvvmlist.data.datasource.AlbumsDataSource
import com.mvvmlist.data.services.AlbumsService

class AlbumsDataSourceImp(private val albumsService: AlbumsService) : AlbumsDataSource {
    override suspend fun getAlbums() = albumsService.getAlbums()
}