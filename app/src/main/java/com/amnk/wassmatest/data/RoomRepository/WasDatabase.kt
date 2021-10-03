package com.amnk.wassmatest.data.RoomRepository

import androidx.room.Database
import com.amnk.wassmatest.data.model.favoriteImages


@Database(entities = [favoriteImages::class],version = 1 , exportSchema = false)
abstract class WasDatabase {


}