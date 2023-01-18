package com.nutmeg.mvvmlist.repositories

import com.nutmeg.data.datasource.AlbumsDataSource
import com.nutmeg.data.services.AlbumsService

class AlbumsDataSource(private val albumsService: AlbumsService) : AlbumsDataSource {
    override suspend fun getAlbums() = albumsService.getAlbums()
}