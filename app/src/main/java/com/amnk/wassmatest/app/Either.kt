package com.amnk.wassmatest.app

import com.amnk.wassmatest.data.model.ApiError
import com.amnk.wassmatest.data.model.ApiStatus
import org.json.JSONObject

data class Either<out T>(val status : ApiStatus, val data :T?, val error : ApiError?, val jsomMsg : JSONObject?)
{
    companion object
    {
      fun <T> success (data : T?) : Either<T>
      {
          return Either(ApiStatus.SUCCESS,data,null,null)
      }

      fun <T> error(error : ApiError , data :T? , jsonMsg : JSONObject?) : Either<T>
      {
          return Either(ApiStatus.ERROR,data,error,jsonMsg)
      }

    }
}