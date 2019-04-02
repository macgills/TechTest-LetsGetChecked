package com.example.letsgetcheckedapplication.model

data class BlogComment(
    val id: Int,
    val postId: Int,
    val parent_id: Int?,
    val user: String,
    val date: String,
    val content: String
)
