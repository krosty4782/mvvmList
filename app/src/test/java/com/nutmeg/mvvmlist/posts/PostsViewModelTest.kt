package com.nutmeg.mvvmlist.posts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nutmeg.core.domain.models.Post
import com.nutmeg.core.domain.models.PostWithUser
import com.nutmeg.core.domain.models.User
import com.nutmeg.core.domain.use_cases.GetPostsWithNameAndFavsUseCase
import com.nutmeg.mvvmlist.rules.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class PostsViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var useCasesMock: PostUseCases

    @Mock
    private lateinit var postsModelConverterMock: PostsModelConverter

    @InjectMocks
    private lateinit var sut: PostsViewModel

    @Test
    fun test_onViewLoaded_loadsPostsSuccess() =
        runBlocking {
            //given
            val getAllPostsWithNameUseCaseMock = mock<GetPostsWithNameAndFavsUseCase>()

            val postWithUserMock = listOf(
                PostWithUser(
                    Post(12, 1, "title", "body"), (User(12, "name", "username", "email"))
                )
            )
            val resultMock = Result.success(postWithUserMock)
            whenever(useCasesMock.getAllPostsWithNameUseCase).thenReturn(
                getAllPostsWithNameUseCaseMock
            )
            val postsModelMock = listOf(PostsModel("title", "body", "username", 12))
            whenever(postsModelConverterMock.convert(any())).thenReturn(postsModelMock)

            whenever(getAllPostsWithNameUseCaseMock.buildUseCase(null)).thenReturn(resultMock)

            //when
            sut.onViewLoaded()

            //then
            Assert.assertEquals(postsModelMock, sut.posts.value)
        }

    @Test
    fun test_onViewLoaded_loadsPostsFail() =
        runBlocking {
            //given
            val getAllPostsWithNameUseCaseMock = mock<GetPostsWithNameAndFavsUseCase>()

            val resultMock = Result.failure<List<PostWithUser>>(Throwable())
            whenever(useCasesMock.getAllPostsWithNameUseCase).thenReturn(
                getAllPostsWithNameUseCaseMock
            )

            whenever(getAllPostsWithNameUseCaseMock.buildUseCase(null)).thenReturn(resultMock)

            //when
            sut.onViewLoaded()

            //then
            Assert.assertEquals(null, sut.posts.value)
        }
}
