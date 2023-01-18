package com.nutmeg.domain.use_cases

import com.nutmeg.domain.models.Album
import com.nutmeg.domain.repositories.AlbumsRepository
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