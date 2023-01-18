package com.nutmeg.mvvmlist.repositories

import com.nutmeg.data.services.UsersService
import com.nutmeg.domain.models.Address
import com.nutmeg.domain.models.User
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class UsersDataSourceTest {


    @Test
    fun test_getUsers_returnListUsers() {

        runTest {
            //given
            val mockUsersService = mock<UsersService>()
            val sut = UsersDataSource(mockUsersService)
            val mockList = listOf(User(12, "name", "username", "email",
                Address("street", "suite", "city", "zipcode"),"phone1","website1"
            ))
            whenever(mockUsersService.getUsers()).thenReturn(mockList)

            //when
            val userList = sut.getUsers()

            //then
            assertEquals(mockList, userList)
        }
    }
}