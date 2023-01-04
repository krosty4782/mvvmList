package com.nutmeg.core.data.repositories

import com.nutmeg.core.data.datasource.PostDataSource
import com.nutmeg.core.domain.models.Post
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class PostsRepositoryTest {

    @Mock
    private lateinit var postDataSourceMock: PostDataSource

    @InjectMocks
    private lateinit var sut: PostsRepository


    @Test
    fun test_getPosts_dataSourceGetPosts() = runBlocking {
        //given
        val postsMock = listOf(Post(1, 1, "title", "body"))
        whenever(postDataSourceMock.getPosts()).thenReturn(postsMock)

        //when
        val posts = sut.getPosts()

        //then
        verify(postDataSourceMock).getPosts()
        assertEquals(postsMock, posts)
    }

}