package com.amnk.wassmatest.data.model

import androidx.room.Entity

@Entity(tableName = "favoriteImages_table")
data class favoriteImages (
val albumId : Int,
val id : Int,
val title : String,
val url : String,
val thumbnailUrl : String)
