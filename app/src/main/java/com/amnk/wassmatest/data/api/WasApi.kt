package com.amnk.wassmatest.data.api

import com.amnk.wassmatest.data.model.*
import retrofit2.Call
import retrofit2.http.*

interface WasApi {

    //prepare all API's with header and body

    //Create a post
    @POST("posts")
    fun createComment(
        @Header("Content-Type") ContentType : String,
        @Header("charset") Charset : String,
        @Body createCommentsRequest : CreatePostRequest) : Call<CreatePostResponse>

    //get all posts
    @GET("posts")
    fun getAllPost(
        @Header("Content-Type") ContentType : String,
        @Header("charset") Charset : String) : Call<getAllPostsResponse>

    //get comments based on post id
    @GET("/posts/{postId}/comments")
    fun getAllComments(
        @Header("Content-Type") ContentType : String,
        @Header("charset") Charset : String,
        @Path("postId") postId : Int ) : Call<getCommentsResponse>

    //get all images
    @GET("albums/1/photos")
    fun getImages(
        @Header("Content-Type") ContentType : String,
        @Header("charset") Charset : String): Call<getImagesResponse>
}