package com.mvvmlist.posts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mvvmlist.posts.*
import com.mvvmlist.domain.models.Address
import com.mvvmlist.domain.models.Post
import com.mvvmlist.domain.models.PostWithUser
import com.mvvmlist.domain.models.User
import com.mvvmlist.domain.use_cases.GetPostsWithNameAndFavsUseCase
import com.mvvmlist.base.NavigationDestination
import com.mvvmlist.domain.use_cases.DeleteFavouriteUseCase
import com.mvvmlist.domain.use_cases.StoreFavouriteUseCase
import com.mvvmlist.rules.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.*

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
    private lateinit var deleteFavouritesUseCasesMock: DeleteFavouriteUseCase

    @Mock
    private lateinit var storeFavouritesUseCasesMock: StoreFavouriteUseCase

    @Mock
    private lateinit var favouritesUseCasesMock: FavouritesUseCases

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
                    Post(12, 1, "title", "body"), (User(
                        12, "name", "username", "email",
                        Address("street", "suite", "city", "zipcode"), "phone1", "website1"
                    )), true
                )
            )

            val resultMock = Result.success(postWithUserMock)
            whenever(useCasesMock.getAllPostsWithNameAndFavUseCase).thenReturn(
                getAllPostsWithNameUseCaseMock
            )
            val postsModelMock = listOf(PostsModel("title", "body", "username", true, 12, 13))
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
            whenever(useCasesMock.getAllPostsWithNameAndFavUseCase).thenReturn(
                getAllPostsWithNameUseCaseMock
            )

            whenever(getAllPostsWithNameUseCaseMock.buildUseCase(null)).thenReturn(resultMock)

            //when
            sut.onViewLoaded()

            //then
            Assert.assertEquals(null, sut.posts.value)
        }

    @Test
    fun test_onUserNameClicked_navigationDestination() =
        runBlocking {
            //given

            //when
            sut.onUsernameClicked(1)

            //then
            Assert.assertEquals(NavigationDestination.User(1), sut.navigation.value)
        }

    @Test
    fun test_doneNavigating_navigationNull() =
        runBlocking {
            //given

            //when
            sut.doneNavigating()

            //then
            Assert.assertNull(sut.navigation.value)
        }

    @Test
    fun test_onFavouritesClickedAndNotFavourite_favourite() =
        runBlocking {
            //given
            val postsModelMock = PostsModel("title", "body", "username", false, 12, 13)
            whenever(favouritesUseCasesMock.storeFavouriteUseCase).thenReturn(
                storeFavouritesUseCasesMock
            )
            sut._posts.postValue(listOf(postsModelMock))

            //when
            sut.onFavouritesClicked(postsModelMock)

            //then
            verify(favouritesUseCasesMock.storeFavouriteUseCase).storeFavourite(eq(13))
            Assert.assertEquals(
                listOf(PostsModel("title", "body", "username", true, 12, 13)),
                sut.posts.value
            )
        }

    @Test
    fun test_onFavouritesClickedAndFavourite_deleteFavourite() =
        runBlocking {
            //given
            val postsModelMock = PostsModel("title", "body", "username", true, 12, 13)
            whenever(favouritesUseCasesMock.deleteFavouriteUseCase).thenReturn(
                deleteFavouritesUseCasesMock
            )
            sut._posts.postValue(listOf(postsModelMock))

            //when
            sut.onFavouritesClicked(postsModelMock)

            //then
            verify(favouritesUseCasesMock.deleteFavouriteUseCase).deleteFavourite(eq(13))
            Assert.assertEquals(
                listOf(PostsModel("title", "body", "username", false, 12, 13)),
                sut.posts.value
            )
        }
}
