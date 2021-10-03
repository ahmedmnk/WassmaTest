package com.amnk.wassmatest.data.model

class getCommentsResponse : ArrayList<getCommentsResponseItem>()

data class getCommentsResponseItem(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)