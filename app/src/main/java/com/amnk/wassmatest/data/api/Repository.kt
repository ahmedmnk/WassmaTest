package com.amnk.wassmatest.data.api

import androidx.lifecycle.LiveData
import com.amnk.wassmatest.app.Either
import com.amnk.wassmatest.data.model.*

interface Repository
{

    fun createComment(request : CreatePostRequest) : LiveData<Either<CreatePostResponse>>
    fun getImages() : LiveData <Either<getImagesResponse>>
    fun getAllPosts() : LiveData<Either<getAllPostsResponse>>
    fun getAllComments(request : getCommentsRequest) : LiveData<Either<getCommentsResponse>>

}