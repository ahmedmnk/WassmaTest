package com.amnk.wassmatest.data.model

class getImagesResponse : ArrayList<getImagesResponseItem>()

data class getImagesResponseItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)