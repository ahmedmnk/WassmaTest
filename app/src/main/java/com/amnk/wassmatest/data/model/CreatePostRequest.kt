package com.amnk.wassmatest.data.model

data class CreatePostRequest(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)