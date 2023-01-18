package com.mvvmlist.data.datasource

import com.mvvmlist.domain.models.Album


interface AlbumsDataSource {

    suspend fun getAlbums(): List<Album>
}