package com.mvvmlist.base

sealed class NavigationDestination {
    data class User(val userId: Int) : NavigationDestination()
}