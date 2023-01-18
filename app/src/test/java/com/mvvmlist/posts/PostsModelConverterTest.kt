package com.mvvmlist.posts

import com.mvvmlist.posts.PostsModel
import com.mvvmlist.posts.PostsModelConverter
import com.mvvmlist.domain.models.Address
import com.mvvmlist.domain.models.Post
import com.mvvmlist.domain.models.PostWithUser
import com.mvvmlist.domain.models.User
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostsModelConverterTest {

    @Test
    fun test_convert_returnsListOfPostsModel() {
        runTest {
            //given
            val converter = PostsModelConverter()
            val address = Address("street", "suite", "city", "zipcode")
            val posts = listOf(
                PostWithUser(
                    Post(12, 1, "title1", "body1"),
                    User(12, "name1", "username1", "email1", address, "phone1", "website1"),
                    true
                ),
                PostWithUser(
                    Post(13, 2, "title2", "body2"),
                    User(13, "username2", "username2", "email2", address, "phone2", "website2"),
                    true
                )
            )
            val expectedResult = listOf(
                PostsModel(
                    title = "title1",
                    body = "body1",
                    username = "username1",
                    userId = 12,
                    postId = 1,
                    isFavourite = true
                ),
                PostsModel(
                    title = "title2",
                    body = "body2",
                    username = "username2",
                    userId = 13,
                    postId = 2,
                    isFavourite = true
                )
            )

            //when
            val result = converter.convert(posts)

            //then
            assertEquals(expectedResult, result)
        }
    }
}