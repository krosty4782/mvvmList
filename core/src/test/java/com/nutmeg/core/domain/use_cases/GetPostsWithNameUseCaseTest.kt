package com.nutmeg.core.domain.use_cases

import com.nutmeg.core.data.repositories.PostsRepository
import com.nutmeg.core.data.repositories.UsersRepository
import com.nutmeg.core.domain.models.Post
import com.nutmeg.core.domain.models.PostWithUser
import com.nutmeg.core.domain.models.User
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetPostsWithNameUseCaseTest {

    @Mock
    private lateinit var postsRepositoryMock: PostsRepository

    @Mock
    private lateinit var usersRepositoryMock: UsersRepository

    @InjectMocks
    private lateinit var sut: GetPostsWithNameUseCase

    @Test
    fun test_buildUseCase_success() = runBlocking {
        //given
        val mockPost = Post(1, 2, "title", "body")
        val mockUser = User(
            1,
            "name",
            "username",
            "email"
        )


        whenever(postsRepositoryMock.getPosts()).thenReturn(listOf(mockPost))
        whenever(usersRepositoryMock.getUsers()).thenReturn(listOf(mockUser))

        //when
        val result = sut.buildUseCase(null)

        //then
        Assert.assertEquals(Result.success(listOf(PostWithUser(mockPost, mockUser))), result)
    }

    @Test
    fun test_buildUseCase_failure() = runBlocking {
        //given
        val error = RuntimeException("Some error")
        whenever(postsRepositoryMock.getPosts()).thenThrow(error)

        //when
        val result = sut.buildUseCase(null)

        //then
        Assert.assertEquals(Result.failure<List<PostWithUser>>(error), result)
    }
}