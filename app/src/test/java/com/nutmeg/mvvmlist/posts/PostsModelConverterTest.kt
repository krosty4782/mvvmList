package com.nutmeg.mvvmlist.posts

import com.nutmeg.core.domain.models.Post
import com.nutmeg.core.domain.models.PostWithUser
import com.nutmeg.core.domain.models.User
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
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
            val posts = listOf(
                PostWithUser(
                    Post(12, 1, "title1", "body1"),
                    User(12, "name1", "username1", "email1")
                ),
                PostWithUser(
                    Post(13, 2, "title2", "body2"),
                    User(13, "username2", "username2", "email2")
                )
            )
            val expectedResult = listOf(
                PostsModel(title = "title1", body = "body1", username = "username1", 12),
                PostsModel(title = "title2", body = "body2", username = "username2", 13)
            )

            //when
            val result = converter.convert(posts)

            //then
            assertEquals(expectedResult, result)
        }
    }
}