package com.amnk.wassmatest.data.model

data class CreatePostResponse(
    val body: String,
    val id: Int = 101,
    val title: String,
    val userId: Int =1
)