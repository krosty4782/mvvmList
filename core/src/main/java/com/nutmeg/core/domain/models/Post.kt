package com.nutmeg.core.domain.models

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)