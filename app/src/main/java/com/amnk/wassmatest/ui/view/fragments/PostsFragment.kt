package com.amnk.wassmatest.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.amnk.wassmatest.R
import com.amnk.wassmatest.app.Either
import com.amnk.wassmatest.data.model.ApiStatus
import com.amnk.wassmatest.data.model.getAllPostsResponse
import com.amnk.wassmatest.data.model.getAllPostsResponseItem
import com.amnk.wassmatest.ui.view.Adapters.allPostsAdapter
import com.amnk.wassmatest.ui.view.Adapters.onPostClickListener
import com.amnk.wassmatest.ui.viewmodel.postViewModel
import kotlinx.android.synthetic.main.fragment_posts.*


class PostsFragment : Fragment(), onPostClickListener {
    private lateinit var postViewModelObj : postViewModel
    private lateinit var adapter : allPostsAdapter
    private var allposts: List<getAllPostsResponseItem> = emptyList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        postViewModelObj = ViewModelProviders.of(this).get(postViewModel::class.java)
        adapter = allPostsAdapter(allposts, this, postViewModelObj)
        postViewModelObj.getAllPosts().observe(viewLifecycleOwner,
            Observer<Either<getAllPostsResponse>>
            {
                if(it.status == ApiStatus.SUCCESS)
                {
                    var a = it.data
                    makeText(this.activity,"Successful Get All posts fetched", Toast.LENGTH_LONG).show()
                  
                }
                else
                {
                    makeText(this.activity,"Failed Get All posts fetched", Toast.LENGTH_LONG).show()

                }

            }

        )
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }



    override fun onClick(posts: getAllPostsResponse, position: Int, view: View) {
        TODO("Not yet implemented")
    }


}