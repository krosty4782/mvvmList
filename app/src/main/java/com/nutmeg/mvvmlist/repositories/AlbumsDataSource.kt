package com.nutmeg.mvvmlist.repositories

import com.nutmeg.core.data.datasource.AlbumsDataSource
import com.nutmeg.core.data.services.AlbumsService

class AlbumsDataSource(private val albumsService: AlbumsService) : AlbumsDataSource {
    override suspend fun getAlbums() = albumsService.getAlbums()
}