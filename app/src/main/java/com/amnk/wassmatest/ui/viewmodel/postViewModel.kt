package com.amnk.wassmatest.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.amnk.wassmatest.app.Either
import com.amnk.wassmatest.app.apiInjection
import com.amnk.wassmatest.data.model.getAllPostsResponse

class postViewModel (applicationView : Application) : AndroidViewModel(applicationView)
{
    private val apiRepository  = apiInjection.provideRepository()

    fun getAllPosts(): LiveData<Either<getAllPostsResponse>> {

        return apiRepository.getAllPosts()
    }


}