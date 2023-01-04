package com.nutmeg.core.domain.models

// Just adding the two objects for simplicity,
// we could flatten and merge Post and User if needed
data class PostWithUser(val post: Post, val user: User)