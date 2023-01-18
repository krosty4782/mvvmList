package use_cases


import com.mvvmlist.domain.models.Address
import com.mvvmlist.domain.models.Post
import com.mvvmlist.domain.models.PostWithUser
import com.mvvmlist.domain.models.User
import com.mvvmlist.domain.repositories.FavouritesRepository
import com.mvvmlist.domain.repositories.PostsRepository
import com.mvvmlist.domain.repositories.UsersRepository
import com.mvvmlist.domain.use_cases.GetPostsWithNameAndFavsUseCase
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

    @Mock
    private lateinit var favouritesRepositoryMock: FavouritesRepository

    @InjectMocks
    private lateinit var sut: GetPostsWithNameAndFavsUseCase

    @Test
    fun test_buildUseCase_success() = runBlocking {
        //given
        val mockPost = Post(1, 2, "title", "body")
        val mockUser = User(
            1,
            "name",
            "username",
            "email",
            Address("street", "suite", "city", "zipcode"),
            "phone",
            "website"
        )


        whenever(postsRepositoryMock.getPosts()).thenReturn(listOf(mockPost))
        whenever(usersRepositoryMock.getUsers()).thenReturn(listOf(mockUser))
        whenever(favouritesRepositoryMock.isFavourite(2)).thenReturn(true)

        //when
        val result = sut.buildUseCase(null)

        //then
        Assert.assertEquals(Result.success(listOf(PostWithUser(mockPost, mockUser, true))), result)
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