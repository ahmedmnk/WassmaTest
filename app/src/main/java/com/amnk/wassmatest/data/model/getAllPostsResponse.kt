package com.amnk.wassmatest.data.model

class getAllPostsResponse : ArrayList<getAllPostsResponseItem>()

data class getAllPostsResponseItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)