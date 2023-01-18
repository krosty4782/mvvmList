package com.mvvmlist.domain.use_cases

import com.mvvmlist.domain.models.Album
import com.mvvmlist.domain.repositories.AlbumsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAlbumsUseCase(private val getAlbumsRepository: AlbumsRepository) :
    BaseUseCase<List<Album>, Nothing?> {

    override suspend fun buildUseCase(params: Nothing?): Result<List<Album>> {
        return withContext(Dispatchers.IO) {
            try {
                val albums = getAlbumsRepository.getAlbums()
                return@withContext Result.success(albums)
            } catch (exception: Exception) {
                return@withContext Result.failure(exception.cause ?: Throwable("Unknown Exception"))
            }
        }
    }
}