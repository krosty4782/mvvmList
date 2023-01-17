package com.nutmeg.core.domain.use_cases

import com.nutmeg.core.domain.models.PostWithUser
import com.nutmeg.core.domain.repositories.FavouritesRepository
import com.nutmeg.core.domain.repositories.PostsRepository
import com.nutmeg.core.domain.repositories.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class GetPostsWithNameAndFavsUseCase(
    private val postsRepository: PostsRepository,
    private val usersRepository: UsersRepository,
    private val favouritesRepository: FavouritesRepository
) : BaseUseCase<List<PostWithUser>, Nothing?> {

    override suspend fun buildUseCase(params: Nothing?): Result<List<PostWithUser>> {
        try {
            return withContext(Dispatchers.IO) {

                //Running requests in parallel for efficiency
                val postsResponse = async { postsRepository.getPosts() }
                val usersResponse = async { usersRepository.getUsers() }

                val posts = postsResponse.await()
                val users = usersResponse.await()


                val postsWithUsers = posts.mapNotNull { post ->
                    val isFavourite = favouritesRepository.isFavourite(post.id)
                    val user = users.find { user -> user.id == post.userId }
                    user?.let { PostWithUser(user = user, post = post, isFavourite = isFavourite) }
                }

                return@withContext Result.success(postsWithUsers)
            }
        } catch (exception: Exception) {

            return Result.failure(exception.cause ?: Throwable("Unknown Exception"))
        }
    }
}
