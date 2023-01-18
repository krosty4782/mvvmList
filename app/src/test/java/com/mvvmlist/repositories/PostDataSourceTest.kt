package com.mvvmlist.repositories

import com.mvvmlist.repositories.PostDataSource
import com.mvvmlist.data.services.PostService
import com.mvvmlist.domain.models.Post
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class PostDataSourceTest {

    @Test
    fun test_getPosts_returnListPost() {
        runTest {
            //given
            val postServiceMock = mock<PostService>()
            val sut = PostDataSource(postServiceMock)
            val mockList = listOf(Post(12, 1, "title", "body"))
            whenever(postServiceMock.getPosts()).thenReturn(mockList)

            //when
            val posts = sut.getPosts()

            //then
            assertEquals(mockList, posts)

        }
    }
}