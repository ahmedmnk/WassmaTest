package com.amnk.wassmatest.data.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amnk.wassmatest.app.Either
import com.amnk.wassmatest.app.apiInjection
import com.amnk.wassmatest.app.constants.ContentType
import com.amnk.wassmatest.app.constants.charset
import com.amnk.wassmatest.data.model.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RemoteRepository : Repository {
    //inject API object
    val Api = apiInjection.provideWasApi()

    //implement comment API
    override fun createComment(request: CreatePostRequest): LiveData<Either<CreatePostResponse>> {
        val liveData = MutableLiveData<Either<CreatePostResponse>>()

        Api.createComment(ContentType, charset,request).enqueue(object : Callback<CreatePostResponse>
        {
            override fun onResponse(
                call: Call<CreatePostResponse>,
                response: Response<CreatePostResponse>
            ) {
                if (response.isSuccessful)
                {
                    liveData.value = Either.success(response.body())
                }
                if (response.code() == 404)
                {
                    val jsonObj = JSONObject(response.errorBody()?.string()!!)
                    liveData.value = Either.error(ApiError.NotFound,response.body(),jsonObj)
                }
                else
                {
                    val jsonObj = JSONObject(response.errorBody()?.string()!!)
                    liveData.value = Either.error(ApiError.Error,response.body(),jsonObj)
                }
            }
            override fun onFailure(call: Call<CreatePostResponse>, t: Throwable) {
                liveData.value = Either.error(ApiError.Error,null,null)
            }


        })
        return liveData
    }
    //implement get images API
    override fun getImages(): LiveData<Either<getImagesResponse>> {
        TODO("Not yet implemented")
    }

     //get all posts
    override fun getAllPosts(): LiveData<Either<getAllPostsResponse>> {
        val liveData = MutableLiveData<Either<getAllPostsResponse>>()

        Api.getAllPost(ContentType, charset).enqueue(object : Callback<getAllPostsResponse>
        {
            override fun onResponse(call: Call<getAllPostsResponse>,response: Response<getAllPostsResponse>)
            {
                if (response.isSuccessful)
                {
                    liveData.value = Either.success(response.body())
                }
                if (response.code() == 404)
                {
                    val jsonObj = JSONObject(response.errorBody()?.string()!!)
                    liveData.value = Either.error(ApiError.NotFound,response.body(),jsonObj)
                }
            }

            override fun onFailure(call: Call<getAllPostsResponse>, t: Throwable)
            {
                liveData.value = Either.error(ApiError.Error,null,null)
            }


        })
        return liveData
    }
    //get all comments based on post
    override fun getAllComments(request : getCommentsRequest): LiveData<Either<getCommentsResponse>> {
        val liveData = MutableLiveData<Either<getCommentsResponse>>()

        Api.getAllComments(ContentType, charset,request.postId).enqueue(object : Callback<getCommentsResponse>
        {
            override fun onResponse(call: Call<getCommentsResponse>,response: Response<getCommentsResponse>)
            {
                if (response.isSuccessful)
                {
                    liveData.value = Either.success(response.body())
                }
                if (response.code() == 404)
                {
                    val jsonObj = JSONObject(response.errorBody()?.string()!!)
                    liveData.value = Either.error(ApiError.NotFound,response.body(),jsonObj)
                }
                else
                {
                    val jsonObj = JSONObject(response.errorBody()?.string()!!)
                    liveData.value = Either.error(ApiError.Error,response.body(),jsonObj)
                }
            }
            override fun onFailure(call: Call<getCommentsResponse>, t: Throwable)
            {
                liveData.value = Either.error(ApiError.Error,null,null)
            }


        })
            return liveData
    }
}